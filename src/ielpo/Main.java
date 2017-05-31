package ielpo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author ALBERTO IELPO
 * @version 1.0
 * More info on www.ielpo.net
 *
 */
public class Main {

	
	/**
	 * CHECK IF THE SUDOKU IS FULLY RESOLVED
	 * @param source
	 * @return
	 */
	private static boolean stillWorkToDo(Sudoku sudoku){
		Integer[][] source = sudoku.getSudoku();
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(source[i][j] == null){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This function print the resolved Sudoku and return the solution by String
	 * @param sudoku
	 * @return
	 */
	private static String printResults(Sudoku sudoku, boolean stdout_enable){
		StringBuilder sb = new StringBuilder("");
		Integer[][] source = sudoku.getSudoku();
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				Integer printable = 0;
				if(source[i][j] != null){
					printable = source[i][j];
				}
				if(stdout_enable){
					System.out.print(printable + " ");
				}
				sb.append(printable + " ");
			}
			if(stdout_enable){
				System.out.println("");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param suitable
	 * @param stdout_enable
	 * @return
	 */
	private static String printSuitable(Suitable suitable, boolean stdout_enable){

		StringBuilder sb = new StringBuilder("");
		Integer[][][] source = suitable.getSuitable();
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(stdout_enable){
					System.out.print("[");
				}
				sb.append("[");
				for(int k=0; k<9; k++){
					Integer printable = 0;
					if(source[i][j][k] != null){
						printable = source[i][j][k];
					}
					if(printable != 0){
						if(stdout_enable){
							System.out.print(" " + printable);
						}
						sb.append(" " + printable);
					}
					
				}
				if(stdout_enable){
					System.out.print(" ]");
				}
				sb.append("]");
			}
			if(stdout_enable){
				System.out.println("");
			}
			sb.append("\n");
		}
		return sb.toString();
	
	}
	
	/**
	 * Print line separator
	 */
	private static void printLineSeparator(){
		System.out.println("=================================");
	}
	
	/**
	 * HELP FUNCTION
	 * If something goes wrong in the init phase this function is gonna be invoked
	 */
	private static void help(){
		printLineSeparator();
		System.out.println("Sudoku Resolver - How to use");
		System.out.println("> java -jar sudoku.jar [MODE]");
		System.out.println("MODE 0:DEFAULT, 1:SPECIFY_PATH, 2:INPUT_STREAM");
		System.out.println("Please check the sudoku.csv configuration file or the input if used MODE 2");
		System.out.println("For futher info please see README.txt in the root folder");

	}
	
	/**
	 * 
	 * @param sudoku
	 * @param suitable
	 * @param EXIT_CONST
	 * @return
	 */
	private static Integer solveSudoku(Sudoku sudoku, Suitable suitable, Integer EXIT_CONST){
		System.out.println("--> Solve Sudoku");
		int loop = 1;
		
		/* * To avoid infine loop is set the EXIT_CONST * */
		while(stillWorkToDo(sudoku) && loop < EXIT_CONST){
			/* * Looking for the unique value in the total-matrix * */
			for(int row = 0; row < 9 ; row ++){
				for(int col = 0; col < 9; col ++){
					if(sudoku.thisPlaceIsEmpty(row, col)){
						Integer unique = suitable.getUnique(row, col);
						if(unique != null){
							/* * If suitable is unique than is possible to set in the sudoku matrix * */
							sudoku.setSudokuPosition(row, col, unique);
														 
							/* * Update the suitable matrix * */
							suitable.updateSuitable(row, col, unique);
						}		
					}
				}
			}
		
			/* Looking for the unique value in the Q-Matrix */

			for(int row = 0; row < 9 ; row ++){
				for(int col = 0; col < 9; col ++){
					if(sudoku.thisPlaceIsEmpty(row, col)){
						Integer uniqueInTheQ = suitable.getUniqueInTheQ(row, col);
						if(uniqueInTheQ != null){
							if(!sudoku.existsNumberOnARow(uniqueInTheQ, row)){
								if(!sudoku.existsNumberOnAColumn(uniqueInTheQ, col)){
									/* * if suitable is unique than is possible to set in the sudoku matrix * */
									sudoku.setSudokuPosition(row, col, uniqueInTheQ);
																
									/* * update the suitable matrix * */
									suitable.updateSuitable(row, col, uniqueInTheQ);
									
								}
							}
						}
					}
				}
			}

			/* 
			 * In the suitable matrix I have a situation of indecision
			 */
			if(!suitable.isSuitableValid() && stillWorkToDo(sudoku)){
				System.out.println("Suitable matrix not valid");
				/* BETA */
				boolean result = suitable.forceIndecision();
				System.out.println("Test with less cardinality: " + result);
			}
			
			loop++;

		}
		
		System.out.println("<-- Solve Sudoku");
		return loop;
	}
	
	/**
	 * 
	 * @param loop
	 * @param EXIT_CONST
	 * @param suitable
	 * @param sudoku
	 * @param res
	 * @param sourceSudoku
	 * @param OUTPUT_FOLDER
	 */
	private static void finalChecksAndSave(Integer loop, Integer EXIT_CONST, Suitable suitable, 
			Sudoku sudoku, String res, String sourceSudoku, String OUTPUT_FOLDER){
		
		if(loop.equals(EXIT_CONST)){
			/* * Something went wrong .. * */
			printLineSeparator();
			System.out.println("Sooob :( ... I was not able to resolve it ");
			printLineSeparator();
			System.out.println("Last suitable table");
			printSuitable(suitable, true);

						
		}else{
			/* * * */
			System.out.println("Do you want to save the results? [y/N]");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String i1,line1;
			try {
				if((i1=br.readLine())!=null){ 
					line1 = i1;
					if("y".equalsIgnoreCase(line1)){
						File dir = new File(OUTPUT_FOLDER);
						if(!dir.exists()){
							dir.mkdir();
						}
						
						String path = OUTPUT_FOLDER + File.separator;
						long datetime = new Date().getTime();
						
						String resultDestination =  path + "result" + datetime + ".csv";
						BufferedWriter bw = new BufferedWriter(new FileWriter(new File(resultDestination)));
												
						String sourceDestination = path + "source" + datetime + ".csv";
						BufferedWriter bw2 = new BufferedWriter(new FileWriter(new File(sourceDestination)));

						/* * Write to file */
						bw.write(res);
						bw2.write(sourceSudoku);
						
						System.out.println("Result file saved in: " + resultDestination);
						System.out.println("Source file saved in: " + sourceDestination);

						/* * Free the resources * */
						bw.close();
						bw2.close();
					}
				}
				
			} catch (IOException e) {
				System.out.println("I/O error - That's bad :( ");
				printLineSeparator();
				e.printStackTrace();
			}finally{
				try{
					br.close();
				}catch(Exception e){
					System.out.println("Input error :/ ");
					printLineSeparator();
					e.printStackTrace();
				}
				
			}

		}		
	}
	
	
	/*
	 * SUDOKU RULES
	 * ================== 
	 * In order to complete the puzzle, you must fill each cell with a number between 1 and 9, 
	 * inclusive, such that no number is wrepeated in any row, column or 3x3 box.
	 * In a solved sudoku, each row, column, and 3x3 box contains all the numbers 1 through 9.
     * Each puzzle has only one solution.
	 */
	public static void main(String[] args) {
		
		System.out.println("START: "+ new Date());

		/*
		 * DEFAULT CONFIG PATH - ./sudoku.csv  
		 */
		Mode mode = Mode.DEFAULT;
		String sourcePath = "sudoku.csv";
		
		/*
		 * 
		 */
		final Integer EXIT_CONST = 10000;
		final String OUTPUT_FOLDER = "solutions";
		
		if(args.length > 0 && args[0] != null){
			mode = Mode.getMode(args[0]);
			
			if(Mode.SPECIFY_PATH.equals(mode)){
				if(args.length > 1 && args[1] != null){
					sourcePath = args[1];
				}else{
					System.out.println("ERROR: sudoku.csv path is missing");
					help();
					return;
				}
			}
		}
		
		/* * Sudoku Matrix * */
		Sudoku sudoku = new Sudoku();
		
		/* * Suitable combinations matrix * */
		Suitable suitable = new Suitable();
			
		String sourceSudoku ="";
		
		try{
			/* * Init data from a text/csv file * */
			sudoku.init(mode, sourcePath);
			sourceSudoku = printResults(sudoku, false);
			printLineSeparator();
			
		}catch(Exception e){
			/*
			 * Initialization failed
			 * Show help and finish
			 */
			System.out.println("ERROR: " + e.getMessage());
			help();
			printLineSeparator();
			System.out.println("END: "+ new Date());
			return;
		}
		
		/* * Calculation of the suitable matrix * */
		for(int row = 0; row < 9 ; row ++){
			for(int col = 0; col < 9; col ++){
				if(sudoku.thisPlaceIsEmpty(row, col)){
					ArrayList<Integer> numbersNotInQ = sudoku.getNumbersNotInTheQ(sudoku.getQByRowCol(row, col));
					int index=0;
					for(Integer number: numbersNotInQ){
						if(!sudoku.existsNumberOnARow(number, row)){
							if(!sudoku.existsNumberOnAColumn(number, col)){
								/* 
								 * A number is suitable if is unique in the row,
								 * in the column and in the square "Q"
								 */
								suitable.setSuitablePosition(row, col, index, number);
								index++;
							}
						}
					}	
				}
			}
		}
		
		printSuitable(suitable, true);
		printLineSeparator();
		
		/* * Resolve Sudoku * */
		Integer loop = solveSudoku(sudoku, suitable, EXIT_CONST);
						
		/* * Show results */
		String res = printResults(sudoku, true);

		/* * Check if results are valid * */
		finalChecksAndSave(loop, EXIT_CONST, suitable, sudoku, res, sourceSudoku, OUTPUT_FOLDER);
		
		/* * End * */
		printLineSeparator();
		System.out.println("END: "+ new Date());

	}
}
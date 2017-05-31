package ielpo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sudoku {
	/*
	 * Q0 Q1 Q2
	 * Q3 Q4 Q5
	 * Q6 Q7 Q8
	 */
	private Integer sudoku[][] = new Integer[9][9];
	
	public Sudoku(){
		
	}
	
	public Sudoku(Sudoku s){
		Integer[][] su = s.getSudoku();
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				this.sudoku[i][j] = su[i][j];
			}
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Integer[][] getSudoku(){
		return this.sudoku;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @param value
	 */
	public void setSudokuPosition(Integer row, Integer col, Integer value){
		this.sudoku[row][col] = value;
	}
	
	/**
	 * INIT METHOD - DEBUG
	 */
	public void init_debug(){
		sudoku[0][0]=1;	sudoku[0][1]=null;	sudoku[0][2]=5;	sudoku[0][3]=null;	sudoku[0][4]=null;	sudoku[0][5]=null;	sudoku[0][6]=null;	sudoku[0][7]=null;	sudoku[0][8]=null;
		sudoku[1][0]=null;	sudoku[1][1]=7;	sudoku[1][2]=2;	sudoku[1][3]=null;	sudoku[1][4]=null;	sudoku[1][5]=5;	sudoku[1][6]=null;	sudoku[1][7]=null;	sudoku[1][8]=null;
		sudoku[2][0]=3;	sudoku[2][1]=9;	sudoku[2][2]=null;	sudoku[2][3]=null;	sudoku[2][4]=7;	sudoku[2][5]=null;	sudoku[2][6]=2;	sudoku[2][7]=null;	sudoku[2][8]=8;
		sudoku[3][0]=null;	sudoku[3][1]=5;	sudoku[3][2]=1;	sudoku[3][3]=null;	sudoku[3][4]=6;	sudoku[3][5]=8;	sudoku[3][6]=null;	sudoku[3][7]=3;	sudoku[3][8]=null;
		sudoku[4][0]=null;	sudoku[4][1]=null;	sudoku[4][2]=null;	sudoku[4][3]=1;	sudoku[4][4]=null;	sudoku[4][5]=3;	sudoku[4][6]=null;	sudoku[4][7]=null;	sudoku[4][8]=null;
		sudoku[5][0]=null;	sudoku[5][1]=3;	sudoku[5][2]=null;	sudoku[5][3]=2;	sudoku[5][4]=5;	sudoku[5][5]=null;	sudoku[5][6]=8;	sudoku[5][7]=1;	sudoku[5][8]=null;
		sudoku[6][0]=9;	sudoku[6][1]=null;	sudoku[6][2]=3;	sudoku[6][3]=null;	sudoku[6][4]=1;	sudoku[6][5]=null;	sudoku[6][6]=null;	sudoku[6][7]=2;	sudoku[6][8]=7;
		sudoku[7][0]=null;	sudoku[7][1]=null;	sudoku[7][2]=null;	sudoku[7][3]=4;	sudoku[7][4]=null;	sudoku[7][5]=null;	sudoku[7][6]=6;	sudoku[7][7]=8;	sudoku[7][8]=null;
		sudoku[8][0]=null;	sudoku[8][1]=null;	sudoku[8][2]=null;	sudoku[8][3]=null;	sudoku[8][4]=null;	sudoku[8][5]=null;	sudoku[8][6]=4;	sudoku[8][7]=null;	sudoku[8][8]=3;

	}
	
	/**
	 * INIT METHOD
	 * @param s
	 * @throws Exception
	 */
	public void init(Mode mode, String path) throws Exception{
		
		BufferedReader br;
		switch(mode){
			case INPUT_STREAM:
				System.out.println("I'm using the input stream as configuration file");
				br = new BufferedReader(new InputStreamReader(System.in));
				break;
				
			case SPECIFY_PATH:
			case DEFAULT:
			default:
				System.out.println("I'm using the configuration file: " + path);
				br = new BufferedReader(new FileReader(path));
				break;
			
		}
		
		String i1,i2,i3,i4,i5,i6,i7,i8,i9;
		String line1="",line2="",line3="",line4="",line5="",line6 = "",line7 = "",line8="",line9="";
	
		if((i1=br.readLine())!=null){ line1 = i1; }
		String[] lineSplitted = line1.split(",");
		if(Utils.isValid(lineSplitted[0])){	sudoku[0][0] = Utils.returnInt(lineSplitted[0]);	}
		if(Utils.isValid(lineSplitted[1])){	sudoku[0][1] = Utils.returnInt(lineSplitted[1]);	}
		if(Utils.isValid(lineSplitted[2])){	sudoku[0][2] = Utils.returnInt(lineSplitted[2]);	}
		if(Utils.isValid(lineSplitted[3])){	sudoku[0][3] = Utils.returnInt(lineSplitted[3]);	}
		if(Utils.isValid(lineSplitted[4])){	sudoku[0][4] = Utils.returnInt(lineSplitted[4]);	}
		if(Utils.isValid(lineSplitted[5])){	sudoku[0][5] = Utils.returnInt(lineSplitted[5]);	}
		if(Utils.isValid(lineSplitted[6])){	sudoku[0][6] = Utils.returnInt(lineSplitted[6]);	}
		if(Utils.isValid(lineSplitted[7])){	sudoku[0][7] = Utils.returnInt(lineSplitted[7]);	}
		if(Utils.isValid(lineSplitted[8])){	sudoku[0][8] = Utils.returnInt(lineSplitted[8]);	}
		
		if((i2=br.readLine())!=null){ line2 = i2; }
		lineSplitted = line2.split(",");
		if(Utils.isValid(lineSplitted[0])){	sudoku[1][0] = Utils.returnInt(lineSplitted[0]);	}
		if(Utils.isValid(lineSplitted[1])){	sudoku[1][1] = Utils.returnInt(lineSplitted[1]);	}
		if(Utils.isValid(lineSplitted[2])){	sudoku[1][2] = Utils.returnInt(lineSplitted[2]);	}
		if(Utils.isValid(lineSplitted[3])){	sudoku[1][3] = Utils.returnInt(lineSplitted[3]);	}
		if(Utils.isValid(lineSplitted[4])){	sudoku[1][4] = Utils.returnInt(lineSplitted[4]);	}
		if(Utils.isValid(lineSplitted[5])){	sudoku[1][5] = Utils.returnInt(lineSplitted[5]);	}
		if(Utils.isValid(lineSplitted[6])){	sudoku[1][6] = Utils.returnInt(lineSplitted[6]);	}
		if(Utils.isValid(lineSplitted[7])){	sudoku[1][7] = Utils.returnInt(lineSplitted[7]);	}
		if(Utils.isValid(lineSplitted[8])){	sudoku[1][8] = Utils.returnInt(lineSplitted[8]);	}
		
		if((i3=br.readLine())!=null){ line3 = i3; }
		lineSplitted = line3.split(",");
		if(Utils.isValid(lineSplitted[0])){	sudoku[2][0] = Utils.returnInt(lineSplitted[0]);	}
		if(Utils.isValid(lineSplitted[1])){	sudoku[2][1] = Utils.returnInt(lineSplitted[1]);	}
		if(Utils.isValid(lineSplitted[2])){	sudoku[2][2] = Utils.returnInt(lineSplitted[2]);	}
		if(Utils.isValid(lineSplitted[3])){	sudoku[2][3] = Utils.returnInt(lineSplitted[3]);	}
		if(Utils.isValid(lineSplitted[4])){	sudoku[2][4] = Utils.returnInt(lineSplitted[4]);	}
		if(Utils.isValid(lineSplitted[5])){	sudoku[2][5] = Utils.returnInt(lineSplitted[5]);	}
		if(Utils.isValid(lineSplitted[6])){	sudoku[2][6] = Utils.returnInt(lineSplitted[6]);	}
		if(Utils.isValid(lineSplitted[7])){	sudoku[2][7] = Utils.returnInt(lineSplitted[7]);	}
		if(Utils.isValid(lineSplitted[8])){	sudoku[2][8] = Utils.returnInt(lineSplitted[8]);	}
		
		if((i4=br.readLine())!=null){ line4 = i4; }
		lineSplitted = line4.split(",");
		if(Utils.isValid(lineSplitted[0])){	sudoku[3][0] = Utils.returnInt(lineSplitted[0]);	}
		if(Utils.isValid(lineSplitted[1])){	sudoku[3][1] = Utils.returnInt(lineSplitted[1]);	}
		if(Utils.isValid(lineSplitted[2])){	sudoku[3][2] = Utils.returnInt(lineSplitted[2]);	}
		if(Utils.isValid(lineSplitted[3])){	sudoku[3][3] = Utils.returnInt(lineSplitted[3]);	}
		if(Utils.isValid(lineSplitted[4])){	sudoku[3][4] = Utils.returnInt(lineSplitted[4]);	}
		if(Utils.isValid(lineSplitted[5])){	sudoku[3][5] = Utils.returnInt(lineSplitted[5]);	}
		if(Utils.isValid(lineSplitted[6])){	sudoku[3][6] = Utils.returnInt(lineSplitted[6]);	}
		if(Utils.isValid(lineSplitted[7])){	sudoku[3][7] = Utils.returnInt(lineSplitted[7]);	}
		if(Utils.isValid(lineSplitted[8])){	sudoku[3][8] = Utils.returnInt(lineSplitted[8]);	}
		
		if((i5=br.readLine())!=null){ line5 = i5; }
		lineSplitted = line5.split(",");
		if(Utils.isValid(lineSplitted[0])){	sudoku[4][0] = Utils.returnInt(lineSplitted[0]);	}
		if(Utils.isValid(lineSplitted[1])){	sudoku[4][1] = Utils.returnInt(lineSplitted[1]);	}
		if(Utils.isValid(lineSplitted[2])){	sudoku[4][2] = Utils.returnInt(lineSplitted[2]);	}
		if(Utils.isValid(lineSplitted[3])){	sudoku[4][3] = Utils.returnInt(lineSplitted[3]);	}
		if(Utils.isValid(lineSplitted[4])){	sudoku[4][4] = Utils.returnInt(lineSplitted[4]);	}
		if(Utils.isValid(lineSplitted[5])){	sudoku[4][5] = Utils.returnInt(lineSplitted[5]);	}
		if(Utils.isValid(lineSplitted[6])){	sudoku[4][6] = Utils.returnInt(lineSplitted[6]);	}
		if(Utils.isValid(lineSplitted[7])){	sudoku[4][7] = Utils.returnInt(lineSplitted[7]);	}
		if(Utils.isValid(lineSplitted[8])){	sudoku[4][8] = Utils.returnInt(lineSplitted[8]);	}
		
		if((i6=br.readLine())!=null){ line6 = i6; }
		lineSplitted = line6.split(",");
		if(Utils.isValid(lineSplitted[0])){	sudoku[5][0] = Utils.returnInt(lineSplitted[0]);	}
		if(Utils.isValid(lineSplitted[1])){	sudoku[5][1] = Utils.returnInt(lineSplitted[1]);	}
		if(Utils.isValid(lineSplitted[2])){	sudoku[5][2] = Utils.returnInt(lineSplitted[2]);	}
		if(Utils.isValid(lineSplitted[3])){	sudoku[5][3] = Utils.returnInt(lineSplitted[3]);	}
		if(Utils.isValid(lineSplitted[4])){	sudoku[5][4] = Utils.returnInt(lineSplitted[4]);	}
		if(Utils.isValid(lineSplitted[5])){	sudoku[5][5] = Utils.returnInt(lineSplitted[5]);	}
		if(Utils.isValid(lineSplitted[6])){	sudoku[5][6] = Utils.returnInt(lineSplitted[6]);	}
		if(Utils.isValid(lineSplitted[7])){	sudoku[5][7] = Utils.returnInt(lineSplitted[7]);	}
		if(Utils.isValid(lineSplitted[8])){	sudoku[5][8] = Utils.returnInt(lineSplitted[8]);	}
		
		if((i7=br.readLine())!=null){ line7 = i7; }
		lineSplitted = line7.split(",");
		if(Utils.isValid(lineSplitted[0])){	sudoku[6][0] = Utils.returnInt(lineSplitted[0]);	}
		if(Utils.isValid(lineSplitted[1])){	sudoku[6][1] = Utils.returnInt(lineSplitted[1]);	}
		if(Utils.isValid(lineSplitted[2])){	sudoku[6][2] = Utils.returnInt(lineSplitted[2]);	}
		if(Utils.isValid(lineSplitted[3])){	sudoku[6][3] = Utils.returnInt(lineSplitted[3]);	}
		if(Utils.isValid(lineSplitted[4])){	sudoku[6][4] = Utils.returnInt(lineSplitted[4]);	}
		if(Utils.isValid(lineSplitted[5])){	sudoku[6][5] = Utils.returnInt(lineSplitted[5]);	}
		if(Utils.isValid(lineSplitted[6])){	sudoku[6][6] = Utils.returnInt(lineSplitted[6]);	}
		if(Utils.isValid(lineSplitted[7])){	sudoku[6][7] = Utils.returnInt(lineSplitted[7]);	}
		if(Utils.isValid(lineSplitted[8])){	sudoku[6][8] = Utils.returnInt(lineSplitted[8]);	}
		
		if((i8=br.readLine())!=null){ line8 = i8; }
		lineSplitted = line8.split(",");
		if(Utils.isValid(lineSplitted[0])){	sudoku[7][0] = Utils.returnInt(lineSplitted[0]);	}
		if(Utils.isValid(lineSplitted[1])){	sudoku[7][1] = Utils.returnInt(lineSplitted[1]);	}
		if(Utils.isValid(lineSplitted[2])){	sudoku[7][2] = Utils.returnInt(lineSplitted[2]);	}
		if(Utils.isValid(lineSplitted[3])){	sudoku[7][3] = Utils.returnInt(lineSplitted[3]);	}
		if(Utils.isValid(lineSplitted[4])){	sudoku[7][4] = Utils.returnInt(lineSplitted[4]);	}
		if(Utils.isValid(lineSplitted[5])){	sudoku[7][5] = Utils.returnInt(lineSplitted[5]);	}
		if(Utils.isValid(lineSplitted[6])){	sudoku[7][6] = Utils.returnInt(lineSplitted[6]);	}
		if(Utils.isValid(lineSplitted[7])){	sudoku[7][7] = Utils.returnInt(lineSplitted[7]);	}
		if(Utils.isValid(lineSplitted[8])){	sudoku[7][8] = Utils.returnInt(lineSplitted[8]);	}
		
		if((i9=br.readLine())!=null){ line9 = i9; }
		lineSplitted = line9.split(",");
		if(Utils.isValid(lineSplitted[0])){	sudoku[8][0] = Utils.returnInt(lineSplitted[0]);	}
		if(Utils.isValid(lineSplitted[1])){	sudoku[8][1] = Utils.returnInt(lineSplitted[1]);	}
		if(Utils.isValid(lineSplitted[2])){	sudoku[8][2] = Utils.returnInt(lineSplitted[2]);	}
		if(Utils.isValid(lineSplitted[3])){	sudoku[8][3] = Utils.returnInt(lineSplitted[3]);	}
		if(Utils.isValid(lineSplitted[4])){	sudoku[8][4] = Utils.returnInt(lineSplitted[4]);	}
		if(Utils.isValid(lineSplitted[5])){	sudoku[8][5] = Utils.returnInt(lineSplitted[5]);	}
		if(Utils.isValid(lineSplitted[6])){	sudoku[8][6] = Utils.returnInt(lineSplitted[6]);	}
		if(Utils.isValid(lineSplitted[7])){	sudoku[8][7] = Utils.returnInt(lineSplitted[7]);	}
		if(Utils.isValid(lineSplitted[8])){	sudoku[8][8] = Utils.returnInt(lineSplitted[8]);	}
		
	}
	
	/**
	 * 
	 * @param s
	 * @param minR
	 * @param maxR
	 * @param minC
	 * @param maxC
	 * @return
	 */
	private Integer[][] getGenericQ(Integer s[][], Integer minR, Integer maxR, Integer minC, Integer maxC){
		Integer[][] q = new Integer[3][3];
		for(int a=0, i=minR; i<maxR; i++, a++){
			for(int b=0, j=minC; j<maxC; j++, b++){
				q[a][b] = s[i][j];
			}
		}
		return q;
	}	
	
	/*
	 * 0,0 0,1 0,2
	 * 1,0 1,1 1,2
	 * 2,0 2,1 2,2
	 */
	public Integer[][] getQ0(){
		Integer[][] q0 = getGenericQ(this.sudoku,0,3,0,3);
		return q0;
	}
	
	/*
	 * 0,3 0,4 0,5
	 * 1,3 1,4 1,5
	 * 2,3 2,4 2,5
	 */
	public Integer[][] getQ1(){
		Integer[][] q1 = getGenericQ(this.sudoku,0,3,3,6);
		return q1;
	}
	
	/*
	 * 0,6 0,7 0,8
	 * 1,6 1,7 1,8
	 * 2,6 2,7 2,8
	 */
	public Integer[][] getQ2(){
		Integer[][] q2 = getGenericQ(this.sudoku,0,3,6,9);
		return q2;
	}

	/*
	 * 3,0 3,1 3,2
	 * 4,0 4,1 4,2
	 * 5,0 5,1 5,2
	 */
	public Integer[][] getQ3(){
		Integer[][] q3 = getGenericQ(this.sudoku,3,6,0,3);
		return q3;
	}

	/*
	 * 3,3 3,4 3,5
	 * 4,3 4,4 4,5
	 * 5,3 5,4 5,5
	 */
	public Integer[][] getQ4(){
		Integer[][] q4 = getGenericQ(this.sudoku,3,6,3,6);
		return q4;
	}
	
	/*
	 * 3,6 3,7 3,8
	 * 4,6 4,7 4,8
	 * 5,6 5,7 5,8
	 */
	public Integer[][] getQ5(){
		Integer[][] q5 = getGenericQ(this.sudoku,3,6,6,9);
		return q5;
	}
	
	/*
	 * 6,0 6,1 6,2
	 * 7,0 7,1 7,2
	 * 8,0 8,1 8,2
	 */
	public Integer[][] getQ6(){
		Integer[][] q6 = getGenericQ(this.sudoku,6,9,0,3);
		return q6;
	}

	/*
	 * 6,3 6,4 6,5
	 * 7,3 7,4 7,5
	 * 8,3 8,4 8,5
	 */
	public Integer[][] getQ7(){
		Integer[][] q7 = getGenericQ(this.sudoku,6,9,3,6);
		return q7;
	}

	/*
	 * 6,6 6,7 6,8
	 * 7,6 7,7 7,8
	 * 8,8 8,8 8,8
	 */
	public Integer[][] getQ8(){
		Integer[][] q8 = getGenericQ(this.sudoku,6,9,6,9);
		return q8;
	}

	public boolean thisPlaceIsEmpty(Integer row, Integer column){
		return (this.sudoku[row][column] == null ? true : false);
	}

	/**
	 * GET ALL THE NUMBER NOT IN THE Q
	 * @param source
	 * @return
	 */
	public ArrayList<Integer> getNumbersNotInTheQ(Integer source[][]){
		ArrayList<Integer> results = new ArrayList<Integer>();
		for(int i=1; i<10; i++){
			if(!find(source, i)){
				results.add(i);
			}
		}
		return results;
	}
	
	/**
	 * FIND A VALUE INTO A BIDIMENTIONAL SOURCE 3X3
	 * @param parameter
	 * @param source
	 * @return
	 */
	public boolean find(Integer[][] source, Integer parameter){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(source[i][j] == parameter){
					return true;
				} 
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public Integer[][] getQByRowCol(Integer row, Integer col){
		if(row == 0 || row == 1 || row == 2){
			if(col == 0 || col == 1 || col == 2){
				return getQ0();
			}
		}
		
		if(row == 0 || row == 1 || row == 2){
			if(col == 3 || col == 4 || col == 5){
				return getQ1();
			}
		}
		
		if(row == 0 || row == 1 || row == 2){
			if(col == 6 || col == 7 || col == 8){
				return getQ2();
			}
		}
		
		if(row == 3 || row == 4 || row == 5){
			if(col == 0 || col == 1 || col == 2){
				return getQ3();
			}
		}
		
		if(row == 3 || row == 4 || row == 5){
			if(col == 3 || col == 4 || col == 5){
				return getQ4();
			}
		}
		
		if(row == 3 || row == 4 || row == 5){
			if(col == 6 || col == 7 || col == 8){
				return getQ5();
			}
		}
		
		if(row == 6 || row == 7 || row == 8){
			if(col == 0 || col == 1 || col == 2){
				return getQ6();
			}
		}
		
		if(row == 6 || row == 7 || row == 8){
			if(col == 3 || col == 4 || col == 5){
				return getQ7();
			}
		}
		
		if(row == 6 || row == 7 || row == 8){
			if(col == 6 || col == 7 || col == 8){
				return getQ8();
			}
		}
		
		return null;
	}

	/**
	 * 
	 * @param number
	 * @param row
	 * @param source
	 * @return
	 */
	public boolean existsNumberOnARow(Integer number, Integer row){
		for(int i=0; i<9; i++){
			if(number != null && this.sudoku[row][i] != null &&
					number == this.sudoku[row][i]){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param number
	 * @param column
	 * @param source
	 * @return
	 */
	public boolean existsNumberOnAColumn(Integer number, Integer column){
		for(int i=0; i<9; i++){
			if(number != null && this.sudoku[i][column] != null && 
					number == this.sudoku[i][column]){
				return true;
			}
		}
		return false;
	}


}

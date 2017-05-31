package ielpo;

import java.util.ArrayList;
import java.util.HashMap;

public class Suitable {
	private Integer suitable[][][] = new Integer[9][9][9];

	public Suitable(){
		
	}
	
	public Integer[][][] getSuitable() {
		return this.suitable;
	}
	
	public void setSuitable(Integer[][][] newSuitable){
		this.suitable = newSuitable;
	}
	
	public void setSuitablePosition(Integer row, Integer col, Integer index, Integer value){
		this.suitable[row][col][index] = value;
	}
	
	public void setSuitablePositionArray(Integer row, Integer col, Integer[] value){
		this.suitable[row][col] = value;
	}

	/**
	 * 
	 * @param unique
	 * @param minR
	 * @param maxR
	 * @param minC
	 * @param maxC
	 */
	private void updateGenericQ(Integer unique, Integer minR, Integer maxR, Integer minC, Integer maxC){
		for(int i=minR; i<maxR; i++){
			for(int j=minC; j<maxC; j++){
				for(int z=0; z<9; z++){
					if(suitable[i][j][z] == unique){
						suitable[i][j][z] = null;
					}
				}
			}
		}
	}	
	
	/*
	 * 0,0 0,1 0,2
	 * 1,0 1,1 1,2
	 * 2,0 2,1 2,2
	 */
	public void updateQ0(Integer unique){
		updateGenericQ(unique,0,3,0,3);
	}
	
	/*
	 * 0,3 0,4 0,5
	 * 1,3 1,4 1,5
	 * 2,3 2,4 2,5
	 */
	public void updateQ1(Integer unique){
		updateGenericQ(unique,0,3,3,6);
	}
	
	/*
	 * 0,6 0,7 0,8
	 * 1,6 1,7 1,8
	 * 2,6 2,7 2,8
	 */
	public void updateQ2(Integer unique){
		updateGenericQ(unique,0,3,6,9);
	}

	/*
	 * 3,0 3,1 3,2
	 * 4,0 4,1 4,2
	 * 5,0 5,1 5,2
	 */
	public void updateQ3(Integer unique){
		updateGenericQ(unique,3,6,0,3);
	}

	/*
	 * 3,3 3,4 3,5
	 * 4,3 4,4 4,5
	 * 5,3 5,4 5,5
	 */
	public void updateQ4(Integer unique){
		updateGenericQ(unique,3,6,3,6);
	}
	
	/*
	 * 3,6 3,7 3,8
	 * 4,6 4,7 4,8
	 * 5,6 5,7 5,8
	 */
	public void updateQ5(Integer unique){
		updateGenericQ(unique,3,6,6,9);
	}
	
	/*
	 * 6,0 6,1 6,2
	 * 7,0 7,1 7,2
	 * 8,0 8,1 8,2
	 */
	public void updateQ6(Integer unique){
		updateGenericQ(unique,6,9,0,3);
	}

	/*
	 * 6,3 6,4 6,5
	 * 7,3 7,4 7,5
	 * 8,3 8,4 8,5
	 */
	public void updateQ7(Integer unique){
		updateGenericQ(unique,6,9,3,6);
	}

	/*
	 * 6,6 6,7 6,8
	 * 7,6 7,7 7,8
	 * 8,8 8,8 8,8
	 */
	public void updateQ8(Integer unique){
		updateGenericQ(unique,6,9,6,9);
		
	}
	
	public void updateQByRowCol(Integer unique, Integer row, Integer col){
		if(row == 0 || row == 1 || row == 2){
			if(col == 0 || col == 1 || col == 2){
				updateQ0(unique);
			}
		}
		
		if(row == 0 || row == 1 || row == 2){
			if(col == 3 || col == 4 || col == 5){
				updateQ1(unique);
			}
		}
		
		if(row == 0 || row == 1 || row == 2){
			if(col == 6 || col == 7 || col == 8){
				updateQ2(unique);
			}
		}
		
		if(row == 3 || row == 4 || row == 5){
			if(col == 0 || col == 1 || col == 2){
				updateQ3(unique);
			}
		}
		
		if(row == 3 || row == 4 || row == 5){
			if(col == 3 || col == 4 || col == 5){
				updateQ4(unique);
			}
		}
		
		if(row == 3 || row == 4 || row == 5){
			if(col == 6 || col == 7 || col == 8){
				updateQ5(unique);
			}
		}
		
		if(row == 6 || row == 7 || row == 8){
			if(col == 0 || col == 1 || col == 2){
				updateQ6(unique);
			}
		}
		
		if(row == 6 || row == 7 || row == 8){
			if(col == 3 || col == 4 || col == 5){
				updateQ7(unique);
			}
		}
		
		if(row == 6 || row == 7 || row == 8){
			if(col == 6 || col == 7 || col == 8){
				updateQ8(unique);
			}
		}
	}
	
	private Integer[][][] getGenericQ(Integer minR, Integer maxR, Integer minC, Integer maxC){
		Integer[][][] q = new Integer[3][3][9];
		for(int a=0, i=minR; i<maxR; i++, a++){
			for(int b=0, j=minC; j<maxC; j++, b++){
				for(int z=0; z<9; z++){
					q[a][b][z] = this.suitable[i][j][z];
				}
			}
		}
		return q;
	}	
	
	/*1
	 * 0,0 0,1 0,2
	 * 1,0 1,1 1,2
	 * 2,0 2,1 2,2
	 */
	public Integer[][][] getQ0(){
		Integer[][][] q0 = getGenericQ(0,3,0,3);
		return q0;
	}
	
	/*
	 * 0,3 0,4 0,5
	 * 1,3 1,4 1,5
	 * 2,3 2,4 2,5
	 */
	public Integer[][][] getQ1(){
		Integer[][][] q1 = getGenericQ(0,3,3,6);
		return q1;
	}
	
	/*
	 * 0,6 0,7 0,8
	 * 1,6 1,7 1,8
	 * 2,6 2,7 2,8
	 */
	public Integer[][][] getQ2(){
		Integer[][][] q2 = getGenericQ(0,3,6,9);
		return q2;
	}

	/*
	 * 3,0 3,1 3,2
	 * 4,0 4,1 4,2
	 * 5,0 5,1 5,2
	 */
	public Integer[][][] getQ3(){
		Integer[][][] q3 = getGenericQ(3,6,0,3);
		return q3;
	}

	/*
	 * 3,3 3,4 3,5
	 * 4,3 4,4 4,5
	 * 5,3 5,4 5,5
	 */
	public Integer[][][] getQ4(){
		Integer[][][] q4 = getGenericQ(3,6,3,6);
		return q4;
	}
	
	/*
	 * 3,6 3,7 3,8
	 * 4,6 4,7 4,8
	 * 5,6 5,7 5,8
	 */
	public Integer[][][] getQ5(){
		Integer[][][] q5 = getGenericQ(3,6,6,9);
		return q5;
	}
	
	/*
	 * 6,0 6,1 6,2
	 * 7,0 7,1 7,2
	 * 8,0 8,1 8,2
	 */
	public Integer[][][] getQ6(){
		Integer[][][] q6 = getGenericQ(6,9,0,3);
		return q6;
	}

	/*
	 * 6,3 6,4 6,5
	 * 7,3 7,4 7,5
	 * 8,3 8,4 8,5
	 */
	public Integer[][][] getQ7(){
		Integer[][][] q7 = getGenericQ(6,9,3,6);
		return q7;
	}

	/*
	 * 6,6 6,7 6,8
	 * 7,6 7,7 7,8
	 * 8,8 8,8 8,8
	 */
	public Integer[][][] getQ8(){
		Integer[][][] q8 = getGenericQ(6,9,6,9);
		return q8;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public Integer[][][] getQByRowCol(Integer row, Integer col){
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
	 * @param row
	 * @param col
	 * @return
	 */
	public Integer getUnique(Integer row, Integer col){
		int unique = 0, res = 0;
		for(int i=0; i<9; i++){
			if(suitable[row][col][i] != null){
				res = suitable[row][col][i];
				unique++;
			}
		}
		
		if(unique != 1){
			return null;
		}
		
		return res;	
		
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public Integer getUniqueInTheQ(Integer row, Integer col){
		Integer res = null;
		Integer qSuitable[][][] = getQByRowCol(row, col);
		HashMap<Integer,Integer> unique = new HashMap<Integer,Integer>();
		
		for(int x=0; x<3; x++){
			for(int y=0; y<3; y++){
				for(int z=0; z<9; z++){
					if(qSuitable[x][y][z] != null){
						if(unique.containsKey(qSuitable[x][y][z])){
							unique.put(qSuitable[x][y][z], 0);
						}else{
							unique.put(qSuitable[x][y][z], 1);
						}
					}
				}
			}
		}
		
		for(Integer e: unique.keySet()){
			if(unique.get(e) == 1){
				res = e;
			}
		}
		
		return res;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @param unique
	 */
	public void updateSuitable(Integer row, Integer col, Integer unique){
		//aggiorno la stessa riga
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(suitable[row][i][j] == unique){
					suitable[row][i][j] = null;
				}
			}
		}
		
		//aggiorno la stessa colonna
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(suitable[i][col][j] == unique){
					suitable[i][col][j] = null;
				}
			}
		}
		
		//aggiorno lo stesso Q
		updateQByRowCol(unique, row, col);
	
	}
	
	/**
	 * Get for each position of suitable the cardinality
	 * @return
	 */
	private Integer[][] getCardinalityMatrix(){
		
		Integer[][] cardinality = new Integer[9][9];
	
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				Integer card = 0;
				for(int k=0; k<9; k++){
					if(suitable[i][j][k] != null){
						card++;
					}
				}
				cardinality[i][j] = card;	
			}
		}

		return cardinality;
	}
	
	public void copySuitable(Integer[][][] oldM, Suitable newMatrix){
		Integer[][][] newM = newMatrix.getSuitable();
		
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				for(int k=0; k<9; k++){
					newM[i][j][k] = oldM[i][j][k];
				}
			}
		}
		
		newMatrix.setSuitable(newM);
	}
	
	/**
	 * Check if the suitable matrix is still valid
	 * @return
	 */
	public boolean isSuitableValid(){
		Integer[][] cardinality = getCardinalityMatrix();
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(cardinality[i][j] != null && cardinality[i][j] == 1){
					return true;
				}
			}
			
		}
		return false;
	}
	
	/**
	 * This function use the first suitable value with "2" cardinality as true
	 * @return
	 */
	public boolean forceIndecision(){

		Integer[][] cardinality = getCardinalityMatrix();
		for(int row=0; row<9; row++){
			for(int col=0; col<9; col++){
				if(cardinality[row][col] == 2){
					Integer[] current = suitable[row][col];
					Integer[] newCurrent = new Integer[9];
					for(int index=0; index<9; index++){
						if(current[index] != null){	
							newCurrent[0] = current[index];
							break;
						}
					}
					suitable[row][col] = newCurrent;
					System.out.println("Test with " + newCurrent[0] + " in the row " + row + " and col " + col);
					return true;
				}
			}
			
		}
		return false;
	
	}
	
	@Deprecated
	public ArrayList<Suitable> getLessCardinality(){
		ArrayList<Suitable> results = new ArrayList<Suitable>();
		Integer[][] cardinality = getCardinalityMatrix();
		boolean notFound = true;
		int minCard = 2;
		int loop = 0;
		while(notFound && loop < 10){
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					if(cardinality[i][j] == minCard){
						Integer[] sol = suitable[i][j];
						for(Integer s: sol){
							if(s != null){
								Suitable sui = new Suitable();
								copySuitable(this.suitable, sui);
								Integer[] insertTest = new Integer[9];
								insertTest[0] = s;
								sui.setSuitablePositionArray(i, j, insertTest);
								results.add(sui);
							}
						}
						
						return results;
					}
				}
			}
			minCard++;
			loop++;
		}
		
		return null;
	}
	

}
package ielpo;

public enum Mode {

	DEFAULT,
	SPECIFY_PATH,
	INPUT_STREAM;
	
	/**
	 * Used to define main args parameters
	 * 0 for default. The source file is gonna be in the same dir of the jar
	 * 1 if you wanna specify a path for the input file
	 * 2 if you wanna use the input stream as input file
	 * @param mode
	 * @return
	 */
	public static Mode getMode(Integer mode){
		switch(mode){
			case 1: 
				return SPECIFY_PATH;
			case 2: 
				return INPUT_STREAM;
			case 0:
			default: 
				return DEFAULT;
		}		
	}
	
	public static Mode getMode(String par){
		Mode mode = Mode.DEFAULT;
		try{
			Integer mo = new Integer(par);
			mode = getMode(mo);
			
		}catch(Exception e){
			//NO PROBLEM
		}
			
		return mode;
		
	}

}
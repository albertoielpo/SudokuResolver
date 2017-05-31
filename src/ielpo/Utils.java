package ielpo;

public class Utils {
	
	/**
	 * A number is valid if is between 0 and 10 (excluded)
	 * @param number
	 * @return
	 */
	public static boolean isValid(String number){
		try{
			Integer res = new Integer(number);
			if(res > 0 && res < 10){
				return true;
			}
			
			return false;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * Convert a String to int and check if it is between 1 and 10 (excluded)
	 * @param number
	 * @return
	 */
	public static int returnInt(String number){
		try{
			int res = new Integer(number);
			if(res > 0 && res < 10){
				return res;
			}
		}catch(Exception e){
			return 0;
		}
		
		return 0;
	}
	
}

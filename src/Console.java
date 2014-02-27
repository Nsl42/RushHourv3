import java.io.*;

public class Console {
	
	/**
	 * Read a single line of text from the console. 
	 * @return A string containing the line read from the console, not including 
	 * any line-termination characters, or null if an end of stream has been reached. 
	 */ 
	public static String readLine() {
	    try {
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	    } catch (IOException e) {
		e.printStackTrace();
		return null;
	    }
	}
	
	/**
	 * Read a boolean value from the console. The user input must be ended by a 
	 * line-termination character.
	 * @return A boolean value read from the console.
	 */ 
	public static boolean readBool() {
		return Boolean.parseBoolean(readLine());
	}
	
	/**
	 * Read a char value from the console. The user input must be ended by a 
	 * line-termination character.
	 * @return A char value read from the console.
	 */ 
	public static char readChar() {
		return readLine().charAt(0);
	}
	
	/**
	 * Read a double value from the console. The user input must be ended by a 
	 * line-termination character.
	 * @return A double value read from the console.
	 */ 
	public static double readDouble() {
		return Double.parseDouble(readLine());
	}
	
	/**
	 * Read a float value from the console. The user input must be ended by a 
	 * line-termination character.
	 * @return A float value read from the console.
	 */ 
	public static float readFloat() {
		return Float.parseFloat(readLine());
	}
	
	/**
	 * Read an integer value from the console. The user input must be ended by a 
	 * line-termination character.
	 * @return An integer value read from the console.
	 */ 
	public static int readInt() {
		try{
			return Integer.parseInt(readLine());
		} 
		
		catch (NumberFormatException f){
	    		System.out.println("This is not a number ! RTFM ! Try again.");
	    		return readInt();
	    	}
	}
	
	/**
	 * Read a long integer value from the console. The user input must be ended by a 
	 * line-termination character.
	 * @return A long integer value read from the console.
	 */ 
	public static long readLong() {
		return Long.parseLong(readLine());
	}
}

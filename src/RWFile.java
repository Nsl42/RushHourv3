import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
/** Allows reading and writing from ArrayList or HashMap to text files.
  * @author Zoé David
  */
public class RWFile {
	/** Read a text file line by line and returns it in a ArrayList<String>.
	  * @param file Text file being read.
	  * @return an ArrayList<String>.
	  */
	public static ArrayList<String> readArrayList (String file){
		
		ArrayList<String> ret = new ArrayList<String>();

		try{
			
			Scanner in = new Scanner(new FileReader (file));
			while (in.hasNextLine()){
				
				ret.add(in.nextLine());
			}

			in.close();
		}

		catch (FileNotFoundException e){
			
			System.out.println (e.getMessage());
		}

		catch (IOException e){
			
			e.printStackTrace();
		}

		return ret;
	}
	/** Writes the content of a specified ArrayList<String> line by line 
	  * in a specified text file.
	  * @param file Text file.
	  * @param list An ArrayList<String>.
	  */
	public static void writeArrayList (String file, ArrayList<String> list){
		
		try{
			
			PrintWriter out = new PrintWriter (file);
			for (String ligne : list){
				
				out.println (ligne);
			}

			out.close();
		}

		catch (FileNotFoundException e){
			
			System.out.println (e.getMessage());
		}

		catch (IOException e){
			
			e.printStackTrace();
		}
	}
	/** Read a text file line by line and returns it in a HashMap<String,String>
	  * @param file Text file being read.
	  * @return an HashMap<String,String>.
	  */
	public static HashMap<String,String> readHashMap (String file){
		
		HashMap<String,String> ret = new HashMap<String,String>();

		try{
			
			Scanner in = new Scanner(new FileReader (file));
			while (in.hasNextLine()){
				
				String chaine = in.nextLine();
				String [] temp = new String [2];
				temp = chaine.split(" : ");
				ret.put(temp[0],temp[1]);
			}

			in.close();
		}

		catch (FileNotFoundException e){
			
			System.out.println (e.getMessage());
		}

		catch (IOException e){
			
			e.printStackTrace();
		}

		return ret;

	}
	/** Writes the content of a specified HashMap<String,String> line by line 
	  * in a specified text file.
	  * @param file Text file.
	  * @param list An HashMap<String,String>.
	  */
	public static void writeHashMap (String file, HashMap<String,String> list){
		
		try{
			
			PrintWriter out = new PrintWriter (file);

			for (String key : list.keySet()) { 
			out.write(key + " : " + list.get(key)+ "\r\n");

			}

			out.close();
		}

		catch (FileNotFoundException e){
			
			System.out.println (e.getMessage());
		}

		catch (IOException e){
			
			e.printStackTrace();
		}
	}
}
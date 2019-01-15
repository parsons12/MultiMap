import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;


public class Anagram {

	public static void main(String[] args) {
		ListMultiMap<String,String> map = new ListMultiMap<String, String>();
		String fname = ("words.txt");
		try {
			File inf = new File(fname);
			Scanner fscan = new Scanner(inf);
			
			while (fscan.hasNext()) {//scan through file and set variables
				String word = fscan.next();
				char c[] = word.trim().toCharArray();        // convert to array of chars 
				Arrays.sort(c);          // sort
				String sortedWord = new String(c);
				map.put(sortedWord, word);
			}
			fscan.close();
		} catch (IOException e) {//if file is not found
			System.out.printf("File %s not found.\n", fname);//if files not found
		}
		
		Set keys = map.keySet();
		for(Object temp: keys) {
			if(map.get((String)temp).size() >= 3) {//finds values with atleast 3 anagrams
				System.out.println(map.get((String)temp));//prints the words
			} 
		}

	}

}

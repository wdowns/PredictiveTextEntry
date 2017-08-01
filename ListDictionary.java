package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Create a class named ListDictionary. In its constructors, you should read the dictionary
 * from a file and store it in an ArrayList. Each entry of the ArrayList must be a pair,
 * consisting of the word that has been read in and its signature. So you will need to
 * create a class named WordSig that pairs words and signatures. 
 * 
 * @author William Downs
 * @version 16/02/16
 */

public class ListDictionary {
	private ArrayList<WordSig> dict;

	/*
	 * This constructs a new ListDictionary Object. It sets dict to a new
	 * ArrayList for the words and signatures to be stored as pairs in a WordSig
	 * object. This words are read from the dictionary file 'words' found in
	 * /usr/share/dict. Invalid words will not be added to the list. The
	 * list is sorted by signature in a natural order using the Collections
	 * sort method.
	 */ 
	
	public ListDictionary() {
		
		BufferedReader reader = null;
		dict = new ArrayList<WordSig>();
		
		try {
			File file = new File("/usr/share/dict/words");
			reader = new BufferedReader(new FileReader(file));
			
			String line;
	
			// Loop through file containing list of words.
			while ((line = reader.readLine()) != null) 
			{
				line = line.toLowerCase();
				// If the word is valid add to dict.
				if (isValidWord(line))
				{ 
					dict.add(new WordSig(line));
				}
			}
		} catch (IOException e) {
			System.out.println("File not found.");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Error when trying to close file ");
			}
		}
		// sort the list by signature in ascending order.
		Collections.sort(dict);
	}

	/*
	 * Method returns the current object's dict variable.
	 */
	public ArrayList<WordSig> getDict() {
		return dict;
	}

	/*
	 * Method prints the dictionary. 
	 */
	public void printDict() {
		for (WordSig ws : dict) {
			System.out.println(ws);
		}
	}
	/**
	 * The method signatureToWords must be re-written as an instance method in the 
	 * ListDictionary class to use the stored dictionary. The ArrayList<WordSig> must be
	 * stored in sorted order and the signatureToWords method must use binary search to
	 * perform the look-ups.
	 * 
	 * This method searches the dictionary using a binary search method to find a given signature.
	 * The BS returns an index where the  signature can be found in the list. Then this method
	 * checks above and below this index for matching signatures. It adds all words to a List that
	 * have matching signature, and returns the list.
	 * @param sig A String representing the signature to convert to words.
	 * @return A list of Strings type words with matching signatures.
	 */
	public Collection<String> signatureToWords(String sig){
		ArrayList<String> words = new ArrayList<String>();
		WordSig searchSig = new WordSig("", sig);
		
		// Method must use binary search to perform look-ups.
		int index = Collections.binarySearch(this.dict, searchSig);
		int max = this.dict.size();
	    if(index >=0){
		    words.add(this.dict.get(index).getWord());
		    
			// Check above for matching sigs.
		    int tempIndex = index;
		    while(this.dict.get(tempIndex).getSignature().equals(sig)){
		    	if(!(words.contains(this.dict.get(tempIndex).getWord()))){
		    		words.add(this.dict.get(tempIndex).getWord());
		    	}
		    	tempIndex--;
		    	if(tempIndex == -1)
		    		break;
		    }
		    // Check below for matching sigs.
		    tempIndex = index;
		    while(this.dict.get(tempIndex).getSignature().equals(sig)){
		    	if(!(words.contains(this.dict.get(tempIndex).getWord()))){
		    		words.add(this.dict.get(tempIndex).getWord());
		    	}
		    	tempIndex++;
		    	if(tempIndex == max)
		    		break;
		    }
	    }
		return words;
}

	/**
	 * The wordToSignature method will be the same so you can re-use the code from the first 
	 * part.
	 */

    //takes a word and returns a numeric signature.
	public static String wordToSignature(String word) { 
		
/*
* Because String is immutable, the Java compiler can do optimizations with 
* it. If you create multiple strings with the same compile-time constant value, 
* then the compiler will create only one String object and make both variables 
* refer to that one String object, which saves memory. This optimization wouldn't
* be possible if strings were mutable.
*/
	StringBuffer string = new StringBuffer(word.toLowerCase());
		for (int i = 0; i < string.length(); i++) {
			System.out.println(string.toString());
			string.setCharAt(i, charSignature(string.charAt(i)));

		}
		return string.toString();
	}

	private static char charSignature(char character) {
		String string = String.valueOf(character);
		char character2;

		if (character == 'a' || character == 'b' || character == 'c') {
			return character2 = '2';
		}
		if (character == 'd' || character == 'e' || character == 'f') {
			return character2 = '3';
		}
		if (character == 'g' || character == 'h' || character == 'i') {
			return character2 = '4';
		}
		if (character == 'j' || character == 'k' || character == 'l') {
			return character2 = '5';
		}
		if (character == 'm' || character == 'n' || character == 'o') {
			return character2 = '6';
		}
		if (character == 'p' || character == 'q' || character == 'r'
				|| character == 's') {
			return character2 = '7';
		}
		if (character == 't' || character == 'u' || character == 'v') {
			return character2 = '8';
		}
		if (character == 'w' || character == 'x' || character == 'y'
				|| character == 'z') {
			return character2 = '9';

		} else {
			character2 = '1';
		}
		return character2;

	}
	/**
	 * This method returns a boolean indicating that the given string is a valid word
	 * and does not contain non-alphabetical characters.
	 * @param word (gives a string containing a single word).
	 * @return A boolean indicating whether the given word is valid or not.
	 */
	protected static boolean isValidWord(String word){
		word = word.toLowerCase();
		char check;
		for(int i=0; i<word.length(); i++){
			check = word.charAt(i);
			if((check<97 || check>122)){
				return false;
			}
		}
		return true;
	}
	
}
	
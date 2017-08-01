package predictive;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
 * Prototypes and design. 
 * Build a prototype for the predictive text problem.
 * The method takes a word and returns a numeric signature.
 * You should do this using the StringBuffer class rather than 
 * string. Explain in your comments why this will be more efficient.
 * @author William Downs
 * @version 04/02/2016
 */

public class PredictivePrototype {
	
	public static void main(String[] args) {
		System.out.println(wordToSignature("home"));
	}
	// takes a word and returns a numeric signature.
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
	
	/*
	 * Write another method SignatureToWords that takes the given numeric
	 * signature and returns a set of possible matching words from the
	 * dictionary. The returned list must not have duplicates and each word
	 * should be in lower-case. The method SignatureToWords will need to use the
	 * dictionary to find words that match the string signature and return all
	 * the matching words. 
	 * This method is inefficient because each time the method is called it has to open
	 * the file 'words' and check every single word in the dictionary.
	 */

	public static Set<String> signatureToWords(String signature){
		HashSet<String> signatureMatches = new HashSet<String>();
		BufferedReader reader = null;
		
		try {
		    File file = new File("/usr/share/dict/words");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {
		    	if(line.length()==signature.length() && isValidWord(line)){
		    		if(wordToSignature(line).equals(signature)){
		    			line = line.toLowerCase();
		    			if(!(signatureMatches.contains(line)))
		    				signatureMatches.add(line);
		    		}
		    	}
		    }

		} catch (IOException e) {
		    System.out.println("Words file not found.");
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        System.out.println("Error when closing Words file.");
		    }
		}
		return signatureMatches;
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
	


	
	




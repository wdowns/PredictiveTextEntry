package predictive;

import java.util.ArrayList;

/**
 * Test for ListDictionar class.
 * 
 * @author William Downs
 * @version 14/02/16 
 */

public class Sigs2WordsList {
		
	public static void main(String[] args) {
			ListDictionary d = new ListDictionary();
	for (String s: args) {
				
	            System.out.print(s + " : ");
				ArrayList<String> set = (ArrayList<String>) d.signatureToWords(s);
	            for(String word:set){
	            	System.out.print(word + " ");
	            }
	            System.out.println();
	        }
		}
		
	}

package predictive;

/**
 * Create a class which pairs the numeric signatures with words.
 * @author William Downs
 * @version 14/02/16
 * Construct a WordSig object which contains both word and corresponding signature strings.
 * @param word (string containing a single word).
 */
public class WordSig implements Comparable<WordSig> {
	private String signature;
	private String word;
	
	public WordSig(String word) {
		this.word = word;
		this.signature = PredictivePrototype.wordToSignature(word);
	}
	public WordSig(String word, String sig) {
		this.word = word;
		this.signature = sig;
	}
	// Returns a String of the word contained in WordSig Object.
	 public String getWord() {
		return word;
	}
	// Returns a String of the signature contained in WordSig Object/
	public String getSignature() {
		return signature;
	}
	/*
	 * A compareTo method that compares this WordSig's signature with the specified WordSig's 
	 * signature for order. Will return -1, 0, or 1, as this WordSig's signature is less than,
	 * equal to or greater than the specified WordSig's signature.
	 */
public int compareTo(WordSig ws){
	
		if(this.signature.length()<ws.signature.length()){
			return -1;
		}else if(this.signature.length()>ws.signature.length()){
			return 1;
		}else{
			return this.signature.compareTo(ws.signature);
		}		
		
	}
    // Returns a string representing the word and signature of the WordSig Object.
	@Override
	public String toString() {
		return word + " : " + signature;
	}
	/*
	 * Compares this WordSig's signature with given WordSig's signature. If signatures of 
	 * the two WordSig's are equal then returns true, or else it returns false.
	 */
	public boolean equals(WordSig other) {
		if((this.signature.equals(other.signature))){
			return true;
		}
		return false;
	}
	
	
}
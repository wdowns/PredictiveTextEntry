package predictive;

/**
 * Test for calling signatureToWords method. Must accept a set of strings and call the 
 * appropriate method to do the conversion.
 * 
 * @author William Downs
 * @version 14/02/16
 */
 
public class Sigs2WordsProto {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + PredictivePrototype.signatureToWords(args[i]));
		}
	}
}
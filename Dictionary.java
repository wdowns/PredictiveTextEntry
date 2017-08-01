package predictive;

import java.util.Set;

/**
 * Dictionary interface.
 * @author William Downs
 * @version 13/02/16
 */

public interface Dictionary{
	public  Set<String> signatureToWords(String signature);
}
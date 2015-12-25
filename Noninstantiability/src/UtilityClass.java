
/**
 * 
 * @author Demon
 * @version 1.0.0
 * Noninstantiability utility class
 */
public class UtilityClass {
	
	// Suppress default constructor for noninstantiability.
	private UtilityClass(){
		throw new AssertionError();
	}
}

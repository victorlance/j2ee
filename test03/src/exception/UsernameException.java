/**
 * 
 */
package exception;



public class UsernameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5624680081858542002L;

	public UsernameException(String username) {
		super("The Username "+username+" is already exist");		
	}

}

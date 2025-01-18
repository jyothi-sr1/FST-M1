package session1;

public class NotEnoughFundsException extends RuntimeException {

   	/**
	 * 
	 */
	private static final long serialVersionUID = -4741767985678135551L;

	public NotEnoughFundsException(Integer amount, Integer balance) {
        super("Attempted to withdraw " + amount + " with a balance of " + balance);
    }

}

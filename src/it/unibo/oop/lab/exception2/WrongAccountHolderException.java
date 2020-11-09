package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int wrongUserID;
	private final int currentUserID;
	
	public WrongAccountHolderException(final int wrongUserID, final int currentUserID) {
		this.wrongUserID = wrongUserID;
		this.currentUserID = currentUserID;
	}

	
	@Override
	public String toString() {
		return "Unauthorized account " + this.wrongUserID + ", your ID is " + this.currentUserID;
	}


	@Override
	public String getMessage() {
		return this.toString();
	}
	
	
	
	
}

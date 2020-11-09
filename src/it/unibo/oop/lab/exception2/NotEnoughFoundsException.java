package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double balance;
	private final double amount;
	
	public NotEnoughFoundsException(final double balance, final double amount) {
		this.balance = balance;
		this.amount = amount;
	}

	@Override
	public String getMessage() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "Not enough founds! Current balance: " + this.balance
				+ "Amount required: " + this.amount;
	}
	
	
}

package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int nATMTransactions;
	private final int nMaxATMTransactions;
	
	public TransactionsOverQuotaException(final int nATMTransactions,final int nMaxATMTransactions) {
		this.nATMTransactions = nATMTransactions;
		this.nMaxATMTransactions = nMaxATMTransactions;
	}

	@Override
	public String toString() {
		return "Transactions over quota: count of ATM transactions is " + nATMTransactions
				+ "the transaction limit is " + this.nMaxATMTransactions;
	}

	@Override
	public String getMessage() {
		return this.toString();
	}
	
	
	
}

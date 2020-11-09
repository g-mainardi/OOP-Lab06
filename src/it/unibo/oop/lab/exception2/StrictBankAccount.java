package it.unibo.oop.lab.exception2;

/**
 * Class modeling a BankAccount with strict policies: getting money is allowed
 * only with enough founds, and there are also a limited number of free ATM
 * transaction (this number is provided as a input in the constructor).
 * 
 */
public class StrictBankAccount implements BankAccount {

    private final int usrID;
    private double balance;
    private int totalTransactionCount;
    private final int maximumAllowedATMTransactions;
    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;

    /**
     * 
     * @param usrID
     *            user id
     * @param balance
     *            initial balance
     * @param maximumAllowedAtmTransactions
     *            max no of ATM transactions allowed
     */
    public StrictBankAccount(final int usrID, final double balance, final int maximumAllowedAtmTransactions) {
        this.usrID = usrID;
        this.balance = balance;
        this.maximumAllowedATMTransactions = maximumAllowedAtmTransactions;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void deposit(final int usrID, final double amount) throws WrongAccountHolderException {
        if (checkUser(usrID)) {
            this.balance += amount;
            increaseTransactionsCount();
        } else {
        	throw new WrongAccountHolderException(this.usrID, usrID);
        }
        
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void withdraw(final int usrID, final double amount) throws WrongAccountHolderException,NotEnoughFoundsException {
        if (checkUser(usrID)) {
        	if (isWithdrawAllowed(amount)) {
        		this.balance -= amount;
        		increaseTransactionsCount();
        	} else {
        		throw new NotEnoughFoundsException(this.balance, amount);
        	}
        } else {
        	throw new WrongAccountHolderException(this.usrID, usrID);
        }
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void depositFromATM(final int usrID, final double amount)
    		throws WrongAccountHolderException, TransactionsOverQuotaException {
        if (totalTransactionCount < maximumAllowedATMTransactions) {
            this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
            totalTransactionCount++;
        } else {
        	throw new TransactionsOverQuotaException(totalTransactionCount, maximumAllowedATMTransactions);

        }
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void withdrawFromATM(final int usrID, final double amount) 
    		throws WrongAccountHolderException, NotEnoughFoundsException, TransactionsOverQuotaException{
        if (totalTransactionCount < maximumAllowedATMTransactions) {
            this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
        } else {
        	throw new TransactionsOverQuotaException(totalTransactionCount, maximumAllowedATMTransactions);
        }
    }

    /**
     * 
     * {@inheritDoc}
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getTransactionCount() {
        return totalTransactionCount;
    }

    /**
     * 
     * @param usrID
     *            id of the user related to these fees
     */

    public void computeManagementFees(final int usrID) throws WrongAccountHolderException{
        final double feeAmount = MANAGEMENT_FEE + (totalTransactionCount * StrictBankAccount.TRANSACTION_FEE);
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            balance -= MANAGEMENT_FEE + totalTransactionCount * StrictBankAccount.TRANSACTION_FEE;
            totalTransactionCount = 0;
        }
    }

    private boolean checkUser(final int id) {
        return this.usrID == id;
    }

    private boolean isWithdrawAllowed(final double amount) {
        return balance > amount;
    }

    private void increaseTransactionsCount() {
        totalTransactionCount++;
    }
}

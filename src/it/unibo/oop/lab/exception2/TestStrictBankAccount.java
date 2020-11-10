package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {
	private final double INITIAL_BALANCE = 10_000d;
	private final double BASIC_ACTION_AMOUNT = 1d;
	private final int MAX_ATM_TRANSACTION = 10;
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
    	
    	final AccountHolder mario = new AccountHolder("Mario", "Penna", 0);
    	final AccountHolder luigi = new AccountHolder("Luigi", "Rossi", 1);
    	
    	final BankAccount account1 = new StrictBankAccount(mario.getUserID(), INITIAL_BALANCE, MAX_ATM_TRANSACTION);
    	final BankAccount account2 = new StrictBankAccount(luigi.getUserID(), INITIAL_BALANCE, MAX_ATM_TRANSACTION);


         /* 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	// test NotEnoughFoundsException
    	try {
    		account1.withdraw(mario.getUserID(), INITIAL_BALANCE + BASIC_ACTION_AMOUNT );
    		fail("Can not withdraw so much");
    	} catch (NotEnoughFoundsException e) {
    		assertNotNull(e.getMessage());
    		assertFalse(e.getMessage().isEmpty());
    	}
    	// test WrongAccountHolderException
    	try {
    		account1.deposit(luigi.getUserID(), BASIC_ACTION_AMOUNT);
    		fail("Can not acces with another ID");
    	} catch (WrongAccountHolderException e) {
    		assertNotNull(e.getMessage());
    		assertFalse(e.getMessage().isEmpty());
    	}
    	// test TransactionOverQuotaException
    	try {
    		while (account2.getTransactionCount() < MAX_ATM_TRANSACTION) {
    			account2.depositFromATM(luigi.getUserID(), BASIC_ACTION_AMOUNT);
    		}
    		account2.depositFromATM(luigi.getUserID(), BASIC_ACTION_AMOUNT);
    		fail("Over the max of ATM transaction");
    	} catch (TransactionsOverQuotaException e) {
    		assertNotNull(e.getMessage());
    		assertFalse(e.getMessage().isEmpty());
    	}
    }
}

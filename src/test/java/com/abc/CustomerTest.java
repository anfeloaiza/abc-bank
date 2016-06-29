package com.abc;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test //Test customer statement generation
    public void testApp(){

        Account checkingAccount = new Checking();
        Account savingsAccount = new Savings();
        Account maxiSavingAccount = new MaxiSavings();

        Customer henry = new Customer("Henry").openAccount(checkingAccount)
        									  .openAccount(savingsAccount)
        									  .openAccount(maxiSavingAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);
        maxiSavingAccount.deposit(5000);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Maxi Savings Account\n" +
                "  deposit $5,000.00\n"+
                "Total $5,000.00\n"+
                "\n"+
                "Total In All Accounts $8,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(new Savings());
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar")
                .openAccount(new Savings());
        oscar.openAccount(new Checking());
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Ignore
    public void testThreeAcounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new Savings());
        oscar.openAccount(new Checking());
        assertEquals(3, oscar.getNumberOfAccounts());
    }
    
    @Test //Test customer transfer between Accounts
    public void transferBetweenAccounts(){

        Account checkingAccount = new Checking();
        Account savingsAccount = new Savings();

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(2000.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);
        
        savingsAccount.transfer(200, checkingAccount);
        
        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $2,000.00\n" +
                "  deposit $200.00\n" +
                "Total $2,200.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,600.00\n" +
                "\n" +
                "Total In All Accounts $5,800.00", henry.getStatement());
       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_application;

import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kishore
 */
public class BankingApplicationJUnitTest {
   static BankingApplication bank ;
   static Customer c;
   static ArrayList<Customer> customerArray ;
    
    public BankingApplicationJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        bank = new BankingApplication();
        c = new Customer(0,"default","default",1000);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void CreateAccountTest() {
        assertEquals(0,bank.addingCustomer(1,"Rahul","141 street",500.0));
    }
    @Test
    public void CreateAccountTest1() {
        assertEquals(0,bank.addingCustomer(1,"Sunil","222 street",5000.0));
    }
    @Test
    public void DepositTest() {
       assertEquals(0.0, c.deposit(1000), 0.001);
    }
    @Test
    public void DepositTest1() {
       assertEquals(0.0, c.deposit(500), 0.001);
    }
    @Test
    public void WithdrawTest() {
       assertEquals(0.0, c.withdraw(1000), 0.001);
    }
    @Test
    public void WithdrawTest1() {
       assertEquals(0.0, c.withdraw(500), 0.001);
    }
    @Test
    public void TotalMoneyInBankTest() {
       assertEquals(1,bank.totalMoneyInBank(),0.001);
    }
    @Test
    public void TotalMoneyInBankTest1() {
       assertEquals(0,bank.totalMoneyInBank(),0.001);
    }
    @Test
    public void RichestPersonInBankTest() {
       assertEquals(1,bank.richestPerson(),0.001);
    }
    @Test
    public void RichestPersonInBankTest1() {
       assertEquals(1,bank.richestPerson(),0.001);
    }
}

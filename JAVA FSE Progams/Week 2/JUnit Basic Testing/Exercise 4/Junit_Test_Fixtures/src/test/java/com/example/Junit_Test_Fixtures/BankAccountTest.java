package com.example.Junit_Test_Fixtures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // Setup: Runs before each test
        account = new BankAccount(100); // Arrange
        System.out.println("Setup complete");
    }

    @After
    public void tearDown() {
        // Teardown: Runs after each test
        account = null;
        System.out.println("Teardown complete");
    }

    @Test
    public void testDeposit() {
        // Arrange done in setUp()

        // Act
        account.deposit(50);

        // Assert
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        // Arrange done in setUp()

        // Act
        account.withdraw(30);

        // Assert
        assertEquals(70, account.getBalance());
    }
}

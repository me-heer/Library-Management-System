package com.lms.controller;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TransactionTest{
    
    @Test
    public static void checkBalanceTest(){
        assertEquals("Checking balance of UserID: 1", 5, Transaction.checkBalance(1));
    }
}
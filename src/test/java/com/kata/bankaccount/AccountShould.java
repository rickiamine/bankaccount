package com.kata.bankaccount;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

    private Account account;

    @Mock
    private Statement statement;

    @Mock
    AccountStatementPrinter printer;

    @Before
    public void init() {
        account = new Account(statement);
    }


    @Test
    public void makeDeposit() {
        int amount = 100;
        String date = Instant.now().toString();
        account.deposit(amount,date);
        verify(statement).addNewBalance(new Operation(Operation.OperationType.DEPOSIT,amount,date),amount);
    }

    @Test
    public void makeWithdrawal() {
        int amount = 100;
        String date = Instant.now().toString();
        account.withdrawal(amount,date);
        verify(statement).addNewBalance(new Operation(Operation.OperationType.WITHDRAWAL,amount,date),-amount);
    }

    @Test
    public void printAccountStatement() {
        account.printStatement(printer);
        verify(statement).exportToPrint(printer);
    }
}

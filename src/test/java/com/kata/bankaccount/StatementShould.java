package com.kata.bankaccount;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementShould {

    private Statement statement;

    @Mock
    AccountStatementPrinter printer;

    @Before
    public void init() {
        statement = new Statement();
    }

    @Test
    public void printDepositOperation() {
        int amount= 100;
        String date = Instant.now().toString();
        statement.addNewBalance(new Operation(Operation.OperationType.DEPOSIT,amount,date),amount);
        statement.exportToPrint(printer);
        verify(printer).println(new BalanceLine(new Operation(Operation.OperationType.DEPOSIT,amount,date),amount));
    }

    @Test
    public void printWithdrawalOperation() {
        int amount= 100;
        String date = Instant.now().toString();
        statement.addNewBalance(new Operation(Operation.OperationType.WITHDRAWAL,amount,date),amount);
        statement.exportToPrint(printer);
        verify(printer).println(new BalanceLine(new Operation(Operation.OperationType.WITHDRAWAL,amount,date),amount));
    }

    @Test
    public void printManyOperation() {
        int amount= 100;
        int amount2= 200;
        String date = Instant.now().toString();
        statement.addNewBalance(new Operation(Operation.OperationType.DEPOSIT,amount,date),amount);
        statement.addNewBalance(new Operation(Operation.OperationType.DEPOSIT,amount2,date),amount+amount2);
        statement.exportToPrint(printer);

        InOrder inOrder = Mockito.inOrder(printer);
        inOrder.verify(printer).println(new BalanceLine(new Operation(Operation.OperationType.DEPOSIT,amount,date),amount));
        inOrder.verify(printer).println(new BalanceLine(new Operation(Operation.OperationType.DEPOSIT,amount2,date),amount+amount2));
    }

}

package com.kata.bankaccount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;

public class AccountStatementPrinterShould {

    AccountStatementPrinter printer;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void init() {
        printer = new AccountStatementPrinter();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void printBalanceLine() {
        String date = Instant.now().toString();
        int amount = 100;
        BalanceLine balanceLine = new BalanceLine(new Operation(Operation.OperationType.DEPOSIT,amount,date),amount);
        printer.println(balanceLine);
        Assert.assertEquals(balanceLine.getOperation().getDate()+";"+balanceLine.getOperation().getName()+";"+balanceLine.getOperation().getAmount()+";"+balanceLine.getBalanceAfterOperation(), outputStreamCaptor.toString()
                .trim());
    }

}

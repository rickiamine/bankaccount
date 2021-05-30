package com.kata.bankaccount;

import java.util.LinkedList;
import java.util.List;

public class Statement {

    private List<BalanceLine > balanceLines = new LinkedList<>();


    public void addNewBalance(Operation operation, int balanceAfterOperation) {
        this.balanceLines.add(new BalanceLine(operation,balanceAfterOperation));
    }

    public void exportToPrint(AccountStatementPrinter printer) {
        throw new UnsupportedOperationException();
    }
}

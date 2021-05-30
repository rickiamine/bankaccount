package com.kata.bankaccount;

import java.util.LinkedList;
import java.util.List;

public class Statement {

    private List<BalanceLine > balanceLines = new LinkedList<>();


    public void addNewBalance(Operation deposit, int balance) {
        throw new UnsupportedOperationException();
    }

    public void exportToPrint(AccountStatementPrinter printer) {
        balanceLines.forEach(balanceLine ->printer.println(balanceLine));
    }
}

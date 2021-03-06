package com.kata.bankaccount;

import java.util.LinkedList;
import java.util.List;

public class Statement {

    private List<BalanceLine > balanceLines = new LinkedList<>();


    public void addNewBalance(Operation operation, int balanceAfterDeposit) {
        this.balanceLines.add(new BalanceLine(operation,balanceAfterDeposit));
    }

    public void exportToPrint(AccountStatementPrinter printer) {
        balanceLines.forEach(balanceLine ->printer.println(balanceLine));
    }
}

package com.kata.bankaccount;

public class AccountStatementPrinter {
    public void println(BalanceLine balanceLine) {
        System.out.println(balanceLine.getOperation().getDate()+";"+balanceLine.getOperation().getName()+";"+balanceLine.getOperation().getAmount()+";"+balanceLine.getBalanceAfterOperation());
    }
}

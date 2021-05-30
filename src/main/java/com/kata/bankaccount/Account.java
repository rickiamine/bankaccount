package com.kata.bankaccount;

public class Account {

    private Statement statement;

    private int balance = 0;

    public Account(Statement statement) {
        this.statement = statement;
    }

    public void deposit(int amount, String date) {
        Operation operation = new Operation("deposit",amount,date);
        this.balance = this.balance+amount;
        statement.addNewBalance(operation,balance);
    }
}

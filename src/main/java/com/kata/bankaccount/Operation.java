package com.kata.bankaccount;

import java.util.Objects;

public class Operation {

    private OperationType name;
    private int amount;
    private String date;

    public Operation(OperationType name, int amount, String date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return amount == operation.amount && name == operation.name && Objects.equals(date, operation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, date);
    }

    enum OperationType {
        DEPOSIT,WITHDRAWAL
    }

}

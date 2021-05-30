package com.kata.bankaccount;

import java.util.Objects;

public class BalanceLine {
    private Operation operation;
    private int balanceAfterOperation;

    public BalanceLine(Operation operation, int balanceAfterOperation) {
        this.operation = operation;
        this.balanceAfterOperation = balanceAfterOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceLine that = (BalanceLine) o;
        return balanceAfterOperation == that.balanceAfterOperation && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, balanceAfterOperation);
    }
}

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

    @Before
    public void init() {
        account = new Account(statement);
    }


    @Test
    public void makeDeposit() {
        int amount = 100;
        String date = Instant.now().toString();
        account.deposit(amount,date);
        verify(statement).addNewBalance(new Operation("deposit",amount,date),amount);
    }
}

package com.kata.bankaccount;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class BankaccountApplication {

	public static void main(String[] args) {
		Account account = new Account(new Statement());
		AccountStatementPrinter printer = new AccountStatementPrinter();

		account.deposit(1000, Instant.now().toString());
		account.deposit(2000, Instant.now().toString());
		account.withdrawal(500, Instant.now().toString());

		account.printStatement(printer);
	}

}

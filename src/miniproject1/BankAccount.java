package miniproject1;

import java.io.*;
import java.util.Scanner;

abstract class BankAccount implements Serializable {

    private int accountNumber;
    private String name;
    protected double balance;

    BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    int getAccountNumber() {
        return accountNumber;
    }

    String getName() {
        return name;
    }

    double getBalance() {
        return balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    void display() {
        System.out.println("Account No : " + accountNumber);
        System.out.println("Name       : " + name);
        System.out.println("Balance    : " + balance);
    }
}



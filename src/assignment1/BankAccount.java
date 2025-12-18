package assignment1;

import java.util.*;

class BankAccount {
    int accNo;
    String name;
    double balance;

    BankAccount(int a, String n) {
        accNo = a;
        name = n;
        balance = 0;
    }

    void deposit(double amt) {
        balance += amt;
    }

    void withdraw(double amt) {
        if(amt > balance) throw new ArithmeticException();
        balance -= amt;
    }

    void display() {
        System.out.println(accNo);
        System.out.println(name);
        System.out.println(balance);
    }
}

class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        String string=sc.next();
        BankAccount b = new BankAccount(a, string);

        try {
            b.deposit(sc.nextDouble());
            b.withdraw(sc.nextDouble());
        } catch(Exception e) {
            System.out.println("Insufficient Balance");
        }

        b.display();
    }
}
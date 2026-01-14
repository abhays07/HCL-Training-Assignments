package miniproject1;

class CurrentAccount extends BankAccount {

    CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited");
    }

    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Amount Withdrawn");
    }
}


package miniproject1;

class SavingsAccount extends BankAccount {

    SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited");
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount Withdrawn");
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

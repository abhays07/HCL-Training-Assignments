package Assignment2.question1;

public class Main {

    public static void main(String[] args) {

        BankAccount ba = new BankAccount(154, "Shifa", 5000);

        ba.showDetails();
        ba.checkBalance();
        ba.deposit(1000);

        try {
            ba.withdraw(2340);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ba.checkBalance();
    }
}

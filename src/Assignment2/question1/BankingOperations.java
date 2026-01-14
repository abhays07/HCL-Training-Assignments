package Assignment2.question1;

public interface BankingOperations {
	void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    void checkBalance();
}
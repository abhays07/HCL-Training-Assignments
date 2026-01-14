package miniproject1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    static final String FILE = "account.txt";
    static Scanner sc = new Scanner(System.in);

    static void save(BankAccount acc) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
        oos.writeObject(acc);
        oos.close();
    }

    static BankAccount load() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));
        BankAccount acc = (BankAccount) ois.readObject();
        ois.close();
        return acc;
    }

    public static void main(String[] args) {

        BankAccount account = null;

        try {
            while (true) {

                System.out.println("\n1.Create Account");
                System.out.println("2.Deposit");
                System.out.println("3.Withdraw");
                System.out.println("4.Balance Enquiry");
                System.out.println("5.Display Account");
                System.out.println("6.Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Initial Balance: ");
                        double bal = sc.nextDouble();

                        System.out.print("1.Savings 2.Current: ");
                        int type = sc.nextInt();

                        if (type == 1)
                            account = new SavingsAccount(accNo, name, bal);
                        else
                            account = new CurrentAccount(accNo, name, bal);

                        save(account);
                        System.out.println("Account Created");
                        break;

                    case 2:
                        account = load();
                        System.out.print("Deposit Amount: ");
                        double d = sc.nextDouble();
                        account.deposit(d);
                        save(account);
                        break;

                    case 3:
                        account = load();
                        System.out.print("Withdraw Amount: ");
                        double w = sc.nextDouble();
                        account.withdraw(w);
                        save(account);
                        break;

                    case 4:
                        account = load();
                        System.out.println("Balance: " + account.getBalance());
                        break;

                    case 5:
                        account = load();
                        account.display();
                        break;

                    case 6:
                    	System.out.println("Thank you.....");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}

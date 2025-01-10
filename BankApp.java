import java.util.Scanner;
class BankAccount {
    private String accountNumber, accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    public void checkBalance() {
        System.out.println("Current Balance is Rs." + balance);
    }
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        System.out.println(amount > 0 ? "Deposited money is Rs." + amount : "Invalid deposit amount.");
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        System.out.println(amount > 0 && amount <= balance ? "Withdrew Money is Rs." + amount : "Invalid or insufficient funds.");
    }
    public void transfer(BankAccount target, double amount) {
        if (amount > 0 && amount <= balance) {
            withdraw(amount);
            target.deposit(amount);
        }
    }
}
public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account1 = new BankAccount("123456", "Asritha", 10000.0);
        BankAccount account2 = new BankAccount("789012", "Bhavana", 5000.0);
        while (true) {
            System.out.println("\n     Banking Application @datasoftixsInternship    \n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Exit");
            System.out.print("Choose an option   ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: account1.checkBalance(); break;
                case 2: System.out.print("Enter deposit Money "); account1.deposit(scanner.nextDouble()); break;
                case 3: System.out.print("Enter withdrawal Money "); account1.withdraw(scanner.nextDouble()); break;
                case 4: System.out.print("Enter transfer Money  "); account1.transfer(account2, scanner.nextDouble()); break;
                case 5: System.out.println("Thankyou, Have a nice day "); scanner.close(); return;
                default: System.out.println("Invalid choice."); break;
            }
        }
    }
}

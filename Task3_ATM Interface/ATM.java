import java.util.Scanner;
class BankAccount 
{
    private double balance;
    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }
    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) 
    {
        if (amount > 0) 
        {
            if (balance >= amount) 
            {
                balance -= amount;
                System.out.println("₹" + amount + " withdrawn successfully.");
            } 
            else 
            {
                System.out.println("Insufficient balance!");
            }
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public double getBalance() 
    {
        return balance;
    }
}
public class ATM 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(25000);
        int option;
        do 
        {
            System.out.println("\nWELCOME TO THE ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your option:");
            option = scanner.nextInt();

            switch (option) 
            {
                case 1:
                    System.out.println("Your current balance is ₹" + userAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }

        } while (option != 4);

        scanner.close();
    }
}

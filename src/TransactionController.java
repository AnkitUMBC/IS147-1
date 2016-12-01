import java.util.ArrayList;
import java.util.Scanner;

// mankit1@umbc.edu Ankit Monga group 4

public class TransactionController {
    private static Scanner input = new Scanner(System.in);
    private static final double TRANSACTION_FEE = 3.0; // constant to hold service charge

    public static ArrayList<Account> depositFunds(ArrayList<Account> accounts, int index){
        System.out.println("Current balance: "+ ((Customer)accounts.get(index)).getBalance());
        System.out.println("Enter the amount of money you would like to deposit into your account:");
        double addedFunds = input.nextDouble();
        ((Customer)accounts.get(index)).depositFunds(addedFunds);
        return accounts;
    }
    public static ArrayList<Account> withdrawalFunds(ArrayList<Account> accounts, int index){
        System.out.println("Current balance: "+ ((Customer)accounts.get(index)).getBalance());
        System.out.println("Enter the amount of money you would like to withdrawal from your account:");
        System.out.println("All withdrawals have a $3.00 service charge.");
        double withdrawalFunds = input.nextDouble();
        double afterTransaction = ((Customer) accounts.get(index)).getBalance() - withdrawalFunds - TRANSACTION_FEE;
        if (afterTransaction < 0)
            System.out.println("This transaction would overdraw by: "+Math.abs(afterTransaction));
        else {
            System.out.println("Successfully retrieved funds. New balance is: "+ afterTransaction);
            ((Customer) accounts.get(index)).withdrawalFunds(withdrawalFunds);
        }
        return accounts;
    }
}

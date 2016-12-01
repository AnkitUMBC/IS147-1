import java.util.ArrayList;
import java.util.Scanner;

// mankit1@umbc.edu Ankit Monga group 4

public class AccountController {
    private static Scanner input = new Scanner(System.in);

    public static int login(ArrayList<Account> accounts) {
        System.out.println("Enter your username");
        String username = input.nextLine();
        Object[] accountsArray = accounts.toArray();
        for (int index =0; index < accountsArray.length; index++) {
            if (accounts.get(index).getUserName().equals(username)) {
                System.out.println("Enter your account password:");
                String pasword = input.nextLine();
                if (accounts.get(index).getPassword().equals(pasword)) {
                    return index;//returns address of authenticated user in the array list
                } else {
                    System.out.println("Invalid username password combination.");
                    return -1;//returns a negative number to indicate no user has been logged in
                }
            }
        }
        System.out.println("Username does not exist.");
        return -1;//returns a negative number to indicate no user has been logged in
    }//end login method

    public static ArrayList<Account> createAccount(ArrayList<Account> accounts){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = input.nextLine();
        System.out.println("Enter a username");
        String username = input.nextLine();
        for(Account a:accounts) {
            if (a.getUserName().equals(username)) {
                System.out.println("Username already exists");
                return accounts;
            }
        }
        System.out.println("Enter a password");
        String password = input.nextLine();
        System.out.println("Enter your starting balance.");
        double balance = input.nextDouble();
        Customer newAccount = new Customer(name, username, password, balance);
        accounts.add(newAccount);
        return accounts;
    }//end create accountMethod

    public static ArrayList<Account> createManager(ArrayList<Account> accounts){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = input.nextLine();
        System.out.println("Enter a username");
        String username = input.nextLine();
        for(Account a:accounts) {
            if (a.getUserName().equals(username)) {
                System.out.println("Username already exists");
                return accounts;
            }
        }
        System.out.println("Enter a password");
        String password = input.nextLine();

        Manager newAccount = new Manager(name, username, password);
        accounts.add(newAccount);
        return accounts;
    }//end create createManager

    public static ArrayList<Account> deleteAccount(ArrayList<Account> accounts, int index){
        Object[] accountsArray = accounts.toArray();
        if (accountsArray.length < 2){//checks to see if there are no other accounts to delete
            System.out.println("No other accounts exit right now");
            return accounts;
        }
        for (int i =0; i < accountsArray.length; i++) {
            if (i != index)
                System.out.println((i + 1) + " " + accounts.get(i).toString());
        }
        System.out.println("Enter the account number for the account you want to close or 0 to leave this menu.");
        Scanner input = new Scanner(System.in);
        int delete = input.nextInt();
        delete--;
        if (delete==index){
            System.out.println("The number you entered is associated with your own account. Error.");
            return accounts;
        }
        else if (delete==-1){
            return accounts;
        }
        else {
            System.out.println("Deleting account: "+accounts.get(delete).getUserName());
            accounts.remove(delete);
            return accounts;
        }
    }
}
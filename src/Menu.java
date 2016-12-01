import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// mankit1@umbc.edu Ankit Monga group 4

public class Menu {
    static private ArrayList<Account> accounts; //keeps track of current accounts
    static private boolean loggedIn = false; //keeps track of logged in status, starts out false
    static private int currentAccount = -1 ; //keeps track of the currently logged in account index if logged in, start at -1

    public static void main(String[] args){
        boolean running = true;//keeps the main menu running for the duration of the program run
        accounts = new ArrayList<Account>();
        Manager bankManger = new Manager("Ankit","ankit66", "cats");//creates the mangager account
        accounts.add(bankManger);//adds the manager to the list of accounts
        Scanner input = new Scanner(System.in);
        while(running) {//while loop that keeps application running until user decides to quit
                if (!loggedIn) {//checks to if the user isn't logged in
                    printMainMenu();//calls a method to display the unauthenticated menu
                    String userChoice = input.nextLine();

                    try {
                        //switch statement to loop through possible user actions
                        switch (userChoice) {
                            case "1":
                                accounts = AccountController.createAccount(accounts);
                                break;
                            case "2":
                                currentAccount = AccountController.login(accounts);
                                if(currentAccount >=0)//checks to see if the method call returned a user account/ was succesful
                                    loggedIn = true;
                                break;
                            case "3":
                                running = false;//closes the aplication
                                break;
                            default:
                                System.out.println("Invalid selection");//happens if user makes invalid input
                                break;
                        }
                    } catch (InputMismatchException a) {
                        System.out.println("Invalid input detected. Please try again.");
                    }
                    catch (ArrayIndexOutOfBoundsException b){
                        System.out.println("You did not enter a valid account number.");
                    }
                }
                else {
                    if (accounts.get(currentAccount).getType().equals("Manager")) {//checks to see if the user is signed into a manager account
                        printMainMenu("Manager", accounts.get(currentAccount).getName());//print the menu for the current manager
                        String userChoice = input.nextLine();

                        try{
                            switch (userChoice) {
                                case "1":
                                    accounts = AccountController.createAccount(accounts);
                                    break;
                                case "2":
                                    accounts = AccountController.deleteAccount(accounts, currentAccount);
                                    break;
                                case "3":
                                    loggedIn = false;
                                    currentAccount = -1;
                                    break;
                                default:
                                    System.out.println("Invalid selection");
                                    break;
                            }
                            } catch (InputMismatchException a) {
                                 System.out.println("Invalid input detected. Please try again.");
                             }
                            catch (ArrayIndexOutOfBoundsException b){
                                 System.out.println("You did not enter a valid account number.");
                             }

                    } else {
                        printMainMenu(accounts.get(currentAccount).getName());//prints menu for customer account
                        String userChoice = input.nextLine();

                        try {

                           switch (userChoice) {
                               case "1":
                                   accounts = TransactionController.withdrawalFunds(accounts, currentAccount);
                                   break;
                               case "2":
                                   accounts = TransactionController.depositFunds(accounts, currentAccount);
                                   break;
                               case "3":
                                   loggedIn = false;
                                   currentAccount = -1;
                                   break;
                               default:
                                   System.out.println("Invalid selection");
                                   break;
                           }
                       } catch (InputMismatchException a) {
                           System.out.println("Invalid input detected. Please try again.");
                       }
                       catch (ArrayIndexOutOfBoundsException b) {
                           System.out.println("You did not enter a valid account number.");
                       }
                    }
                }

        }
    }
    public static void printMainMenu(){
        System.out.println("Enter the number of the service you want to use");
        System.out.println("1 Create an account");
        System.out.println("2 Login to an account");
        System.out.println("3 Quit");
    }//end printMainMenu for unauthenticated users
    public static void printMainMenu(String customerName){
        System.out.println("Hello, "+customerName+"!");
        System.out.println("Enter the number of the service you want to use");
        System.out.println("1 Withdrawal funds");
        System.out.println("2 Deposit funds");
        System.out.println("3 Logout");
    }//end printMainMenu for customer accounts
    public static void printMainMenu(String accType, String managerName){
        System.out.println(accType+" Menu. Manager: "+managerName);
        System.out.println("Select management option");
        System.out.println("1 Create manager account");
        System.out.println("2 Delete account");
        System.out.println("3 Logout");
    }//end printManinMenu for manager accounts
}
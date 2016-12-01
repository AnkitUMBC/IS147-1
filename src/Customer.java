// mankit1@umbc.edu Ankit Monga group 4

public class Customer extends Account {
    private double balance;

    public Customer(String name, String username, String password, double balance){
        super(name, username, password, "Customer");
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public void withdrawalFunds(double withdrawal){
             balance -= withdrawal;
    }
    public void depositFunds(double deposit) {
        balance += deposit;
    }
    @Override
    public String toString(){
        return super.toString().concat(" Account Balance: "+balance);
    }
}

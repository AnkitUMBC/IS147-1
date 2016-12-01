// mankit1@umbc.edu Ankit Monga group 4

public class Account {
    private String userName;
    private String password;
    private String type;
    private String name;

    public Account(String name, String userName, String password, String type){
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.name = name;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        String returnString ="";
        returnString = returnString.concat("Name: "+name+" User Name: "+userName+" Type: "+type);
        return returnString;
    }
}

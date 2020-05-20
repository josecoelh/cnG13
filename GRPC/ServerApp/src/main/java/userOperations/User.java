package userOperations;

public class User {
    public String getUsername() {
        return username;
    }

    String username;
     private String accountType;

    public String getAccountType() {
        return accountType;
    }

    public User(services.ProtoUser user){
        this.username = user.getUsername();
        this.accountType = user.getAccountType();
    }
}

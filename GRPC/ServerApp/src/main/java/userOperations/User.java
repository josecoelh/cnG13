package userOperations;

public class User {
    public String getUsername() {
        return username;
    }

    String username;
     private String accountType;

    String getAccountType() {
        return accountType;
    }

    public boolean isPremium(){
        return accountType.equals("Premium");
    }

    public User(services.ProtoUser user){
        this.username = user.getUsername();
        this.accountType = user.getAccountType();
    }
}


public class Admin {

    private String UserName;
    private String password;
    public Admin(String userName, String password) {
        super();
        UserName = userName;
        this.password = password;
    }


    public String getUserName() {
        return UserName;
    }


    public String getPassword() {
        return password;
    }

}

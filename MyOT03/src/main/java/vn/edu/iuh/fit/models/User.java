package vn.edu.iuh.fit.models;

public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
    public boolean checkLogin(String userName, String password){
        if(userName.equals("admin") && password.equals("123")){
            return true;
        }else{
            return false;
        }
    }
}

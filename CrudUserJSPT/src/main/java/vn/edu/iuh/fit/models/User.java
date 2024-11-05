package vn.edu.iuh.fit.models;

import java.util.Date;

public class User {
    private String userName;
    private String password;
    private String fullName;
    private int age;
    private Date birthday;
    private boolean gender;

    public User() {
    }

    public User(String userName, String password, String fullName, int age, Date birthday, boolean gender) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}

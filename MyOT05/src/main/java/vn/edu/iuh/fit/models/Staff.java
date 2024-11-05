package vn.edu.iuh.fit.models;

import java.util.Arrays;
import java.util.Date;

public class Staff {
    private String fullName;
    private int age;
    private double salary;
    private Date recruitDate;
    private String country;
    private boolean gender;
    private String image;
    private Integer []hobbies;

    public Staff() {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getRecruitDate() {
        return recruitDate;
    }

    public void setRecruitDate(Date recruitDate) {
        this.recruitDate = recruitDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(Integer[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", recruitDate=" + recruitDate +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", image='" + image + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }
}

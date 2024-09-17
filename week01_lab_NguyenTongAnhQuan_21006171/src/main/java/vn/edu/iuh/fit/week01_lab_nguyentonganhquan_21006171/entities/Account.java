package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Entity
@Table(name = "account", schema = "www_week1")
@NamedQueries({
        @NamedQuery(name = "Account.findByEmailOrPhoneAndPassword", query = "select a from Account a where (a.email = :email or a.phone = :phone) and a.password = :password"),
        @NamedQuery(name = "Account.findAll", query = "select a from Account a"),
        @NamedQuery(name = "Account.deleteByAccountId", query = "delete from Account a where a.accountId = :accountId")
})
public class Account implements Serializable {
    private static final long serialVersionUID = -4975585565028447667L;
    private String accountId;

    private String fullName;

    private String password;

    private String email;

    private String phone;

    private Byte status;

    public Account() {

    }

    @Id
    @Column(name = "account_id", nullable = false, length = 50)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Column(name = "full_name", nullable = false, length = 50)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone", length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ColumnDefault("1")
    @Column(name = "status", nullable = false)
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Account(String accountId, String fullName, String password, String email, String phone, Byte status) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
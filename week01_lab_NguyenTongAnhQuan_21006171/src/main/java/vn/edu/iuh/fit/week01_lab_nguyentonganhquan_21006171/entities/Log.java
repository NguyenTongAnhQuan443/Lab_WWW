package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "log", schema = "www_week1")
public class Log implements Serializable {
    private static final long serialVersionUID = 5902982398787991574L;
    private Long id;

    private String accountId;

    private Instant loginTime;

    private Instant logoutTime;

    private String notes;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "account_id", nullable = false, length = 50)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @ColumnDefault("current_timestamp()")
    @Column(name = "login_time", nullable = false)
    public Instant getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Instant loginTime) {
        this.loginTime = loginTime;
    }

    @ColumnDefault("current_timestamp()")
    @Column(name = "logout_time", nullable = false)
    public Instant getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Instant logoutTime) {
        this.logoutTime = logoutTime;
    }

    @ColumnDefault("''")
    @Column(name = "notes", nullable = false, length = 250)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Log() {

    }

    public Log(String accountId, Instant loginTime, Instant logoutTime, String notes) {
        this.accountId = accountId;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.notes = notes;
    }
}
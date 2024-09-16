package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@IdClass(GrantAccessId.class)
@Entity
@Table(name = "grant_access", schema = "www_week1")
@NamedQueries({
        @NamedQuery(name = "GrantAccess.findByAccountId", query = "select g from GrantAccess g where g.accountId = :accountId")
})
public class GrantAccess implements Serializable {
    private static final long serialVersionUID = 1754120793906160308L;
    private String roleId;

    private String accountId;

    private Role role;

    private Account account;

    private String isGrant;

    private String note;

    @Id
    @Column(name = "role_id", nullable = false, length = 50)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "account_id", nullable = false, length = 50)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @MapsId
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "role_id", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @MapsId
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "account_id", nullable = false)
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ColumnDefault("'1'")
    @Lob
    @Column(name = "is_grant", nullable = false)
    public String getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(String isGrant) {
        this.isGrant = isGrant;
    }

    @ColumnDefault("''")
    @Column(name = "note", length = 250)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "roleId='" + roleId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", role=" + role +
                ", account=" + account +
                ", isGrant='" + isGrant + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
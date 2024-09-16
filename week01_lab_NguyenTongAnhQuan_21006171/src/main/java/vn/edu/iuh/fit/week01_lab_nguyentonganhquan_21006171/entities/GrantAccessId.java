package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities;

import java.io.Serializable;
import java.util.Objects;

public class GrantAccessId implements Serializable {
    public String roleId;

    public String accountId;

    public GrantAccessId() {
    }

    public GrantAccessId(String roleId, String accountId) {
        this.roleId = roleId;
        this.accountId = accountId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantAccessId entity = (GrantAccessId) o;
        return Objects.equals(this.roleId, entity.roleId) &&
                Objects.equals(this.accountId, entity.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, accountId);
    }
}
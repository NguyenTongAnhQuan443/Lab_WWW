package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "role", schema = "www_week1")
public class Role implements Serializable {
    private static final long serialVersionUID = 2781055380960826630L;
    private String roleId;

    private String roleName;

    private String description;

    private Byte status;

    @Id
    @Column(name = "role_id", nullable = false, length = 50)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "role_name", nullable = false, length = 50)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "description", length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "status", nullable = false)
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

}
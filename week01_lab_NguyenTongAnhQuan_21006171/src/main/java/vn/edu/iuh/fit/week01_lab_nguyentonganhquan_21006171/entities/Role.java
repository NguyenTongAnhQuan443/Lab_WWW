package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "role", schema = "www_week1")
@NamedQueries({
        @NamedQuery(name = "Role.deleteByRoleId", query = "delete from Role r where r.roleId = :roleId"),
        @NamedQuery(name = "Role.findAll", query = "select r from Role r")
})
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

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public Role(String roleId, String roleName, String description, Byte status) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }

    public Role() {
    }
}
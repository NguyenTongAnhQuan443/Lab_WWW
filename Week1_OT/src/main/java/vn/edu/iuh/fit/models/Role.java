package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "role", schema = "mydb")
@NamedQueries({
        @NamedQuery(name = "Role.deleteByID", query = "delete from Role r where r.roleId = :id"),
        @NamedQuery(name = "Role.findAll", query = "select r from Role r")
})
public class Role {
    @Id
    @Column(name = "role_id", nullable = false, length = 50)
    private String roleId;

    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "status", nullable = false)
    private Byte status;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

}
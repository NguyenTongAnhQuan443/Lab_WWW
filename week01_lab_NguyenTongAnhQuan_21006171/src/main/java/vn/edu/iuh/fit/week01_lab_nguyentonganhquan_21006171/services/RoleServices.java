package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services;

import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Role;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.Impl.RoleRespository;

import java.util.List;

public class RoleServices {
    private RoleRespository roleRespository;

    public RoleServices() {
        roleRespository = new RoleRespository();
    }
    public boolean add(Role role) {
       return roleRespository.add(role);
    }

    public boolean deleteByID(Class<Role> entityClass, String id) {
       return roleRespository.deleteByID(Role.class, id);
    }

    public boolean update(Role role) {
       return roleRespository.update(role);
    }

    public Role findById(Class<Role> entityClass, String id) {
        return roleRespository.findById(Role.class, id);
    }

    public List<Role> findAll(Class<Role> entityClass) {
        return roleRespository.findAll(Role.class);
    }
}

package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.sevices;

import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Role;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.impl.RoloRespositoryImpl;

import java.util.List;

public class RoleSevice {
    public RoloRespositoryImpl roloRespositoryImpl;

    public RoleSevice() {
        this.roloRespositoryImpl = new RoloRespositoryImpl();
    }

    public List<Role> findAll() {
        return roloRespositoryImpl.findAll(Role.class);
    }

    public Role findId(String id) {
        return roloRespositoryImpl.finById(Role.class, id);
    }

    public Boolean update(Role role) {
        return roloRespositoryImpl.update(role);
    }

    public Role save(Role role) {
        return roloRespositoryImpl.save(role);
    }

    public Boolean deleteById(String id) {
        return roloRespositoryImpl.deleteById(Role.class, id);
    }
}

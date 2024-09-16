package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.services;

import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.GrantAccess;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.Impl.GrantAccessRespository;

public class GrantAccessServices {
    private GrantAccessRespository grantAccessRespository;

    public GrantAccessServices() {
        grantAccessRespository = new GrantAccessRespository();
    }

    public GrantAccess findByAccountId(String id) {
        return grantAccessRespository.findByAccountId(id);
    }
}

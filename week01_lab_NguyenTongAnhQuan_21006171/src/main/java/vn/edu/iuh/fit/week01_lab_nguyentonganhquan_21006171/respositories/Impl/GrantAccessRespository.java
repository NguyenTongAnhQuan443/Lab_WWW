package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.Impl;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.connectDB.Connection;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.GrantAccess;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.CRUDRespository;

public class GrantAccessRespository {
    private EntityManager entityManager = Connection.getInstance().getEntityManager();

    public GrantAccess findByAccountId(String id){
        return entityManager.createNamedQuery("GrantAccess.findByAccountId", GrantAccess.class)
                .setParameter("accountId", id)
                .getSingleResult();
    }
}

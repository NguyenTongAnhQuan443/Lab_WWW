package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.impl;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.connectDB.Connection;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.GrantAccess;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.GrantAccessId;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.CRUDRespository;

import java.util.List;

public class GrandAccessRespositoryImpl implements CRUDRespository<GrantAccess, GrantAccessId> {
    private EntityManager entityManager;

    public GrandAccessRespositoryImpl() {
        entityManager = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    @Override
    public GrantAccess save(GrantAccess grantAccess) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(grantAccess);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return grantAccess;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public GrantAccess finById(Class<GrantAccess> entityClass, GrantAccessId grantAccessId) {
        return null;
    }

    public GrantAccess findById(String account, String role) {
        return entityManager.createNamedQuery("GrantAccess.findById_AccountIdAndId_RoleId", GrantAccess.class)
                .setParameter("accountId", account)
                .setParameter("roleId", role)
                .getSingleResult();
    }

    @Override
    public List<GrantAccess> findAll(Class<GrantAccess> entityClass) {
        return entityManager.createNamedQuery("GrantAccess.findAll", GrantAccess.class).getResultList();
    }

    @Override
    public Boolean update(GrantAccess grantAccess) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(grantAccess);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Boolean deleteById(Class<GrantAccess> entityClass, GrantAccessId grantAccessId) {
        return null;
    }

    public Boolean deleteById(String accountId, String roleId) {
        try {
            entityManager.getTransaction().begin();
            int result = entityManager.createNamedQuery("GrantAccess.deleteById_AccountIdAndId_RoleId")
                    .setParameter("accountId", accountId)
                    .setParameter("roleId", roleId)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }
}

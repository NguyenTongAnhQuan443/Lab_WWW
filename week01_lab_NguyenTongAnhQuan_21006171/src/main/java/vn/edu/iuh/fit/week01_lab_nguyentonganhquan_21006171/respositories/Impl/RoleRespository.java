package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.Impl;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.connectDB.Connection;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Role;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.CRUDRespository;

import java.util.List;

public class RoleRespository implements CRUDRespository<Role, String> {
    private EntityManager entityManager = Connection.getInstance().getEntityManager();

    @Override
    public boolean add(Role role) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(role);
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
    public boolean deleteByID(Class<Role> entityClass, String id) {
        try {
            entityManager.getTransaction().begin();
            int result = entityManager.createNamedQuery("Role.deleteByRoleId")
                    .setParameter("roleId", id)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.clear();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean update(Role role) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(role);
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
    public Role findById(Class<Role> entityClass, String id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> findAll(Class<Role> entityClass) {
        return entityManager.createNamedQuery("Role.findAll", Role.class).getResultList();
    }
}

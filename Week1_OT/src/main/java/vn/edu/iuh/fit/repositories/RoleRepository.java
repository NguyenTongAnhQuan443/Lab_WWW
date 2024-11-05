package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.models.Role;

import java.util.List;

public class RoleRepository implements CRUDRepository<Role, String> {
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
    public boolean deleteByID(String id) {
        try {
            entityManager.getTransaction().begin();
            int result = entityManager.createNamedQuery("Role.deleteByID")
                    .setParameter("id", id)
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
    public Role findByID(String id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> findAll() {
        return entityManager.createNamedQuery("Role.findAll", Role.class).getResultList();
    }
}

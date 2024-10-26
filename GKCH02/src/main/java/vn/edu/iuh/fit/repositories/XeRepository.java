package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.models.Xe;

import java.util.Collection;
import java.util.List;

public class XeRepository implements CRUD<Xe, String> {
    private EntityManager entityManager = Connection.getInstance().getEntityManager();

    @Override
    public boolean add(Xe xe) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(xe);
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
    public boolean delete(String id) {
        try {
            entityManager.getTransaction().begin();
            int result = entityManager.createNamedQuery("Xe.deleteByMaXe")
                    .setParameter("maXe", id)
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
    public boolean update(Xe xe) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(xe);
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
    public Xe findByID(String id) {
        return entityManager.find(Xe.class, id);
    }

    @Override
    public List<Xe> getAll() {
        return entityManager.createNamedQuery("Xe.findAll", Xe.class).getResultList();
    }

    public List<Xe> findByTenXe(String name) {
        return entityManager.createNamedQuery("Xe.findByTenXe", Xe.class).setParameter("tenXe", name).getResultList();
    }

    public List<Xe> findByPrice(String price) {
        return entityManager.createNamedQuery("Xe.findByGiaXe", Xe.class).getResultList();
    }
}

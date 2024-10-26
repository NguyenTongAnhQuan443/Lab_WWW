package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.models.HangXe;

import java.util.List;

public class HangXeRepository implements CRUD<HangXe, String> {
    private EntityManager entityManager = Connection.getInstance().getEntityManager();

    @Override
    public boolean add(HangXe hangXe) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(hangXe);
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
            int result = entityManager.createNamedQuery("HangXe.deleteByMaHangXe")
                    .setParameter("maHangXe", id)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.clear();
            return  result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean update(HangXe hangXe) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(hangXe);
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
    public HangXe findByID(String id) {
        return entityManager.find(HangXe.class, id);
    }

    @Override
    public List<HangXe> getAll() {
        return entityManager.createNamedQuery("HangXe.findAll", HangXe.class).getResultList();
    }
}

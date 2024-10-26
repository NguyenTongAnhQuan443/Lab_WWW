package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.models.Thuoc;

import java.util.List;

public class QuanLyThuocRepository {
    private final EntityManager entityManager = Connection.getInstance().getEntityManager();

    public List<Thuoc> getAll(){
        return entityManager.createNamedQuery("Thuoc.findAll", Thuoc.class).getResultList();
    }

    public Thuoc getThuocByMaLoai(String maLoai){
        return (Thuoc) entityManager.createNamedQuery("Thuoc.findByLoaiThuoc_MaLoai", Thuoc.class).getResultList();
    }

    public boolean addThuoc(Thuoc thuoc){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(thuoc);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }
}

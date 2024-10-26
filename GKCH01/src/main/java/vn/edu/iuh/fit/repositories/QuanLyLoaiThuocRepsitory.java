package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.models.LoaiThuoc;

import java.util.Collection;
import java.util.List;

public class QuanLyLoaiThuocRepsitory {
    private EntityManager entityManager = Connection.getInstance().getEntityManager();

    public List<LoaiThuoc> getAll(){
        return entityManager.createNamedQuery("LoaiThuoc.findAll", LoaiThuoc.class).getResultList();
    }

}

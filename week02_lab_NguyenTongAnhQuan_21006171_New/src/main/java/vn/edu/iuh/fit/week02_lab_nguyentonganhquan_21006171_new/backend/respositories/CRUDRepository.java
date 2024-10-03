package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.respositories;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T, ID> {
    boolean add(T entity);

    boolean delete(ID id);

    boolean update(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();
}

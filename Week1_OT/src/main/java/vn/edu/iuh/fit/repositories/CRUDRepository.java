package vn.edu.iuh.fit.repositories;

import java.util.List;

public interface CRUDRepository<T, ID> {
    boolean add(T entity);
    boolean deleteByID(ID id);
    boolean update(T entity);
    T findByID(ID id);
    List<T> findAll();
}

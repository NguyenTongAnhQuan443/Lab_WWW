package vn.edu.iuh.fit.repositories;

import java.util.List;

public interface CRUD<T, ID> {
    boolean add(T entity);
    boolean delete(ID id);
    boolean update(T entity);
    T findByID(ID id);
    List<T> getAll();
}

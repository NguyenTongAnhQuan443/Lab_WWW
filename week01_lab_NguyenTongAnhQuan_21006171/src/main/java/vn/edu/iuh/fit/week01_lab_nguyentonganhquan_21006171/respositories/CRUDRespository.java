package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories;

import java.util.List;

public interface CRUDRespository<T, ID> {
    boolean add (T t);
    boolean deleteByID(Class<T> entityClass, ID id);
    boolean update(T t);
    T findById(Class<T> entityClass, ID id);
    List<T> findAll(Class<T> entityClass);
}

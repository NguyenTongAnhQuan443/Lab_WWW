package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories;

import java.util.List;

public interface CRUDRespository<T, ID> {
    T save(T t);
    T finById(Class<T> entityClass, ID id);
    List<T> findAll(Class<T> entityClass);
    Boolean update(T t);
    Boolean deleteById(Class<T> entityClass, ID id);
}

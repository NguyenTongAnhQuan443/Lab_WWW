package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models.Customer;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models.Employee;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.respositories.CRUDRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository implements CRUDRepository<Employee, Long> {
    private EntityManager entityManager;
    private final Logger logger;

    public EmployeeRepository() {
        this.entityManager = Connection.getInstance().getEntityManager();
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public boolean add(Employee employee) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            entityManager.getTransaction().begin();
            Optional<Employee> optionalEmployee = findById(id);
            if (optionalEmployee.isPresent()) {
                Employee employee = optionalEmployee.get();
                employee.setStatus(EmployeeStatus.NoLongerWorking);
                entityManager.merge(employee);
            }
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Employee employee) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee == null ? Optional.empty() : Optional.of(employee);
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    //
    public List<Employee> getEmpByPageNum(int numPage, int limitNum) {
        return entityManager.createNamedQuery("Employee.getEmpByPageNum", Employee.class)
                .setFirstResult((numPage - 1) * limitNum)
                .setMaxResults(limitNum)
                .getResultList();
    }
}

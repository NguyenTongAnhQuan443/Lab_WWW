package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Employee;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.CRUDRespository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class EmployeeRespositoryImpl implements CRUDRespository<Employee, Long> {
    private EntityManager entityManager;
    private Logger logger;

    public EmployeeRespositoryImpl() {
        entityManager = Connection.getInstance().getEntityManager();
        logger = LoggerFactory.getLogger(this.getClass());
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
        return setStatusEmployee(id, EmployeeStatus.QUITTED);
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
        return entityManager.createNamedQuery("Employee.findAll", Employee.class)
                .getResultList();
    }

    //
    public boolean setStatusEmployee(Long id, EmployeeStatus employeeStatus) {
        Optional<Employee> optionalEmployee = findById(id);
        if (optionalEmployee.isEmpty()) {
            return false;
        } else {
            try {
                entityManager.getTransaction().begin();
                Employee employee = optionalEmployee.get();
                employee.setStatus(employeeStatus);
                entityManager.getTransaction().commit();
                entityManager.clear();
                return true;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                logger.error(e.getMessage());
                return false;
            }
        }
    }

    public List<Employee> findAllByStatus() {
        List<Employee> listEmployee = entityManager.createNamedQuery("Employee.findAllByStatus", Employee.class).
                setParameter("status", EmployeeStatus.QUITTED)
                .getResultList();
        return listEmployee;
    }

    public List<Employee> getEmplByPageNum(int numPage, int limitNum) {
        List<Employee> employeeList = entityManager.createNamedQuery("Employee.getEmpByPageNum", Employee.class)
                .setParameter("status", EmployeeStatus.QUITTED)
                .setFirstResult((numPage - 1) * limitNum)
                .getResultList();
        return employeeList;
    }
}

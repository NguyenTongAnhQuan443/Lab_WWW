package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.services;

import org.checkerframework.checker.units.qual.Current;
import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Employee;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl.EmployeeRespositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRespositoryImpl employeeRespositoryImpl;
    private ModelMapper modelMapper;

    public EmployeeService() {
        employeeRespositoryImpl = new EmployeeRespositoryImpl();
        modelMapper = new ModelMapper();
    }

    public <T> boolean add(Class<T> entityMapperClass) {
        Employee employee = modelMapper.map(entityMapperClass, Employee.class);
        return employeeRespositoryImpl.add(employee);
    }

    public <T> boolean delete(Long id) {
        return employeeRespositoryImpl.delete(id);
    }

    public <T> boolean update(Class<T> entityMapperClass) {
        return employeeRespositoryImpl.update(modelMapper.map(entityMapperClass, Employee.class));
    }

    public <T> T findById(Long id, Class<T> entityMapperClass) {
        Optional<Employee> optionalEmployee = employeeRespositoryImpl.findById(id);
        return optionalEmployee.map(
                employee -> modelMapper.map(employee, entityMapperClass)
        ).orElse(null);
    }

    public <T> List<T> findAll(Class<T> entityMapperClass) {
        List<T> entityMappers = new ArrayList<>();
        List<Employee> employees = employeeRespositoryImpl.findAll();
        employees.forEach(
                e -> {
                    entityMappers.add(modelMapper.map(e, entityMapperClass));
                });
        return entityMappers;
    }
}

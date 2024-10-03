package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.services;

import org.eclipse.persistence.asm.Opcodes;
import org.eclipse.persistence.jpa.jpql.tools.spi.IEntity;
import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Customer;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl.CustomerRespositoryIml;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRespositoryIml customerRespositoryIml;
    private ModelMapper modelMapper;

    public <T> boolean add(T entity) {
        Customer customer = modelMapper.map(entity, Customer.class);
        return customerRespositoryIml.add(customer);
    }

    public boolean delete(Long id) {
        return customerRespositoryIml.delete(id);
    }

    public <T> boolean update(T entity) {
        Customer customer = modelMapper.map(entity, Customer.class);
        return customerRespositoryIml.update(customer);
    }

    public <T> T findById(Long id, Class<T> entityMapperClass) {
        Optional<Customer> optionalCustomer = customerRespositoryIml.findById(id);
        if (optionalCustomer.isEmpty()) {
            return null;
        } else {
            Customer customer = optionalCustomer.get();
            return modelMapper.map(customer, entityMapperClass);
        }
    }

    public <T> List<T> findAll(Class<T> entityMapperClass) {
        List<T> entityMappers = new ArrayList<>();
        customerRespositoryIml.findAll().forEach(e -> {
            entityMappers.add(modelMapper.map(e, entityMapperClass));
        });
        return entityMappers;
    }

    public <T> T findByEmail(String email, Class<T> entityMapperClass) {
        Optional<Customer> optionalCustomer = customerRespositoryIml.findByEmail(email);
        if (optionalCustomer.isEmpty()) {
            return null;
        } else {
            Customer customer = optionalCustomer.get();
            return modelMapper.map(customer, entityMapperClass);
        }
    }
}

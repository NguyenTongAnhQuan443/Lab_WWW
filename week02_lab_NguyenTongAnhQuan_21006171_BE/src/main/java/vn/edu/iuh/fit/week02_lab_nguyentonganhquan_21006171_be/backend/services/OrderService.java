package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.services;

import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Order;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl.OrderRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {
    private OrderRepositoryImpl orderRepository;
    private ModelMapper modelMapper;

    public OrderService() {
        orderRepository = new OrderRepositoryImpl();
        modelMapper = new ModelMapper();
    }

    public <T> boolean add(Class<T> entityMapperClass) {
        Order order = modelMapper.map(entityMapperClass, Order.class);
        return orderRepository.add(order);
    }

    public <T> boolean delete(Long id) {
        return orderRepository.delete(id);
    }

    public <T> boolean update(Class<T> entityMapperClass) {
        Order order = modelMapper.map(entityMapperClass, Order.class);
        return orderRepository.update(order);
    }

    public <T> T findById(Long id, Class<T> entityMapperClass) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            return null;
        } else {
            Order order = optionalOrder.get();
            return modelMapper.map(order, entityMapperClass);
        }
    }

    public <T>List<T> findAll(){
        List<Order> orderList = orderRepository.findAll();

    }
}

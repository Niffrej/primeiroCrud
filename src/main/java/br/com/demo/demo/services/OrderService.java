package br.com.demo.demo.services;

import br.com.demo.demo.entities.OrderEntity;
import br.com.demo.demo.models.Order;
import br.com.demo.demo.models.mapper.OrderMapper;
import br.com.demo.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order create(Order order) {
        OrderEntity orderEntity = OrderMapper.marshall(order);
        OrderEntity persistenceEntity = orderRepository.save(orderEntity);
        return OrderMapper.unmarshall(persistenceEntity);
    }

    public Order update(Order order) {
        OrderEntity orderEntity = OrderMapper.marshall(order);
        OrderEntity ModifiedEntity = orderRepository.save(orderEntity);
        return OrderMapper.unmarshall(ModifiedEntity);
    }

    public void delete(Long idOrder) { orderRepository.deleteById(idOrder); }

    public Order findById(Long idOrder) {
        OrderEntity orderEntity=orderRepository.findById(idOrder).get();
        Order order = OrderMapper.unmarshall(orderEntity);
        return order;
    }

    public List<Order> findAll() { return new ArrayList<>(OrderMapper.unmarshall(orderRepository.findAll()));}
}

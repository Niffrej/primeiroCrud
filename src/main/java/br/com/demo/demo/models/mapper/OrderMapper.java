package br.com.demo.demo.models.mapper;

import br.com.demo.demo.validations.NullSafe;
import br.com.demo.demo.entities.OrderEntity;
import br.com.demo.demo.models.Order;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class OrderMapper {

    public static Collection<Order> unmarshall(Collection<OrderEntity> entities) {
        return NullSafe.of(entities).getOrDefault(Collections.emptyList()).stream().map(entity -> OrderMapper.unmarshall(entity))
                .collect(Collectors.toList());
    }

    public static Collection<OrderEntity> marshall(Collection<Order> models) {
        return NullSafe.of(models).getOrDefault(Collections.emptyList()).stream().map(OrderMapper::marshall)
                .collect(Collectors.toList());
    }

    public static Order unmarshall(OrderEntity entity){
        return Order.builder().build();
    }

    public static OrderEntity marshall(Order model){
        return OrderEntity.builder().build();
    }
}

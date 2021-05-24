package br.com.demo.demo.models.mapper;

import br.com.demo.demo.validations.NullSafe;
import br.com.demo.demo.entities.ItemOrderEntity;
import br.com.demo.demo.models.ItemOrder;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ItemOrderMapper {

    public static Collection<ItemOrder> unmarshall(Collection<ItemOrderEntity> entities) {
        return NullSafe.of(entities).getOrDefault(Collections.emptyList()).stream().map(entity -> ItemOrderMapper.unmarshall(entity))
                .collect(Collectors.toList());
    }

    public static Collection<ItemOrderEntity> marshall(Collection<ItemOrder> models) {
        return NullSafe.of(models).getOrDefault(Collections.emptyList()).stream().map(ItemOrderMapper::marshall)
                .collect(Collectors.toList());
    }

    public static ItemOrder unmarshall(ItemOrderEntity entity){
        return ItemOrder.builder()
                .build();
    }

    public static ItemOrderEntity marshall(ItemOrder model){
        return ItemOrderEntity.builder()
                .build();
    }
}

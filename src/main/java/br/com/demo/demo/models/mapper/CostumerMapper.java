package br.com.demo.demo.models.mapper;

import br.com.demo.demo.validations.NullSafe;
import br.com.demo.demo.entities.CostumerEntity;
import br.com.demo.demo.models.Costumer;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class CostumerMapper {

    public static Collection<Costumer> unmarshall(Collection<CostumerEntity> entities) {
        return NullSafe.of(entities).getOrDefault(Collections.emptyList()).stream().map(entity -> CostumerMapper.unmarshall(entity))
                .collect(Collectors.toList());
    }

    public static Collection<CostumerEntity> marshall(Collection<Costumer> models) {
        return NullSafe.of(models).getOrDefault(Collections.emptyList()).stream().map(CostumerMapper::marshall)
                .collect(Collectors.toList());
    }

    public static Costumer unmarshall(CostumerEntity entity){
        return Costumer.builder().build();
    }

    public static CostumerEntity marshall(Costumer model){
        return CostumerEntity.builder().build();
    }
}

package br.com.demo.demo.models.mapper;

import br.com.demo.demo.validations.NullSafe;

import br.com.demo.demo.entities.TelephoneEntity;

import br.com.demo.demo.models.Telephone;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class TelephoneMapper {

    public static Collection<Telephone> unmarshall(Collection<TelephoneEntity> entities) {
        return NullSafe.of(entities).getOrDefault(Collections.emptyList()).stream().map(entity -> TelephoneMapper.unmarshall(entity))
                .collect(Collectors.toList());
    }

    public static Collection<TelephoneEntity> marshall(Collection<Telephone> models) {
        return NullSafe.of(models).getOrDefault(Collections.emptyList()).stream().map(TelephoneMapper::marshall)
                .collect(Collectors.toList());
    }

    public static Telephone unmarshall(TelephoneEntity entity){
        return Telephone.builder().build();
    }

    public static TelephoneEntity marshall(Telephone model){
        return TelephoneEntity.builder().build();
    }
}

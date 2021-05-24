package br.com.demo.demo.models.mapper;

import br.com.demo.demo.validations.NullSafe;
import br.com.demo.demo.entities.AddressEntity;
import br.com.demo.demo.models.Address;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class AddressMapper {

    public static Collection<Address> unmarshall(Collection<AddressEntity> entities) {
        return NullSafe.of(entities).getOrDefault(Collections.emptyList()).stream().map(entity -> AddressMapper.unmarshall(entity))
                .collect(Collectors.toList());
    }

    public static Collection<AddressEntity> marshall(Collection<Address> models) {
        return NullSafe.of(models).getOrDefault(Collections.emptyList()).stream().map(AddressMapper::marshall)
                .collect(Collectors.toList());
    }

    public static Address unmarshall(AddressEntity entity){
        return Address.builder()
                .addressId(entity.getAddressId())
                .city(entity.getCity())
                .country(entity.getCountry())
                .street(entity.getStreet())
                .zipCode(entity.getZipCode())
                .build();
    }

    public static AddressEntity marshall(Address model){
        return AddressEntity.builder()
                .addressId(model.getAddressId())
                .city(model.getCity())
                .country(model.getCountry())
                .street(model.getStreet())
                .zipCode(model.getZipCode())
                .build();
    }

}

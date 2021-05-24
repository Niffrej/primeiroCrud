package br.com.demo.demo.services;

import br.com.demo.demo.entities.AddressEntity;
import br.com.demo.demo.models.Address;
import br.com.demo.demo.models.mapper.AddressMapper;
import br.com.demo.demo.repositories.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address create(Address address) {
        AddressEntity addressEntity = AddressMapper.marshall(address);
        AddressEntity persistenceEntity = addressRepository.save(addressEntity);
        return AddressMapper.unmarshall(persistenceEntity);
    }

    public Address update(Address address) {
        AddressEntity addressEntity = AddressMapper.marshall(address);
        AddressEntity ModifiedEntity = addressRepository.save(addressEntity);
        return AddressMapper.unmarshall(ModifiedEntity);
    }

    public void delete(Long idAddress) { addressRepository.deleteById(idAddress); }

    public Address findById(Long idAddress) {
        AddressEntity addressEntity= addressRepository.findById(idAddress).get();
        Address address = AddressMapper.unmarshall(addressEntity);
        return address;
    }

    public List<Address> findAll() { return new ArrayList<>(AddressMapper.unmarshall(addressRepository.findAll()));}
    }


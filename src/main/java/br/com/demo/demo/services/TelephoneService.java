package br.com.demo.demo.services;

import br.com.demo.demo.entities.TelephoneEntity;
import br.com.demo.demo.models.Telephone;
import br.com.demo.demo.models.mapper.TelephoneMapper;
import br.com.demo.demo.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelephoneService {

    @Autowired
    private TelephoneRepository telephoneRepository;

    public Telephone create(Telephone telephone) {
        TelephoneEntity telephoneEntity = TelephoneMapper.marshall(telephone);
        TelephoneEntity persistenceEntity = telephoneRepository.save(telephoneEntity);
        return TelephoneMapper.unmarshall(persistenceEntity);
    }

    public Telephone update(Telephone telephone) {
        TelephoneEntity telephoneEntity = TelephoneMapper.marshall(telephone);
        TelephoneEntity ModifiedEntity = telephoneRepository.save(telephoneEntity);
        return TelephoneMapper.unmarshall(ModifiedEntity);
    }

    public void delete(Long idTelephone) { telephoneRepository.deleteById(idTelephone); }

    public Telephone findById(Long idTelephone) {
        TelephoneEntity telephoneEntity= telephoneRepository.findById(idTelephone).get();
        Telephone telephone = TelephoneMapper.unmarshall(telephoneEntity);
        return telephone;
    }

    public List<Telephone> findAll() { return new ArrayList<>(TelephoneMapper.unmarshall(telephoneRepository.findAll()));}
}


package br.com.demo.demo.services;

import br.com.demo.demo.entities.CostumerEntity;
import br.com.demo.demo.models.Costumer;
import br.com.demo.demo.models.mapper.CostumerMapper;
import br.com.demo.demo.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    public Costumer create(Costumer costumer) {
        CostumerEntity costumerEntity = CostumerMapper.marshall(costumer);
        CostumerEntity persistenceEntity = costumerRepository.save(costumerEntity);
        return CostumerMapper.unmarshall(persistenceEntity);
    }

    public Costumer update(Costumer costumer) {
        CostumerEntity costumerEntity = CostumerMapper.marshall(costumer);
        CostumerEntity ModifiedEntity = costumerRepository.save(costumerEntity);
        return CostumerMapper.unmarshall(ModifiedEntity);
    }

    public void delete(Long idCostumer) { costumerRepository.deleteById(idCostumer); }

    public Costumer findById(Long idCostumer) {
        CostumerEntity costumerEntity= costumerRepository.findById(idCostumer).get();
        Costumer costumer = CostumerMapper.unmarshall(costumerEntity);
        return costumer;
    }

    public List<Costumer> findAll() { return new ArrayList<>(CostumerMapper.unmarshall(costumerRepository.findAll()));}
}

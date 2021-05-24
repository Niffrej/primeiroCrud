package br.com.demo.demo.services;

import br.com.demo.demo.entities.ItemOrderEntity;
import br.com.demo.demo.models.ItemOrder;
import br.com.demo.demo.models.mapper.ItemOrderMapper;
import br.com.demo.demo.repositories.ItemOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ItemOrderService {

    @Autowired
    private ItemOrderRepository itemOrderRepository;

    public ItemOrder create(ItemOrder itemOrder) {
        ItemOrderEntity ItemOrderEntity = ItemOrderMapper.marshall(itemOrder);
        ItemOrderEntity persistenceEntity = itemOrderRepository.save(ItemOrderEntity);
        return ItemOrderMapper.unmarshall(persistenceEntity);
    }

    public ItemOrder update(ItemOrder itemOrder) {
        ItemOrderEntity itemOrderEntity = ItemOrderMapper.marshall(itemOrder);
        ItemOrderEntity ModifiedEntity = itemOrderRepository.save(itemOrderEntity);
        return ItemOrderMapper.unmarshall(ModifiedEntity);
    }

    public void delete(Long idItemOrder) { itemOrderRepository.deleteById(idItemOrder); }

    public ItemOrder findById(Long idItemOrder) {
        ItemOrderEntity ItemOrderEntity= itemOrderRepository.findById(idItemOrder).get();
        ItemOrder itemOrder = ItemOrderMapper.unmarshall(ItemOrderEntity);
        return itemOrder;
    }

    public List<ItemOrder> findAll() { return new ArrayList<>(ItemOrderMapper.unmarshall(itemOrderRepository.findAll()));}
}

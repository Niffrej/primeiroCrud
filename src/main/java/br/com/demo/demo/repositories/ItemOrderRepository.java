package br.com.demo.demo.repositories;

import br.com.demo.demo.entities.ItemOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, Long> {
}

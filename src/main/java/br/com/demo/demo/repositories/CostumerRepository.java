package br.com.demo.demo.repositories;

import br.com.demo.demo.entities.CostumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<CostumerEntity, Long> {
}

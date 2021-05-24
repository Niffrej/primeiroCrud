package br.com.demo.demo.repositories;

import br.com.demo.demo.entities.TelephoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<TelephoneEntity, Long> {
}

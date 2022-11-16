package dev.jstec.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jstec.dsmeta.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}

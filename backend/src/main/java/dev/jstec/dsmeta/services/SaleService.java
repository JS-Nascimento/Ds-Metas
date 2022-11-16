package dev.jstec.dsmeta.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.jstec.dsmeta.entities.Sale;
import dev.jstec.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findSales() {

		return repository.findAll();
		
	}

}

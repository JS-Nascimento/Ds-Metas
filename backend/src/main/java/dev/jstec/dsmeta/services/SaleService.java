package dev.jstec.dsmeta.services;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.jstec.dsmeta.entities.Sale;
import dev.jstec.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
				
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = maxDate.isEmpty() ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.isEmpty() ? today :  LocalDate.parse(maxDate);

		return repository.findSales(min, max, pageable);
		
	}

}

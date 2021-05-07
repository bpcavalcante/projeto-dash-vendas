package com.vendas.dashvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vendas.dashvendas.dto.SaleDTO;
import com.vendas.dashvendas.dto.SaleSuccessDTO;
import com.vendas.dashvendas.dto.SaleSumDTO;
import com.vendas.dashvendas.entites.Sale;
import com.vendas.dashvendas.repositories.SalerRepository;
import com.vendas.dashvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private SalerRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
	
}

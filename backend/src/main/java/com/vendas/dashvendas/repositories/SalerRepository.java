package com.vendas.dashvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vendas.dashvendas.dto.SaleSuccessDTO;
import com.vendas.dashvendas.dto.SaleSumDTO;
import com.vendas.dashvendas.entites.Sale;

public interface SalerRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.vendas.dashvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.vendas.dashvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
	
}

package com.vendas.dashvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.dashvendas.entites.Sale;

public interface SalerRepository extends JpaRepository<Sale, Long>{

	
}

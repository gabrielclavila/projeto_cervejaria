package com.algaworks.cervejaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.cervejaria.model.Cerveja;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>{

}

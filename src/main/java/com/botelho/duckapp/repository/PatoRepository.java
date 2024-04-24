package com.botelho.duckapp.repository;

import com.botelho.duckapp.entity.Pato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatoRepository extends JpaRepository<Pato, Long> {
}


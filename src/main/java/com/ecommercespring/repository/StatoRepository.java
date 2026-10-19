package com.ecommercespring.repository;

import com.ecommercespring.model.Stato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoRepository extends JpaRepository<Stato, Integer> {
    Stato findByCodice(String codice);
}

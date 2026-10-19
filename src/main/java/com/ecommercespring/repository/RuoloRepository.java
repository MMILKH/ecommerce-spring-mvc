package com.ecommercespring.repository;

import com.ecommercespring.model.Carrello;
import com.ecommercespring.model.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Integer> {
    Ruolo findByNome(String nome);

}

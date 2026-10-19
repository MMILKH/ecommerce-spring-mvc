package com.ecommercespring.repository;

import com.ecommercespring.dto.CarrelloDto;
import com.ecommercespring.model.Carrello;
import com.ecommercespring.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Integer> {
    Carrello findByUtenteIdAndStato(int utenteId, String stato);

    Carrello findById(int id);
}

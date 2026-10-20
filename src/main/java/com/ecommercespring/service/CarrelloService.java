package com.ecommercespring.service;

import com.ecommercespring.dto.CarrelloDto;
import com.ecommercespring.dto.RigaCarrelloDto;

import java.math.BigDecimal;
import java.util.List;

public interface CarrelloService {


    CarrelloDto getCarrelloAttivo(int utenteId);

    void aggiungiProdottoDaCatalogo(int utenteId, int prodottoId, int quantita);

    BigDecimal getTotale(int carrelloId);

    List<RigaCarrelloDto> getRigheByCarrelloId(int carrelloId);

    void aggiornaQuantitaRiga(int rigaId, int nuovaQuantita);

    void rimuoviRiga(int rigaId);

    int countElementi(int utenteId);


}

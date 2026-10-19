package com.ecommercespring.service;

import com.ecommercespring.dto.CarrelloDto;
import com.ecommercespring.dto.RigaCarrelloDto;

import java.util.List;

public interface CarrelloService {


    CarrelloDto getCarrelloAttivo(int utenteId);

    RigaCarrelloDto aggiungiProdottoDaCatalogo(int utenteId, int prodottoId, int quantita);

    List<RigaCarrelloDto> getRigheByCarrelloId(int carrelloId);

    RigaCarrelloDto aggiornaQuantitaRiga(int rigaId, int nuovaQuantita);

    void rimuoviRiga(int rigaId);


}

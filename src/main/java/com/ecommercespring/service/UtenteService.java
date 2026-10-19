package com.ecommercespring.service;

import com.ecommercespring.dto.RequestLogin;
import com.ecommercespring.dto.UtenteDto;
import com.ecommercespring.model.Utente;

import java.util.List;

public interface UtenteService {
    UtenteDto autentica(RequestLogin requestLogin);
    void registra(UtenteDto utente) throws Exception;
    List<UtenteDto> showAll();
}

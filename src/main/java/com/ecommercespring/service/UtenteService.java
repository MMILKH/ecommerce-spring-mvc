package com.ecommercespring.service;

import com.ecommercespring.dto.LoginDto;
import com.ecommercespring.model.Utente;

public interface UtenteService {
    Utente autentica(LoginDto loginDto);
}

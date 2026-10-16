package com.ecommercespring.service.impl;

import com.ecommercespring.dto.LoginDto;
import com.ecommercespring.model.Utente;
import com.ecommercespring.repository.UtenteRepository;
import com.ecommercespring.service.UtenteService;
import com.ecommercespring.util.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    @Transactional(readOnly = true)
    public Utente autentica(LoginDto loginDto) {

        if (loginDto == null || loginDto.getEmail() == null || loginDto.getPassword() == null) {
            return null;
        }


        Utente utente = utenteRepository.findByEmail(loginDto.getEmail());

        if (utente == null) {
            return null;
        }

        try {

            String hashPassword = Password.getHash(loginDto.getPassword());
            if (hashPassword.equals(utente.getPassword())) {
                return utente;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
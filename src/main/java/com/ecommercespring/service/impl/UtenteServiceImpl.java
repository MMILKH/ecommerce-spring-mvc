package com.ecommercespring.service.impl;

import com.ecommercespring.dto.RequestLogin;
import com.ecommercespring.dto.RigaCarrelloDto;
import com.ecommercespring.dto.UtenteDto;
import com.ecommercespring.model.Carrello;
import com.ecommercespring.model.Ruolo;
import com.ecommercespring.model.Utente;
import com.ecommercespring.repository.CarrelloRepository;
import com.ecommercespring.repository.RuoloRepository;
import com.ecommercespring.repository.UtenteRepository;
import com.ecommercespring.service.UtenteService;
import com.ecommercespring.util.Password;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private RuoloRepository ruoloRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public UtenteDto autentica(RequestLogin requestLogin) {

        if (requestLogin == null || requestLogin.getEmail() == null || requestLogin.getPassword() == null) {
            return null;
        }
        Utente utente = utenteRepository.findByEmail(requestLogin.getEmail());
        if (utente == null) {
            return null;
        }
        try {
            String hashPassword = Password.getHash(requestLogin.getPassword());
            if (hashPassword.equals(utente.getPassword())) {
                Carrello c = carrelloRepository.findByUtenteIdAndStato(utente.getId(), "NEW");
                if (c == null) {
                    c = new Carrello();
                    c.setUtente(utente);
                    c.setStato("NEW");
                    c.setUltimoAggiornamento(new java.util.Date());
                    c.setDataCreazione(new java.util.Date());
                    carrelloRepository.save(c);
                }
                return modelMapper.map(utente, UtenteDto.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    @Transactional
    public String registra(UtenteDto dto) throws Exception {

        if (!dto.getPassword().equals(dto.getPasswordconf())) {
            return "Le password non coincidono.";
        }

        if ((utenteRepository.findByEmail(dto.getEmail())) != null) {
            return "Email già registrata nel sistema.";
        }
        Ruolo ruolo = ruoloRepository.findByNome("CUSTOMER");
        Utente utente = new Utente();
        utente.setRuolo(ruolo);
        utente.setNome(dto.getNome());
        utente.setCognome(dto.getCognome());
        utente.setEmail(dto.getEmail());
        utente.setNumero(dto.getNumero());
        utente.setIndirizzo(dto.getIndirizzo());
        utente.setDataCreazione(new java.util.Date());
        utente.setDataUltimaModifica(new java.util.Date());
        String passwordHash = Password.getHash(dto.getPassword());
        utente.setPassword(passwordHash);

        utenteRepository.save(utente);
               Carrello c = new Carrello();
               c.setUtente(utente);
               c.setStato("NEW");
               c.setUltimoAggiornamento(new java.util.Date());
               c.setDataCreazione(new java.util.Date());
                carrelloRepository.save(c);

        return "ok";
    }

    @Override
    public List<UtenteDto> showAll() {
        List<Utente> utenti = utenteRepository.findAll();
        return utenti.stream()
                .map(u -> modelMapper.map(u, UtenteDto.class))
                .collect(Collectors.toList());
    }
}
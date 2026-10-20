package com.ecommercespring.service.impl;

import com.ecommercespring.dto.CarrelloDto;
import com.ecommercespring.dto.RigaCarrelloDto;
import com.ecommercespring.model.Carrello;
import com.ecommercespring.model.Prodotto;
import com.ecommercespring.model.RigaCarrello;

import com.ecommercespring.repository.CarrelloRepository;
import com.ecommercespring.repository.ProdottoRepository;
import com.ecommercespring.repository.RigaCarrelloRepository;
import com.ecommercespring.repository.UtenteRepository;
import com.ecommercespring.service.CarrelloService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarrelloServiceImpl implements CarrelloService {

    @Autowired
    private CarrelloRepository carrelloRepository;

    @Autowired
    private RigaCarrelloRepository rigaCarrelloRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarrelloDto getCarrelloAttivo(int utenteId) {
        Carrello carrello = carrelloRepository.findByUtenteIdAndStato(utenteId, "NEW");
        return modelMapper.map(carrello, CarrelloDto.class);
    }

    @Override
    public void aggiungiProdottoDaCatalogo(int utenteId, int prodottoId, int quantita) {
        Carrello carrello = carrelloRepository.findByUtenteIdAndStato(utenteId, "NEW");
        RigaCarrello riga = rigaCarrelloRepository.findByCarrelloIdAndProdottoId(carrello.getId(), prodottoId);
        if (riga != null) {
            riga.setQuantita(riga.getQuantita() + quantita);
            riga.setDataUltimaModifica(new Date());
        }else{
            Prodotto prodotto = prodottoRepository.findById(prodottoId);
            riga = new RigaCarrello();
            riga.setCarrello(carrello);
            riga.setProdotto(prodotto);
            riga.setQuantita(quantita);
            riga.setDataCreazione(new Date());
            riga.setDataUltimaModifica(new Date());
        }
        rigaCarrelloRepository.save(riga);

    }

    @Override
    public BigDecimal getTotale(int carrelloId) {
        List<RigaCarrello> righe ;
        righe = rigaCarrelloRepository.findByCarrelloId(carrelloId);
        BigDecimal totale = BigDecimal.ZERO;
        BigDecimal temp;
        for (RigaCarrello r : righe){
            temp= r.getProdotto().getPrezzo().multiply(new BigDecimal(r.getQuantita()));
            totale = totale.add(temp);
        }
        return totale;
    }

    @Override
    public List<RigaCarrelloDto> getRigheByCarrelloId(int carrelloId) {
        List<RigaCarrello> righe ;
        righe = rigaCarrelloRepository.findByCarrelloId(carrelloId);
        return righe.stream()
                .map(riga -> modelMapper.map(riga, RigaCarrelloDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void aggiornaQuantitaRiga(int rigaId, int quantita) {
        RigaCarrello riga = rigaCarrelloRepository.findById(rigaId);
        riga.setQuantita(quantita);
        riga.setDataUltimaModifica(new Date());
        rigaCarrelloRepository.save(riga);

    }

    @Override
    public void rimuoviRiga(int rigaId) {
        RigaCarrello riga = rigaCarrelloRepository.findById(rigaId);
        rigaCarrelloRepository.delete(riga);
    }

    @Override
    public int countElementi(int utenteId) {
        Carrello carrello = carrelloRepository.findByUtenteIdAndStato(utenteId, "NEW");
        List<RigaCarrello> righe ;
        righe = rigaCarrelloRepository.findByCarrelloId(carrello.getId());
        int totaleElementi= 0;
        for (RigaCarrello riga : righe) {
            totaleElementi+= riga.getQuantita();
        }
        return totaleElementi;
    }

}

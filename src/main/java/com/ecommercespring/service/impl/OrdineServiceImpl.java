package com.ecommercespring.service.impl;

import com.ecommercespring.model.*;
import com.ecommercespring.repository.*;
import com.ecommercespring.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrdineServiceImpl implements OrdineService {

    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private RigaCarrelloRepository rigaCarrelloRepository;
    @Autowired
    private StatoRepository statoRepository;
    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private RigaOrdineRepository rigaOrdineRepository;


    @Override
    public void confermaOrdine(int utenteid,String indirizzoS, String indirizzoF) {

        Carrello carrello = carrelloRepository.findByUtenteIdAndStato(utenteid,"NEW");

        List<RigaCarrello> righeC = rigaCarrelloRepository.findByCarrelloId(carrello.getId());

        Stato s = statoRepository.findByCodice("PEN");

        BigDecimal totale = BigDecimal.ZERO;
        for (RigaCarrello r : righeC) {
            BigDecimal prezzoProdotto = r.getProdotto().getPrezzo();
            BigDecimal subtotale = prezzoProdotto.multiply(BigDecimal.valueOf(r.getQuantita()));
            totale = totale.add(subtotale);
        }

        Ordine o = new Ordine();
        o.setUtente(carrello.getUtente());
        if (indirizzoF == null || indirizzoF.trim().isEmpty()) {
            indirizzoF = indirizzoS;
        }
        o.setDataCreazione(new java.util.Date());
        o.setIndirizzoFatturazione(indirizzoF);
        o.setIndirizzoSpedizione(indirizzoS);
        o.setCodice(UUID.randomUUID().toString());
        o.setUtente(carrello.getUtente());
        o.setImporto(totale);
        o.setStato(s);

        ordineRepository.save(o);

        for (RigaCarrello r : righeC) {
            RigaOrdine rO = new RigaOrdine();
            rO.setOrdine(o);
            BigDecimal prezzoRiga = r.getProdotto().getPrezzo().multiply(BigDecimal.valueOf(r.getQuantita()));
            rO.setPrezzoRiga(prezzoRiga);
            rO.setProdotto(r.getProdotto());
            rO.setDataCreazione(new java.util.Date());
            rO.setQuantita(r.getQuantita());
            rO.setRigaCarrelloId(r.getId());
            rO.setPrezzoUnitario(r.getProdotto().getPrezzo());
            rigaOrdineRepository.save(rO);
            r.setDataUltimaModifica(new java.util.Date());
            rigaCarrelloRepository.save(r);

        }
        carrello.setStato("COMPLETED");
        carrello.setUltimoAggiornamento(new java.util.Date());
        carrelloRepository.save(carrello);

        Carrello cNew = new Carrello();
        cNew.setUtente(carrello.getUtente());
        cNew.setStato("NEW");
        cNew.setDataCreazione(new java.util.Date());
        cNew.setUltimoAggiornamento(new java.util.Date());

        carrelloRepository.save(cNew);



    }
}

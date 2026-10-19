package com.ecommercespring.controller;

import com.ecommercespring.dto.CarrelloDto;
import com.ecommercespring.dto.RigaCarrelloDto;
import com.ecommercespring.dto.UtenteDto;
import com.ecommercespring.model.Utente;
import com.ecommercespring.service.CarrelloService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class CarrelloController {

    @Autowired
    private CarrelloService carrelloService;

    @GetMapping("/carrello")
    public String mostraRighe(Model model,HttpSession session) {
        UtenteDto utenteLoggato =(UtenteDto) session.getAttribute("utenteLoggato");
        if(utenteLoggato == null){
            return "redirect:/login";
        }
        CarrelloDto carrelloDto = carrelloService.getCarrelloAttivo(utenteLoggato.getId());
        List<RigaCarrelloDto> righe = carrelloService.getRigheByCarrelloId(carrelloDto.getId());
        model.addAttribute("listaRighe", righe);
        return "carrello";
    }


    @PostMapping("/aggiungiCarrello")
    public String aggiungiProdottoDaCatalogo(
            @RequestParam("prodottoId") Integer prodottoId,
            @RequestParam(value = "quantita", defaultValue = "1") int quantita,
            HttpSession session) {

        UtenteDto utenteLoggato = (UtenteDto) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null || prodottoId == null) {
            return "redirect:/login";
        }
        carrelloService.aggiungiProdottoDaCatalogo(utenteLoggato.getId(), prodottoId, quantita);
        return "redirect:/catalogo";
    }


    @PostMapping("/carrello")
    public String gestisciRigaCarrello(
            @RequestParam("azione") String azione,
            @RequestParam("rigaCarrelloId") Integer rigaCarrelloId,
            @RequestParam(value = "quantita", required = false) Integer quantita,
            HttpSession session) {

        UtenteDto utenteLoggato = (UtenteDto) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null) {
            return "redirect:/login";
        }

        switch (azione) {
            case "aggiorna":
                if (quantita != null && quantita > 0) {
                    carrelloService.aggiornaQuantitaRiga(rigaCarrelloId, quantita);
                }
                break;
            case "rimuovi":
                carrelloService.rimuoviRiga(rigaCarrelloId);
                break;
            default:
                break;
        }

        return "redirect:/carrello";
    }


}

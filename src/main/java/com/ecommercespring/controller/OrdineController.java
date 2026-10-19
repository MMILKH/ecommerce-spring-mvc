package com.ecommercespring.controller;

import com.ecommercespring.dto.UtenteDto;
import com.ecommercespring.model.Utente;
import com.ecommercespring.service.OrdineService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OrdineController {

    @Autowired
    private OrdineService ordineService;

    @PostMapping("/ordine")
    public String creaOrdine(Model model, HttpSession session, @RequestParam("indirizzoS") String indirizzoS,
                             @RequestParam(value = "indirizzoF", required = false) String indirizzoF ) {

        UtenteDto utenteLoggato = (UtenteDto) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null) {
            return "redirect:/login";
        }

       ordineService.confermaOrdine(utenteLoggato.getId(),indirizzoS,indirizzoF);

        return "redirect:/catalogo";


    }
}

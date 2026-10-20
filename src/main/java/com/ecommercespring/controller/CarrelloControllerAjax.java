package com.ecommercespring.controller;

import com.ecommercespring.dto.CarrelloDto;
import com.ecommercespring.dto.RigaCarrelloDto;
import com.ecommercespring.dto.UtenteDto;
import com.ecommercespring.service.CarrelloService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarrelloControllerAjax {

    @Autowired
    private CarrelloService carrelloService;


    @PostMapping("/aggiungiCarrelloAjax")
    @ResponseBody
    public int aggiungiProdottoDaCatalogo(
            @RequestParam("prodottoId") Integer prodottoId,
            @RequestParam(value = "quantita", defaultValue = "1") int quantita,
            HttpSession session) {

        UtenteDto utenteLoggato = (UtenteDto) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null || prodottoId == null) {
            return 0;
        }
        carrelloService.aggiungiProdottoDaCatalogo(utenteLoggato.getId(), prodottoId, quantita);
        int totaleE= carrelloService.countElementi(utenteLoggato.getId());
        session.setAttribute("totaleE", totaleE);
        return totaleE ;
    }




}


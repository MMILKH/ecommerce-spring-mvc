package com.ecommercespring.controller;

import com.ecommercespring.dto.UtenteDto;
import com.ecommercespring.repository.UtenteRepository;
import com.ecommercespring.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BackOfficeController {
    @Autowired
    private UtenteService utenteService;
    @GetMapping("/admin")
    public String showAdminPage(HttpSession session, Model model)
    {
        UtenteDto utenteLoggato = (UtenteDto) session.getAttribute("utenteLoggato");
        if(utenteLoggato == null){
            return "redirect:/login";
        } else if ("amministratore".equals(utenteLoggato.getRuolo().getNome())||"operatore".equals(utenteLoggato.getRuolo().getNome())) {
            List<UtenteDto> utenti = utenteService.showAll();
            model.addAttribute("utenti", utenti);
            return "admin";
        }

        return "redirect:/login";

    }
}

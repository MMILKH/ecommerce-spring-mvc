package com.ecommercespring.controller;

import com.ecommercespring.dto.RequestLogin;
import com.ecommercespring.dto.UtenteDto;
import com.ecommercespring.model.Utente;
import com.ecommercespring.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UtenteService utenteService;


    @GetMapping("/login")
    public String showLogin(
            @RequestParam(value = "azione", required = false) String azione, HttpSession session, Model model) {

        if ("logout".equals(azione)) {
            session.invalidate();
        }
        model.addAttribute("loginDto", new RequestLogin());

        return "login";
    }


    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginDto") RequestLogin requestLogin,
                               HttpSession session,
                               Model model) {

        UtenteDto utente = utenteService.autentica(requestLogin);

        if (utente != null) {
            session.setAttribute("utenteLoggato", utente);
            return "redirect:/catalogo";
        } else {
            model.addAttribute("errore", "Email o password non validi!");
            return "login";
        }
    }


}

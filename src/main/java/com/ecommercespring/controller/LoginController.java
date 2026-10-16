package com.ecommercespring.controller;

import com.ecommercespring.dto.LoginDto;
import com.ecommercespring.model.Utente;
import com.ecommercespring.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UtenteService utenteService;


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginDto") LoginDto loginDto,
                               HttpSession session,
                               Model model) {

        Utente utente = utenteService.autentica(loginDto);

        if (utente != null) {
            session.setAttribute("utenteLoggato", utente);
            return "redirect:/catalogo";
        } else {
            model.addAttribute("errore", "Email o password non validi!");
            return "login";
        }
    }


}

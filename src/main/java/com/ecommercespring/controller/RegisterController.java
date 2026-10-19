package com.ecommercespring.controller;

import com.ecommercespring.dto.RequestLogin;
import com.ecommercespring.dto.UtenteDto;
import com.ecommercespring.model.Utente;
import com.ecommercespring.service.UtenteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class RegisterController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/register")
    public String showForm(HttpSession session, Model model) {
        model.addAttribute("utenteDto", new UtenteDto());
        return "register";
    }



    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("utenteDto") UtenteDto utenteDto, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "registrazione";
        }
        utenteService.registra(utenteDto);
        return "redirect:/login";
    }
}

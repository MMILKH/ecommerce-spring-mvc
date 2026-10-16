package com.ecommercespring.controller;

import com.ecommercespring.dto.ProdottoCatalogoDto;
import com.ecommercespring.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/catalogo")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public String mostraCatalogo(
            @RequestParam(value = "categoria", required = false) String categoria,
            Model model) {

        List<ProdottoCatalogoDto> prodotti;
        if (categoria != null && !categoria.trim().isEmpty()) {
            prodotti = prodottoService.mostraTuttiCat(categoria);
        } else {
            prodotti = prodottoService.mostraTutti();
        }
        model.addAttribute("listaProdotti", prodotti);
        return "catalogo";
    }
}
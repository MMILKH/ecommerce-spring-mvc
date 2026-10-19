package com.ecommercespring.controller;

import com.ecommercespring.dto.ProdottoDto;
import com.ecommercespring.service.CarrelloService;
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
    @Autowired
    private CarrelloService carrelloService;
    @GetMapping
    public String showCatalogo(
            @RequestParam(value = "categoria", required = false) String categoria,
            Model model) {

        List<ProdottoDto> prodotti;
        if (categoria != null && !categoria.trim().isEmpty()) {
            prodotti = prodottoService.showAllByCat(categoria);
        } else {
            prodotti = prodottoService.showAll();
        }
        model.addAttribute("listaProdotti", prodotti);
        return "catalogo";
    }



}
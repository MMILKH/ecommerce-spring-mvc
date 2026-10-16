package com.ecommercespring.service.impl;

import com.ecommercespring.dto.ProdottoCatalogoDto;
import com.ecommercespring.model.Prodotto;
import com.ecommercespring.repository.ProdottoRepository;
import com.ecommercespring.service.ProdottoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdottoServiceImpl implements ProdottoService {

    @Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProdottoCatalogoDto> mostraTutti() {
        List<Prodotto> prodotti = prodottoRepository.findAll();
        List<ProdottoCatalogoDto> prodottiDto = new ArrayList<>();
        for (Prodotto prodotto : prodotti) {
            prodottiDto.add(modelMapper.map(prodotto, ProdottoCatalogoDto.class));
        }
        return prodottiDto;
    }

    @Override
    public List<ProdottoCatalogoDto> mostraTuttiCat(String categoria) {
        List<ProdottoCatalogoDto> prodottiDto = new ArrayList<>();
        List<Prodotto> prodotti = prodottoRepository.findAllByCategoria(categoria);
        for (Prodotto prodotto : prodotti) {
            prodottiDto.add(modelMapper.map(prodotto, ProdottoCatalogoDto.class));
        }
        return prodottiDto;

    }
}

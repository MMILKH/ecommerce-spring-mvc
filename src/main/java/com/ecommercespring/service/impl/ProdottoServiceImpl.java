package com.ecommercespring.service.impl;

import com.ecommercespring.dto.ProdottoDto;

import com.ecommercespring.model.Prodotto;
import com.ecommercespring.repository.*;
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
    public List<ProdottoDto> showAll() {
        List<Prodotto> prodotti = prodottoRepository.findAll();
        List<ProdottoDto> prodottiDto = new ArrayList<>();
        for (Prodotto prodotto : prodotti) {
            prodottiDto.add(modelMapper.map(prodotto, ProdottoDto.class));
        }
        return prodottiDto;
    }

    @Override
    public List<ProdottoDto> showAllByCat(String categoria) {
        List<ProdottoDto> prodottiDto = new ArrayList<>();
        List<Prodotto> prodotti = prodottoRepository.findAllByCategoria(categoria);
        for (Prodotto prodotto : prodotti) {
            prodottiDto.add(modelMapper.map(prodotto, ProdottoDto.class));
        }
        return prodottiDto;

    }



}

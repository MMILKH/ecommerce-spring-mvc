package com.ecommercespring.service;

import com.ecommercespring.dto.ProdottoCatalogoDto;

import java.util.List;

public interface ProdottoService {

    List<ProdottoCatalogoDto> mostraTutti();

    List<ProdottoCatalogoDto> mostraTuttiCat(String categoria);
}

package com.ecommercespring.service;

import com.ecommercespring.dto.ProdottoDto;

import java.util.List;

public interface ProdottoService {

    List<ProdottoDto> showAll();

    List<ProdottoDto> showAllByCat(String categoria);


}

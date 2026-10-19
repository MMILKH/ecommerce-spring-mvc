package com.ecommercespring.dto;

public class RigaCarrelloDto {

    private ProdottoDto prodotto;
    private int id;
    private int quantita;

    public RigaCarrelloDto() {
    }

    public RigaCarrelloDto(ProdottoDto prodotto, int id, int quantita) {
        this.prodotto = prodotto;
        this.id = id;
        this.quantita = quantita;
    }

    public ProdottoDto getProdotto() {
        return prodotto;
    }

    public void setProdotto(ProdottoDto prodotto) {
        this.prodotto = prodotto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}

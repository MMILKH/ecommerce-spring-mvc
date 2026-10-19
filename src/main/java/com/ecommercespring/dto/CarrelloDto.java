package com.ecommercespring.dto;

import java.util.Date;

public class CarrelloDto {

    private Integer id;
    private String stato;
    private Date dataCreazione;
    private Date ultimoAggiornamento;

    private RequestLogin utente;


    public CarrelloDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Date getUltimoAggiornamento() {
        return ultimoAggiornamento;
    }

    public void setUltimoAggiornamento(Date ultimoAggiornamento) {
        this.ultimoAggiornamento = ultimoAggiornamento;
    }

    public RequestLogin getUtente() {
        return utente;
    }

    public void setUtente(RequestLogin utente) {
        this.utente = utente;
    }

}
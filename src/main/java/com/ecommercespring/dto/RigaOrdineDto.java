package com.ecommercespring.dto;

import com.ecommercespring.model.Carrello;
import com.ecommercespring.model.Prodotto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

public class RigaOrdineDto {


    private int id;
    private BigDecimal prezzoRiga;
    private BigDecimal prezzoUnitario;
    private Date dataCreazione;
    private int rigaCarrelloId;
    private int quantita;
    private Prodotto prodotto;
    private Carrello carrello;


    public RigaOrdineDto() {}

    public RigaOrdineDto(int id, Carrello carrello, Prodotto prodotto, int quantita, int rigaCarrelloId, Date dataCreazione, BigDecimal prezzoUnitario, BigDecimal prezzoRiga) {
        this.id = id;
        this.carrello = carrello;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.rigaCarrelloId = rigaCarrelloId;
        this.dataCreazione = dataCreazione;
        this.prezzoUnitario = prezzoUnitario;
        this.prezzoRiga = prezzoRiga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrezzoRiga() {
        return prezzoRiga;
    }

    public void setPrezzoRiga(BigDecimal prezzoRiga) {
        this.prezzoRiga = prezzoRiga;
    }

    public BigDecimal getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(BigDecimal prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public int getRigaCarrelloId() {
        return rigaCarrelloId;
    }

    public void setRigaCarrelloId(int rigaCarrelloId) {
        this.rigaCarrelloId = rigaCarrelloId;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }
}

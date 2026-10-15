package com.ecommercespring.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RIGA_ORDINE")
public class RigaOrdine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="PREZZO_RIGA",nullable = false)
    private BigDecimal prezzoRiga;

    @Column(name="PREZZO_UNITARIO",nullable = false)
    private BigDecimal prezzoUnitario;

    @Column(name = "DATA_CREAZIONE",nullable = false)
    private Date dataCreazione;

    @Column(name = "RIGA_CARRELLO_ID",nullable = false)
    private int rigaCarrelloId;

    @Column(name = "QUANTITA",nullable = false)
    private int quantita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODOTTO_ID",nullable = false)
    private Prodotto prodotto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDINE_ID",nullable = false)
    private Carrello carrello;


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

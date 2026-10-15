package com.ecommercespring.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RIGA_CARRELLO")
public class RigaCarrello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "QUANTITA",nullable = false)
    private int quantita;

    @Column(name = "DATA_CREAZIONE",nullable = false)
    private Date dataCreazione;

    @Column(name="DATA_ULTIMA_MODIFICA",nullable = false)
    private Date dataUltimaModifica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODOTTO_ID",nullable = false)
    private Prodotto prodotto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CARRELLO_ID",nullable = false)
    private Carrello carrello;


    public RigaCarrello() {}

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

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Date getDataUltimaModifica() {
        return dataUltimaModifica;
    }

    public void setDataUltimaModifica(Date dataUltimaModifica) {
        this.dataUltimaModifica = dataUltimaModifica;
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

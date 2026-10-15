package com.ecommercespring.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="CARRELLO")
public class Carrello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "STATO",nullable = false)
    private String stato;

    @Column(name = "DATA_CREAZIONE",nullable = false)
    private Date dataCreazione;

    @Column(name="ULTIMO_AGGIORNAMENTO",nullable = false)
    private Date ultimoAggiornamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UTENTE_ID",nullable = false)
    private Utente utente;

    public Carrello() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}





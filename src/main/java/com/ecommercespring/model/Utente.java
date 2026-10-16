package com.ecommercespring.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "UTENTE")
public class Utente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NOME",nullable = false)
    private String nome;

    @Column(name="COGNOME",nullable = false)
    private String cognome;

    @Column(name="EMAIL",nullable = false,unique = true)
    private String email;

    @Column(name="NUMERO",nullable = false)
    private String numero;

    @Column(name="INDIRIZZO")
    private String indirizzo;

    @Column(name = "PASSWORDU",nullable = false)
    private String password;

    @Column(name = "DATA_CREAZIONE",nullable = false)
    private Date dataCreazione;

    @Column(name="DATA_ULTIMA_MODIFICA",nullable = false)
    private Date dataUltimaModifica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RUOLO_ID",nullable = false)
    private Ruolo ruolo;

    public  Utente() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}

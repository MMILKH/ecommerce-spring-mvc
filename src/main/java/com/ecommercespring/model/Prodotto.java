package com.ecommercespring.model;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "PRODOTTO")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NOME",nullable = false)
    private String nome;

    @Column(name="SKU",nullable = false,unique = true)
    private String sku;

    @Column(name="DESCRIZIONEB",nullable = false)
    private String descrizioneBreve;

    @Column(name="DESCRIZIONEE",nullable = false)
    private String descrizioneEstesa;

    @Column(name="IMMAGINE",nullable = false)
    private String immagine;

    @Column(name = "CATEGORIA",nullable = false)
    private String categoria;

    @Column(name = "DISPONIBILITA",nullable = false)
    private int disponibilita;

    @Column(name="STATO_PUB",nullable = false)
    private int statoPub;

    @Column(name = "PREZZO",nullable = false)
    private BigDecimal prezzo;

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescrizioneBreve() {
        return descrizioneBreve;
    }

    public void setDescrizioneBreve(String descrizioneBreve) {
        this.descrizioneBreve = descrizioneBreve;
    }

    public String getDescrizioneEstesa() {
        return descrizioneEstesa;
    }

    public void setDescrizioneEstesa(String descrizioneEstesa) {
        this.descrizioneEstesa = descrizioneEstesa;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public int getStatoPub() {
        return statoPub;
    }

    public void setStatoPub(int statoPub) {
        this.statoPub = statoPub;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}

package com.ecommercespring.dto;

import java.math.BigDecimal;

public class ProdottoDto {

    private Integer id;
    private String nome;

    private String descrizioneBreve;
    private String descrizioneEstesa;
    private String immagine;

    private int disponibilita;

    private BigDecimal prezzo;

    public ProdottoDto() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }


    public String getDescrizioneBreve() { return descrizioneBreve; }
    public void setDescrizioneBreve(String descrizioneBreve) { this.descrizioneBreve = descrizioneBreve; }

    public String getDescrizioneEstesa() { return descrizioneEstesa; }
    public void setDescrizioneEstesa(String descrizioneEstesa) { this.descrizioneEstesa = descrizioneEstesa; }

    public String getImmagine() { return immagine; }
    public void setImmagine(String immagine) { this.immagine = immagine; }


    public int getDisponibilita() { return disponibilita; }
    public void setDisponibilita(int disponibilita) { this.disponibilita = disponibilita; }


    public BigDecimal getPrezzo() { return prezzo; }
    public void setPrezzo(BigDecimal prezzo) { this.prezzo = prezzo; }
}
package com.ecommercespring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "STATO")
public class Stato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NOME",nullable = false)
    private String nome;

    @Column(name="CODICE",nullable = false,unique = true)
    private String codice;

    @Column(name="DESCRIZIONE",nullable = false)
    private String descrizione;

    public Stato() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}

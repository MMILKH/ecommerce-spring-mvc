package com.ecommercespring.model;

import jakarta.persistence.*;


@Entity
@Table(name = "RUOLO")
public class Ruolo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NOME",nullable = false)
    private String nome;

    @Column(name="DESCRIZIONE",nullable = false)
    private String descrizione;

    public Ruolo() {}

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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}

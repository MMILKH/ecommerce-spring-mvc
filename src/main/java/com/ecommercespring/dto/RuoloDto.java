package com.ecommercespring.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RuoloDto {


    private int id;
    private String nome;
    private String descrizione;

    public RuoloDto(int id, String descrizione, String nome) {
        this.id = id;
        this.descrizione = descrizione;
        this.nome = nome;
    }

    public RuoloDto() {}

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

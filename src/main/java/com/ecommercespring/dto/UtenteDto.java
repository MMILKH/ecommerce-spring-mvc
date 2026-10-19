package com.ecommercespring.dto;

import com.ecommercespring.model.Ruolo;

public class UtenteDto {

    private String nome;
    private String cognome;
    private String email;
    private String numero;
    private String indirizzo;
    private String password;
    private String passwordconf;
    private int id;
    private RuoloDto ruolo;
    public UtenteDto() {}

    public UtenteDto(String nome, String cognome, String email, String numero, String indirizzo, String password, String passwordconf, int id,RuoloDto ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numero = numero;
        this.indirizzo = indirizzo;
        this.password = password;
        this.passwordconf = passwordconf;
        this.id = id;
        this.ruolo = ruolo;
    }

    public RuoloDto getRuolo() {
        return ruolo;
    }

    public void setRuolo(RuoloDto ruolo) {
        this.ruolo = ruolo;
    }



    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getIndirizzo() { return indirizzo; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPasswordconf() { return passwordconf; }
    public void setPasswordconf(String passwordconf) { this.passwordconf = passwordconf; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
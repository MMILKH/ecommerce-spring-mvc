package com.ecommercespring.dto;

import com.ecommercespring.model.Stato;
import com.ecommercespring.model.Utente;

import java.math.BigDecimal;
import java.util.Date;

public class OrdineDto {

    private int id;
    private Date dataCreazione;
    private String indirizzoSpedizione;
    private String indirizzoFatturazione;
    private BigDecimal importo;
    private String codice;
    private Utente utente;
    private Stato stato;

    public OrdineDto() {}

    public OrdineDto(int id, Date dataCreazione, String indirizzoSpedizione, String indirizzoFatturazione, BigDecimal importo, String codice, Utente utente, Stato stato) {
        this.id = id;
        this.dataCreazione = dataCreazione;
        this.indirizzoSpedizione = indirizzoSpedizione;
        this.indirizzoFatturazione = indirizzoFatturazione;
        this.importo = importo;
        this.codice = codice;
        this.utente = utente;
        this.stato = stato;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public String getIndirizzoSpedizione() {
        return indirizzoSpedizione;
    }

    public void setIndirizzoSpedizione(String indirizzoSpedizione) {
        this.indirizzoSpedizione = indirizzoSpedizione;
    }

    public String getIndirizzoFatturazione() {
        return indirizzoFatturazione;
    }

    public void setIndirizzoFatturazione(String indirizzoFatturazione) {
        this.indirizzoFatturazione = indirizzoFatturazione;
    }

    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}

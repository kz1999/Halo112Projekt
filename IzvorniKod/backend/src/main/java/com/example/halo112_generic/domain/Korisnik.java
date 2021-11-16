package com.example.halo112_generic.domain;

import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Korisnik {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotNull
    @Size(min=8, max=30)
    private String korisnickoIme;

    private String fotografija;

    private String hashLozinke;

    private String ime;

    private String prezime;

    private String brojMobitela;

    private String email;

    private String uloga;

    private boolean potvrden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getFotografija() {
        return fotografija;
    }

    public void setFotografija(String fotografija) {
        this.fotografija = fotografija;
    }

    public String getHashLozinke() {
        return hashLozinke;
    }

    public void setHashLozinke(String hashLozinke) {
        this.hashLozinke = hashLozinke;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojMobitela() {
        return brojMobitela;
    }

    public void setBrojMobitela(String brojMobitela) {
        this.brojMobitela = brojMobitela;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public boolean isPotvrden() {
        return potvrden;
    }

    public void setPotvrden(boolean potvrden) {
        this.potvrden = potvrden;
    }
}

package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.EnumSet;


public class RegistraceForm {

    @NotBlank
    private String jmeno;

    @NotBlank
    private String prijmeni;

    @NotNull
    private LocalDate datumNarozeni;

    @NotNull
    private EnumSet<Pohlavi> pohlavi;

    private EnumSet<Sport> sport;

    @NotBlank
    private String turnus;

    @Email
    private String email;

    private String telefon;

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public EnumSet<Pohlavi> getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(EnumSet<Pohlavi> pohlavi) {
        this.pohlavi = pohlavi;
    }

    public EnumSet<Sport> getSport() {
        return sport;
    }

    public void setSport(EnumSet<Sport> sport) {
        this.sport = sport;
    }

    public String getTurnus() {
        return turnus;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

package com.asss.pj.TuristickaAgencija.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "turisticki_paket")
public class TuristickiPaket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "destinacija")
    private String destinacija;

    @Column(name = "opis")
    private String opis;

    @Column(name = "datum_putovanja")
    private Date datumPutovanja;

    @Column(name = "cena")
    private double cena;

    @Column(name = "status_dostupnosti")
    private boolean statusDostupnosti;

    public TuristickiPaket() {
    }

    public TuristickiPaket(String destinacija, String opis, Date datumPutovanja, double cena, boolean statusDostupnosti) {
        this.destinacija = destinacija;
        this.opis = opis;
        this.datumPutovanja = datumPutovanja;
        this.cena = cena;
        this.statusDostupnosti = statusDostupnosti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinacija() {
        return destinacija;
    }

    public void setDestinacija(String destinacija) {
        this.destinacija = destinacija;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatumPutovanja() {
        return datumPutovanja;
    }

    public void setDatumPutovanja(Date datumPutovanja) {
        this.datumPutovanja = datumPutovanja;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public boolean isStatusDostupnosti() {
        return statusDostupnosti;
    }

    public void setStatusDostupnosti(boolean statusDostupnosti) {
        this.statusDostupnosti = statusDostupnosti;
    }

    @Override
    public String toString() {
        return "TuristickiPaket{" +
                "id=" + id +
                ", destinacija='" + destinacija + '\'' +
                ", opis='" + opis + '\'' +
                ", datumPutovanja=" + datumPutovanja +
                ", cena=" + cena +
                ", statusDostupnosti=" + statusDostupnosti +
                '}';
    }
}

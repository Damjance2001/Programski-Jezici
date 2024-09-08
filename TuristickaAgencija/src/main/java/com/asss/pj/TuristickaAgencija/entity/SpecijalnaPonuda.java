package com.asss.pj.TuristickaAgencija.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "specijalna_ponuda")
public class SpecijalnaPonuda {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne()
    @JoinColumn(name = "turisticki_paket_id") // Foreign key column to establish the relationship
    private TuristickiPaket turistickiPaket;


    // Integer - popust, TuristickiPaket - objekat
    @Column(name = "opis")
    private String opis;

    @Column(name = "popust")
    private int popust;

    public SpecijalnaPonuda() {
    }

    public SpecijalnaPonuda(TuristickiPaket turistickiPaket, String opis, int popust) {
        this.turistickiPaket = turistickiPaket;
        this.opis = opis;
        this.popust = popust;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TuristickiPaket getTuristickiPaket() {
        return turistickiPaket;
    }

    public void setTuristickiPaket(TuristickiPaket turistickiPaket) {
        this.turistickiPaket = turistickiPaket;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    @Override
    public String toString() {
        return "SpecijalnaPonuda{" +
                "id=" + id +
                ", turistickiPaket=" + turistickiPaket +
                ", opis='" + opis + '\'' +
                ", popust=" + popust +
                '}';
    }
}

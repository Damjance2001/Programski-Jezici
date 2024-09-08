package com.asss.pj.TuristickaAgencija.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "rezervacija")
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "klijent_id")
    private Klijent klijent;

    @OneToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "turisticki_paket_id")
    private TuristickiPaket turistickiPaket;

    @Column(name = "datum_rezervacije")
    private Date datumRezervacije;

    @Column(name = "status_rezervacije")
    private boolean statusRezervacije;

    public Rezervacija() {

    }

    public Rezervacija(Klijent klijent, TuristickiPaket turistickiPaket, Date datumRezervacije, boolean statusRezervacije) {
        this.klijent = klijent;
        this.turistickiPaket = turistickiPaket;
        this.datumRezervacije = datumRezervacije;
        this.statusRezervacije = statusRezervacije;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public TuristickiPaket getTuristickiPaket() {
        return turistickiPaket;
    }

    public void setTuristickiPaket(TuristickiPaket turistickiPaket) {
        this.turistickiPaket = turistickiPaket;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public boolean isStatusRezervacije() {
        return statusRezervacije;
    }

    public void setStatusRezervacije(boolean statusRezervacije) {
        this.statusRezervacije = statusRezervacije;
    }

    @Override
    public String toString() {
        return "Rezervacija{" +
                "klijent=" + klijent +
                ", turistickiPaket=" + turistickiPaket +
                ", datumRezervacije=" + datumRezervacije +
                ", statusRezervacije=" + statusRezervacije +
                '}';
    }
}

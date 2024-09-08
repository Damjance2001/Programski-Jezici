package com.asss.pj.TuristickaAgencija.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "klijent")
public class Klijent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "kontakt_informacije")
    private String kontaktInformacije;


    @Column(name = "istorija_rezervacije")
    private String istorijaRezervacije;

    public Klijent() {
    }

    public Klijent(String ime, String prezime, String kontaktInformacije, String istorijaRezervacije) {
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktInformacije = kontaktInformacije;
        this.istorijaRezervacije = istorijaRezervacije;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getKontaktInformacije() {
        return kontaktInformacije;
    }

    public void setKontaktInformacije(String kontaktInformacije) {
        this.kontaktInformacije = kontaktInformacije;
    }

    public String getIstorijaRezervacije() {
        return istorijaRezervacije;
    }

    public void setIstorijaRezervacije(String istorijaRezervacije) {
        this.istorijaRezervacije = istorijaRezervacije;
    }


    @Override
    public String toString() {
        return "Klijent{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", kontaktInformacije='" + kontaktInformacije + '\'' +
                ", istorijaRezervacije='" + istorijaRezervacije + '\'' +
                '}';
    }
}

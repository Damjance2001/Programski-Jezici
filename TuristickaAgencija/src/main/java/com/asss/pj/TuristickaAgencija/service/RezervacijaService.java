package com.asss.pj.TuristickaAgencija.service;

import com.asss.pj.TuristickaAgencija.entity.Rezervacija;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RezervacijaService {
    List<Rezervacija> findAll();

    Optional<Rezervacija> findById(int theId);

    Rezervacija save(Rezervacija rezervacija);

    void deleteById(int theId);

    Rezervacija dodajTuristickiPaket(int rezervacijaId, int turistickiPaketId);

    Rezervacija dodajKlijenta(int rezervacijaId, int klijentId);

    // kod za filtriranje
    List<Rezervacija> findAllSortedBy(String sortBy);

}

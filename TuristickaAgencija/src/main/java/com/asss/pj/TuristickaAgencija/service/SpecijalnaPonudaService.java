package com.asss.pj.TuristickaAgencija.service;

import com.asss.pj.TuristickaAgencija.entity.Klijent;
import com.asss.pj.TuristickaAgencija.entity.SpecijalnaPonuda;

import java.util.List;
import java.util.Optional;

public interface SpecijalnaPonudaService {
    List<SpecijalnaPonuda> findAll();

    Optional<SpecijalnaPonuda> findById(int theId);

    SpecijalnaPonuda save(SpecijalnaPonuda specijalnaPonuda);

    void deleteById(int theId);

    SpecijalnaPonuda addTuristickiPaket(int specijalnaPonudaId, int turistickiPaketId);

    void initializeSpecijalnaPonuda();

    void threadForInitialization();
}

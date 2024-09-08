package com.asss.pj.TuristickaAgencija.service;

import com.asss.pj.TuristickaAgencija.entity.Klijent;

import java.util.List;
import java.util.Optional;

public interface KlijentService {
    List<Klijent> findAll();

    Optional<Klijent> findById(int theId);

    Klijent save(Klijent klijent);

    void deleteById(int theId);
}

package com.asss.pj.TuristickaAgencija.service;

import com.asss.pj.TuristickaAgencija.entity.TuristickiPaket;

import java.util.List;
import java.util.Optional;

public interface TuristickiPaketService {
    List<TuristickiPaket> findAll();

    Optional<TuristickiPaket> findById(int theId);

    TuristickiPaket save(TuristickiPaket turistickiPaket);

    void deleteById(int theId);

}

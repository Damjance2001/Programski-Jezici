package com.asss.pj.TuristickaAgencija.service;

import com.asss.pj.TuristickaAgencija.entity.TuristickiPaket;
import com.asss.pj.TuristickaAgencija.repo.TuristickiPaketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TuristickiPaketServiceImpl implements TuristickiPaketService {


    // dependency injection
    private final TuristickiPaketRepo turistickiPaketRepo;

    @Autowired // umetanje zavisnosti dao sloja
    public TuristickiPaketServiceImpl(TuristickiPaketRepo turistickiPaketRepo) {
        this.turistickiPaketRepo = turistickiPaketRepo;
    }

    @Override
    public List<TuristickiPaket> findAll() {
        return turistickiPaketRepo.findAll();
    }

    @Override
    public Optional<TuristickiPaket> findById(int theId) {
        // 'Optional' koristi se za predstavljanje vrednosti koja moze ili ne mora biti prisutna

        Optional<TuristickiPaket> result = turistickiPaketRepo.findById(theId);
        if (result.isPresent()) {
            return Optional.of(result.get());
        }
        throw new NullPointerException("Turisticki paket not found with id: " + theId);
    }

    @Override
    public TuristickiPaket save(TuristickiPaket turistickiPaket) {
        return turistickiPaketRepo.save(turistickiPaket);
    }


    @Override
    public void deleteById(int theId) {
        turistickiPaketRepo.deleteById(theId);
    }

}

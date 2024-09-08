package com.asss.pj.TuristickaAgencija.service;

import com.asss.pj.TuristickaAgencija.entity.Klijent;
import com.asss.pj.TuristickaAgencija.repo.KlijentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KlijentServiceImpl implements KlijentService {


    // dependency injection
    private KlijentRepo klijentRepo;

    @Autowired // umetanje zavisnosti dao sloja
    public KlijentServiceImpl(KlijentRepo klijentRepo) {
        this.klijentRepo = klijentRepo;
    }

    @Override
    public List<Klijent> findAll() {
        return klijentRepo.findAll();
    }

    @Override
    public Optional<Klijent> findById(int theId) {
        // 'Optional' koristi se za predstavljanje vrednosti koja moze ili ne mora biti prisutna

        Optional<Klijent> result = klijentRepo.findById(theId);
        if (result.isPresent()) {
            return Optional.of(result.get());
        }
        throw new NullPointerException("Klijent not found with id: " + theId);
    }

    @Override
    public Klijent save(Klijent klijent) {
        return klijentRepo.save(klijent);
    }


    @Override
    public void deleteById(int theId) {
        klijentRepo.deleteById(theId);
    }
}

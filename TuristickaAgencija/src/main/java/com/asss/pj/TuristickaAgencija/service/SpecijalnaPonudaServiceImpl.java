package com.asss.pj.TuristickaAgencija.service;

import com.asss.pj.TuristickaAgencija.entity.SpecijalnaPonuda;
import com.asss.pj.TuristickaAgencija.entity.TuristickiPaket;
import com.asss.pj.TuristickaAgencija.repo.SpecijalnaPonudaRepo;
import com.asss.pj.TuristickaAgencija.repo.TuristickiPaketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecijalnaPonudaServiceImpl implements SpecijalnaPonudaService {

    private final SpecijalnaPonudaRepo specijalnaPonudaRepo;
    private final TuristickiPaketRepo turistickiPaketRepo;

    // dependency injection
    @Autowired // umetanje zavisnosti dao sloja
    public SpecijalnaPonudaServiceImpl(SpecijalnaPonudaRepo specijalnaPonudaRepo, TuristickiPaketRepo turistickiPaketRepo) {
        this.specijalnaPonudaRepo = specijalnaPonudaRepo;
        this.turistickiPaketRepo = turistickiPaketRepo;
    }

    @Override
    public List<SpecijalnaPonuda> findAll() {
        return specijalnaPonudaRepo.findAll();
    }

    @Override
    public Optional<SpecijalnaPonuda> findById(int theId) {
        // 'Optional' koristi se za predstavljanje vrednosti koja moze ili ne mora biti prisutna

        Optional<SpecijalnaPonuda> result = specijalnaPonudaRepo.findById(theId);
        if (result.isPresent()) {
            return Optional.of(result.get());
        }
        throw new NullPointerException("Specijalna ponuda not found with id: " + theId);
    }

    @Override
    public SpecijalnaPonuda save(SpecijalnaPonuda specijalnaPonuda) {
        return specijalnaPonudaRepo.save(specijalnaPonuda);
    }


    @Override
    public void deleteById(int theId) {
        specijalnaPonudaRepo.deleteById(theId);
    }


    @Override
    public SpecijalnaPonuda addTuristickiPaket(int specijalnaPonudaId, int turistickiPaketId) {

        Optional<SpecijalnaPonuda> specijalnaPonudaOptional = specijalnaPonudaRepo.findById(specijalnaPonudaId);
        Optional<TuristickiPaket> turistickiPaketOptional = turistickiPaketRepo.findById(turistickiPaketId);
        if (specijalnaPonudaOptional.isEmpty()) {
            throw new NullPointerException("Specijalna ponuda not found with id: " + specijalnaPonudaId);
        }

        if (turistickiPaketOptional.isEmpty()) {
            throw new NullPointerException("Turisticki paket not found with id: " + turistickiPaketId);
        }

        SpecijalnaPonuda specijalnaPonuda = specijalnaPonudaOptional.get();
        TuristickiPaket turistickiPaket = turistickiPaketOptional.get();

        specijalnaPonuda.setTuristickiPaket(turistickiPaket);

        return specijalnaPonudaRepo.save(specijalnaPonuda);
    }

    @Override
    public void initializeSpecijalnaPonuda() {
        // citanje svih paketa
        List<TuristickiPaket> turistickiPakets = turistickiPaketRepo.findAll();

        // "uzimanje" nasumicnog paketa
        TuristickiPaket turistickiPaket = turistickiPakets.get((int) (Math.random() * turistickiPakets.size()));

        SpecijalnaPonuda specijalnaPonuda = new SpecijalnaPonuda();
        specijalnaPonuda.setTuristickiPaket(turistickiPaket);

        // postavljanje nasumicnog popusta
        int discount = (int) (Math.random() * 100);
        specijalnaPonuda.setOpis("Specijalna ponuda sa popustom od " + discount + "%");
        specijalnaPonuda.setPopust(discount);


        specijalnaPonudaRepo.save(specijalnaPonuda);
    }

    private double discountCalculation(double price, int discount) {
        return price * (100 - discount) / 100;
    }

    @Override
    @Async
    public void threadForInitialization() {
        // Zakazuje se tajmer za 2 sekundi
        Thread thread = new Thread(() -> {// inicijalizuje se objekat thread
            try {
                Thread.sleep(1000);
                initializeSpecijalnaPonuda(); // Zove se metoda initializeSpecijalnaPonuda posle 2 sekundi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start(); // pokrece se objekat thread
    }


}

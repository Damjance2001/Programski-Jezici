package com.asss.pj.TuristickaAgencija.service;

import com.asss.pj.TuristickaAgencija.entity.Klijent;
import com.asss.pj.TuristickaAgencija.entity.Rezervacija;
import com.asss.pj.TuristickaAgencija.entity.TuristickiPaket;
import com.asss.pj.TuristickaAgencija.repo.KlijentRepo;
import com.asss.pj.TuristickaAgencija.repo.RezervacijaRepo;
import com.asss.pj.TuristickaAgencija.repo.TuristickiPaketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RezervacijaServiceImpl implements RezervacijaService {


    // dependency injection
    private final RezervacijaRepo rezervacijaRepo;
    private final TuristickiPaketRepo turistickiPaketRepo;
    private final KlijentRepo klijentRepo;

    @Autowired // umetanje zavisnosti dao sloja
    public RezervacijaServiceImpl(RezervacijaRepo rezervacijaRepo, TuristickiPaketRepo turistickiPaketRepo, KlijentRepo klijentRepo) {
        this.rezervacijaRepo = rezervacijaRepo;
        this.turistickiPaketRepo = turistickiPaketRepo;
        this.klijentRepo = klijentRepo;
    }

    @Override
    public List<Rezervacija> findAll() {
        return rezervacijaRepo.findAll();
    }

    @Override
    public Optional<Rezervacija> findById(int theId) {
        // 'Optional' koristi se za predstavljanje vrednosti koja moze ili ne mora biti prisutna

        Optional<Rezervacija> result = rezervacijaRepo.findById(theId);
        if (result.isPresent()) {
            return Optional.of(result.get());
        }
        throw new NullPointerException("Rezervacija not found with id: " + theId);
    }

    @Override
    public Rezervacija save(Rezervacija rezervacija) {
        return rezervacijaRepo.save(rezervacija);
    }


    @Override
    public void deleteById(int theId) {
        rezervacijaRepo.deleteById(theId);
    }

    @Override
    public Rezervacija dodajTuristickiPaket(int rezervacijaId, int turistickiPaketId) {
        // Čitanje objekata preko ID-a
        Optional<Rezervacija> rezervacijaOptional = rezervacijaRepo.findById(rezervacijaId);
        Optional<TuristickiPaket> turistickiPaketOptional = turistickiPaketRepo.findById(turistickiPaketId);

        // Provera da li postoje traženi objekti
        if (rezervacijaOptional.isEmpty()) {
            throw new NullPointerException("Rezervacija not found with id: " + rezervacijaId);
        }

        if (turistickiPaketOptional.isEmpty()) {
            throw new NullPointerException("Turisticki paket not found with id: " + turistickiPaketId);
        }


        // Pretvaranje objekata u konkretne promenljive
        Rezervacija rezervacija = rezervacijaOptional.get();
        TuristickiPaket turistickiPaket = turistickiPaketOptional.get();

        // Dodavanje turistickog paketa u rezervaciju

        rezervacija.setTuristickiPaket(turistickiPaket);

        // Postavljanje datuma rezervacije
        rezervacija.setDatumRezervacije(new Date());

        // Postavljanje statusa rezervacije na true
        rezervacija.setStatusRezervacije(true);

        // Sačuvaj promene u oba repozitorijuma
        turistickiPaketRepo.save(turistickiPaket); // Sačuvaj ažurirani turistički paket
        return rezervacijaRepo.save(rezervacija); // Sačuvaj ažuriranu rezervaciju
    }

    @Override
    public Rezervacija dodajKlijenta(int rezervacijaId, int klijentId) {

        Optional<Rezervacija> rezervacijaOptional = rezervacijaRepo.findById(rezervacijaId);
        Optional<Klijent> klijentOptional = klijentRepo.findById(klijentId);
        if (rezervacijaOptional.isEmpty()) {
            throw new NullPointerException("Rezervacija not found with id: " + rezervacijaId);
        }

        if (klijentOptional.isEmpty()) {
            throw new NullPointerException("Klijent not found with id: " + klijentId);
        }

        Rezervacija rezervacija = rezervacijaOptional.get();
        Klijent klijent = klijentOptional.get();
        rezervacija.setKlijent(klijent);

        String istorijaRezervacije = klijent.getIstorijaRezervacije();


        // kod za formatiranje istorije rezervacije ZA KLIJENTA
        // formatira se samo u bazi, formatiranje ne radi za json objekte
        if (istorijaRezervacije != null) {
            List<String> istorijaRezervacijeList = new ArrayList<>();

            String sb = istorijaRezervacije + ";\n- " + rezervacija;

            klijent.setIstorijaRezervacije(sb);
        }

        else {
            klijent.setIstorijaRezervacije("- " + istorijaRezervacije);
        }
        return rezervacijaRepo.save(rezervacija);
    }

    // kod za sortiranje
    @Override
    public List<Rezervacija> findAllSortedBy(String sortBy) {
        Sort sort = getSort(sortBy);
        return rezervacijaRepo.findAllSortedBy(sort);
    }

    private Sort getSort(String sortBy) {
        String sort = sortBy.toLowerCase();// postavlja se na mala slova
        switch (sort) {
            case "cena-asc":
                return Sort.by(Sort.Order.asc("turistickiPaket.cena"));
            case "cena-desc":
                return Sort.by(Sort.Order.desc("turistickiPaket.cena"));
            case "destinacija-asc":
                return Sort.by(Sort.Order.asc("turistickiPaket.destinacija"));
            case "destinacija-desc":
                return Sort.by(Sort.Order.desc("turistickiPaket.destinacija"));
            case "datum-asc":
                return Sort.by(Sort.Order.asc("datumRezervacije"));
            case "datum-desc":
                return Sort.by(Sort.Order.desc("datumRezervacije"));
            default:
                throw new IllegalArgumentException("Invalid sort by option: " + sortBy + "\n" +
                        "Valid options are:\n- cena-asc,\n- cena-desc,\n- destinacija-asc," +
                        "\n- destinacija-desc,\n- datum-asc,\n- datum-desc");
        }
    }

}

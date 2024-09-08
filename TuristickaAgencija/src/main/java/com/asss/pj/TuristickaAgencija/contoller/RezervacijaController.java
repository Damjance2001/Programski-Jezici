package com.asss.pj.TuristickaAgencija.contoller;

import com.asss.pj.TuristickaAgencija.entity.Rezervacija;
import com.asss.pj.TuristickaAgencija.service.RezervacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class RezervacijaController {

    private final RezervacijaService rezervacijaService;

    @Autowired
    public RezervacijaController(RezervacijaService rezervacijaService) {
        this.rezervacijaService = rezervacijaService;
    }

    @GetMapping("/rezervacije")
    public List<Rezervacija> getRezervacije() {
        return rezervacijaService.findAll();

    }

    @GetMapping("/rezervacija/{rezervacijaId}")
    public Optional<Rezervacija> getRezervacija(@PathVariable int rezervacijaId) {

        Optional<Rezervacija> rezervacija = rezervacijaService.findById(rezervacijaId);

        if (rezervacija == null) {
            throw new NullPointerException("Rezervacija not found with id: " + rezervacijaId);
        }

        return rezervacija;
    }

    @PostMapping("/rezervacija")
    public Rezervacija addRezervacija(@RequestBody Rezervacija rezervacija) {

        // na ovaj nacin izbegavamo da korisnik doda id
        rezervacija.setId(0); // kasnije u bazi ce se postaviti konkretan id
        // u suprotnom bi promenio red sa datim id-em

        Rezervacija dbRezervacija = rezervacijaService.save(rezervacija);

        return dbRezervacija;
    }

    @PutMapping("/rezervacija")
    // koristi se za update ili za insert ukoliko ne postoji objekat u bazi
    public Rezervacija updateRezervacija(@RequestBody Rezervacija rezervacija) {
        // U principu je isto kao i addPacijent metoda
        // Ovim se samo prati pravilan http zahtev (PUT)

        Rezervacija dbRezervacija = rezervacijaService.save(rezervacija);

        return dbRezervacija;
    }


    @DeleteMapping("/rezervacija/{rezervacijaId}")
    public String deleteRezervacija(@PathVariable int rezervacijaId) {

        Optional<Rezervacija> tempRezervacija = null;

        tempRezervacija = rezervacijaService.findById(rezervacijaId);

        if (tempRezervacija == null) {
            return "Rezervacija id not found: " + rezervacijaId;
        }

        rezervacijaService.deleteById(rezervacijaId);

        return "Deleted rezervacija id: " + rezervacijaId;
    }


    // dodavanje paketa
    @PutMapping("/rezervacija/{rezervacijaId}/turisticki-paket/{turistickiPaketId}")
    public Rezervacija dodajTuristickiPaket(@PathVariable int rezervacijaId, @PathVariable int turistickiPaketId) {
        return rezervacijaService.dodajTuristickiPaket(rezervacijaId, turistickiPaketId);
    }

    // dodavanje klijenta
    @PutMapping("/rezervacija/{rezervacijaId}/klijent/{klijentId}")
    public Rezervacija dodajKlijenta(@PathVariable int rezervacijaId, @PathVariable int klijentId) {
        return rezervacijaService.dodajKlijenta(rezervacijaId, klijentId);
    }

    // filtriranje
    @GetMapping("/rezervacije/sorted/{sortBy}")
    public List<Rezervacija> getSortedRezervacije(@PathVariable String sortBy) {
        return rezervacijaService.findAllSortedBy(sortBy);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleNullPointerException(NullPointerException e) {
        return e.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        return e.getMessage();
    }


}

package com.asss.pj.TuristickaAgencija.contoller;

import com.asss.pj.TuristickaAgencija.entity.TuristickiPaket;
import com.asss.pj.TuristickaAgencija.service.TuristickiPaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class TuristickiPaketController {

    private final TuristickiPaketService turistickiPaketService;

    @Autowired
    public TuristickiPaketController(TuristickiPaketService turistickiPaketService) {
        this.turistickiPaketService = turistickiPaketService;
    }

    @GetMapping("/turisticki-paketi")
    public List<TuristickiPaket> getTuristickiPaket() {
        return turistickiPaketService.findAll();

    }

    @GetMapping("/turisticki-paket/{turistickiPaketId}")
    public Optional<TuristickiPaket> getRezervacija(@PathVariable int turistickiPaketId) {

        Optional<TuristickiPaket> turistickiPaket = turistickiPaketService.findById(turistickiPaketId);

        if (turistickiPaket == null) {
            throw new NullPointerException("Turisticki paket not found with id: " + turistickiPaketId);
        }

        return turistickiPaket;
    }

    @PostMapping("/turisticki-paket")
    public TuristickiPaket addTuristickiPaket(@RequestBody TuristickiPaket turistickiPaket) {

        // na ovaj nacin izbegavamo da korisnik doda id
        turistickiPaket.setId(0); // kasnije u bazi ce se postaviti konkretan id
        // u suprotnom bi promenio red sa datim id-em

        TuristickiPaket dbTuristickiPaket = turistickiPaketService.save(turistickiPaket);

        return dbTuristickiPaket;
    }

    @PutMapping("/turisticki-paket")
    // koristi se za update ili za insert ukoliko ne postoji objekat u bazi
    public TuristickiPaket updateTuristickiPaket(@RequestBody TuristickiPaket turistickiPaket) {
        // U principu je isto kao i addPacijent metoda
        // Ovim se samo prati pravilan http zahtev (PUT)

        TuristickiPaket dbTuristickiPaket = turistickiPaketService.save(turistickiPaket);

        return dbTuristickiPaket;
    }


    @DeleteMapping("/turisticki-paket/{turistickiPaketId}")
    public String deleteTuristickiPaket(@PathVariable int turistickiPaketId) {

        Optional<TuristickiPaket> tempTuristickiPaket = null;

        tempTuristickiPaket = turistickiPaketService.findById(turistickiPaketId);

        if (tempTuristickiPaket == null) {
            return "Rezervacija id not found: " + turistickiPaketId;
        }

        turistickiPaketService.deleteById(turistickiPaketId);

        return "Deleted turisticki paket id: " + turistickiPaketId;
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

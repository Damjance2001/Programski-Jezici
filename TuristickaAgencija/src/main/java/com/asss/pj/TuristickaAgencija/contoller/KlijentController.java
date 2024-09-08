package com.asss.pj.TuristickaAgencija.contoller;

import com.asss.pj.TuristickaAgencija.entity.Klijent;
import com.asss.pj.TuristickaAgencija.service.KlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class KlijentController {

    private final KlijentService klijentService;

    @Autowired
    public KlijentController(KlijentService klijentService) {
        this.klijentService = klijentService;
    }

    @GetMapping("/klijenti")
    public List<Klijent> getKlijents() {
        return klijentService.findAll();

    }

    @GetMapping("/klijent/{klijentId}")
    public Optional<Klijent> getKlijent(@PathVariable int klijentId) {

        Optional<Klijent> klijent = klijentService.findById(klijentId);

        if (klijent == null) {
            throw new NullPointerException("Klijent not found with id: " + klijentId);
        }

        return klijent;
    }

    @PostMapping("/klijent")
    public Klijent addKlijent(@RequestBody Klijent klijent) {

        // na ovaj nacin izbegavamo da korisnik doda id
        klijent.setId(0); // kasnije u bazi ce se postaviti konkretan id
        // u suprotnom bi promenio red sa datim id-em

        Klijent dbKlijent = klijentService.save(klijent);

        return dbKlijent;
    }

    @PutMapping("/klijent")
    // koristi se za update ili za insert ukoliko ne postoji objekat u bazi
    public Klijent updateKlijent(@RequestBody Klijent klijent) {
        // U principu je isto kao i addPacijent metoda
        // Ovim se samo prati pravilan http zahtev (PUT)

        Klijent dbKlijent = klijentService.save(klijent);

        return dbKlijent;
    }


    @DeleteMapping("/klijent/{klijentId}")
    public String deleteKlijent(@PathVariable int klijentId) {

        Optional<Klijent> tempKlijent = null;

        tempKlijent = klijentService.findById(klijentId);

        if (tempKlijent == null) {
            return "Pacijent id not found: " + klijentId;
        }

        klijentService.deleteById(klijentId);

        return "Deleted pacijent id: " + klijentId;
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

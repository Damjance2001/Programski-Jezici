package com.asss.pj.TuristickaAgencija.contoller;

import com.asss.pj.TuristickaAgencija.entity.SpecijalnaPonuda;
import com.asss.pj.TuristickaAgencija.service.SpecijalnaPonudaService;
import com.asss.pj.TuristickaAgencija.service.TuristickiPaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class SpecijalnaPonudaController {

    private final SpecijalnaPonudaService specijalnaPonudaService;
    private final TuristickiPaketService turistickiPaketService;

    @Autowired
    public SpecijalnaPonudaController(SpecijalnaPonudaService specijalnaPonudaService, TuristickiPaketService turistickiPaketService) {
        this.specijalnaPonudaService = specijalnaPonudaService;
        this.turistickiPaketService = turistickiPaketService;
    }

    @GetMapping("/specijalne-ponude")
    public List<SpecijalnaPonuda> getSpecijalnePonude() {
        return specijalnaPonudaService.findAll();

    }

    @GetMapping("/specijalna-ponuda/{specijalnaPonudaId}")
    public Optional<SpecijalnaPonuda> getSpecijalnaPonuda(@PathVariable int specijalnaPonudaId) {

        Optional<SpecijalnaPonuda> specijalnaPonuda = specijalnaPonudaService.findById(specijalnaPonudaId);

        if (specijalnaPonuda == null) {
            throw new NullPointerException("Specijalna ponuda not found with id: " + specijalnaPonudaId);
        }

        return specijalnaPonuda;
    }

    @PostMapping("/specijalna-ponuda")
    public SpecijalnaPonuda addSpecijalnaPonuda(@RequestBody SpecijalnaPonuda specijalnaPonuda) {

        // na ovaj nacin izbegavamo da korisnik doda id
        specijalnaPonuda.setId(0); // kasnije u bazi ce se postaviti konkretan id
        // u suprotnom bi promenio red sa datim id-em

        SpecijalnaPonuda dbSpecijalnaPonuda = specijalnaPonudaService.save(specijalnaPonuda);

        return dbSpecijalnaPonuda;
    }

    @PutMapping("/specijalna-ponuda")
    // koristi se za update ili za insert ukoliko ne postoji objekat u bazi
    public SpecijalnaPonuda updateSpecijalnaPonuda(@RequestBody SpecijalnaPonuda specijalnaPonuda) {
        // U principu je isto kao i addPacijent metoda
        // Ovim se samo prati pravilan http zahtev (PUT)

        SpecijalnaPonuda dbSpecijalnaPonuda = specijalnaPonudaService.save(specijalnaPonuda);

        return dbSpecijalnaPonuda;
    }


    @DeleteMapping("/specijalna-ponuda/{specijalnaPonudaId}")
    public String deleteSpecijalnaPonuda(@PathVariable int specijalnaPonudaId) {

        Optional<SpecijalnaPonuda> tempTuristickiPaket = null;

        tempTuristickiPaket = specijalnaPonudaService.findById(specijalnaPonudaId);

        if (tempTuristickiPaket == null) {
            return "Specijalna ponuda id not found: " + specijalnaPonudaId;
        }

        specijalnaPonudaService.deleteById(specijalnaPonudaId);

        return "Deleted specijalna ponuda id: " + specijalnaPonudaId;
    }

    @PutMapping("/specijalna-ponuda/{specijalnaPonudaId}/turisticki-paket/{turistickiPaketId}")
    public SpecijalnaPonuda addTuristickiPaket(@PathVariable int specijalnaPonudaId, @PathVariable int turistickiPaketId) {
        return specijalnaPonudaService.addTuristickiPaket(specijalnaPonudaId, turistickiPaketId);
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

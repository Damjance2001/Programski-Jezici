# Funkcionalnosti:

### ~~a) Pregled putovanja: Omogućiti klijentima da pregledaju dostupne turističke pakete, uključujući destinacije, datume putovanja, cene i detaljne opise.~~
### ~~b) Rezervacija putovanja: Mogućnost online rezervacije putovanja, sa opcijama filtriranja prema destinaciji, datumu i ceni.~~
### ~~c) Validacija dostupnosti: Vođenje evidencije o klijentima i njihovim prethodnim putovanjima i rezervacijama.~~
### d) Upravljanje klijentima: Slanje automatskih obaveštenja o promenama u vezi sa ispitima (promena datuma, otkazivanje ispita).
### e) Pokretanje dodatne niti: Implementacija dodatne niti koja redovno ažurira ponude putovanja na osnovu promena dostupnosti i specijalnih ponuda.

# Tehnički zahtevi:
### a) Backend: Razvoj backend aplikacije sa Spring Boot 3.0 i JDK 17.
### b) Baza podataka: Korišćenje MySQL-a za skladištenje podataka.
### c) Logovanje: Implementacija logovanja za praćenje aktivnosti korisnika i sistema.
### d) Multi-layer: Implementacija višeslojne arhitekture.
### e) JSON: Komunikacija između klijenta i servera koristeći JSON format.
### f) Testiranje: Testiranje API-ja pomoću Postman-a.

# Struktura podataka:
### a) Turistički Paket: ID paketa, destinacija, opis, datum putovanja, cena, status dostupnosti.
### b) Rezervacija: ID rezervacije, ID klijenta, ID turističkog paketa, datum rezervacije, status rezervacije.
### c) Klijent: Ime, prezime, kontakt informacije, istorija rezervacija.
### d) Specijalna Ponuda: Informacije o trenutnim specijalnim ponudama ili popustima (naknadno se nakon pokretanja programa ručno inicira neka specijalna ponuda).
### e) Ostale klase i interfejsi: Projekat sadrži više klasa razvrstanih duhu višeslojne arhitekture (Controller, Component, Service, Repository, DAO, Logger, … u zavisnosti od realizacije vašeg projekta)
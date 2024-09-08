# Klijent

###### findAll

`get:`: localhost:8080/api/klijenti

###### findById

`get:` localhost:8080/api/klijent/{id}

###### save
`post:` localhost:8080/api/klijent
<br/>
`body request:`

````
{
    "ime": "Pera",
    "prezime": "Peric",
    "kontaktInformacije": "informacije"
}
````

<p>Ps: istorija rezervacije se ne dodaje. Jer program ga sam obradi kad se poveze sa rezervacijom.</p>

<br/>

###### update

`put:`localhost:8080/api/klijent

`body request`

````
{
    "id": 1,
    "ime": "Petar",
    "prezime": "Peric",
    "kontaktInformacije": "informacije",
    "istorijaRezervacije": "istorija"
}
````

<p>Ps: Ukoliko se id ne doda u body request onda se doda novi red u bazi.</p>

###### delete

`delete:`localhost:8080/api/klijent/{id}

# Turisticki paket

###### findAll

`get:`: localhost:8080/api/turisticki-paketi

###### findById

`get:` localhost:8080/api/turisticki-paket/{id}

###### save

`post:` localhost:8080/api/turisticki-paket
<br/>
`body request:`

````
{
    "destinacija": "Andaluzija",
    "opis": "Андалузија (шп. Andalucía) је најјужнија континенална аутономна заједница Краљевине Шпаније. Најпопуларнија је и друга по величини аутономна заједница у Шпанији.аутономна заједница Андалузија је званично призната као једна од шпанских националности. Територија је подељена на осам покрајина: Алмерија, Кадиз, Кордоба, Гранада, Уелва, Хаен, Малага и Севиља. Главни град покрајине је Севиља.",
    "cena": "110.99",
    "statusDostupnosti": true
}
````

###### update
`put:` localhost:8080/api/turisticki-paket
<br/>
````
{
    "id": 1,
    "destinacija": "Andaluzija",
    "opis": "Андалузија (шп. Andalucía) је најјужнија континенална аутономна заједница Краљевине Шпаније. Најпопуларнија је и друга по величини аутономна заједница у Шпанији.аутономна заједница Андалузија је званично призната као једна од шпанских националности. Територија је подељена на осам покрајина: Алмерија, Кадиз, Кордоба, Гранада, Уелва, Хаен, Малага и Севиља. Главни град покрајине је Севиља.",
    "cena": "300",
    "statusDostupnosti": false
}
````

###### delete
`delete:`localhost:8080/api/turisticki-paket/{id}

# Rezervacija

###### findAll
`get:` localhost:8080/api/rezervacije/sorted/destinacija-asc

###### findById
`get:` localhost:8080/api/rezervacija/{id}

###### findSorted
`get:` localhost:8080/api/rezervacije/sorted/{sortBy}
<p>sortBy = { <br>
            cena-asc, <br>
            cena-desc, <br>
            destinacija-asc, <br>
            destinacija-desc, <br>
            datum-asc, <br>
            datum-desc <br>
}</p>

###### save
`post:` localhost:8080/api/rezervacija
<br/>
`body request:`

````
{
    
}
````

<p>Ps: Ukoliko se ne doda klijent i turisticki paket onda moze da se napravi samo prazan objekat. 
Jer status rezervacije je false, a datum rezervacije program sam definise kad se doda klijent</p>

`Sa paketom, bez klijenta:`
````
{
    "turistickiPaket": {
        "destinacija": "Andaluzija",
        "opis": "Андалузија (шп. Andalucía) је најјужнија континенална аутономна заједница Краљевине Шпаније. Најпопуларнија је и друга по величини аутономна заједница у Шпанији.аутономна заједница Андалузија је званично призната као једна од шпанских националности. Територија је подељена на осам покрајина: Алмерија, Кадиз, Кордоба, Гранада, Уелва, Хаен, Малага и Севиља. Главни град покрајине је Севиља.",
        "cena": "110.99",
        "statusDostupnosti": true
    }
}
````

`Sa klijentom, bez paketa:`
````
{
    "klijent":{
        "ime": "Pera",
        "prezime": "Peric",
        "kontaktInformacije": "informacije"
    }   
}
````

<p>Ps: preporucljivo je da se ne salje ovakav zahtev (sa klijentom, bez paketa).
Jer se onda ne inicijalizuje datum rezervacije kod rezervacije i istorija rezervacije kod klijenta
(sto bi trebao program sam da odradi).</p>

`Sa klijentom i sa paketom:`
````
{
    "klijent":{
        "ime": "Pera",
        "prezime": "Peric",
        "kontaktInformacije": "informacije"
       },
     "turistickiPaket": {
        "destinacija": "Andaluzija",
        "opis": "Андалузија (шп. Andalucía) је најјужнија континенална аутономна заједница Краљевине Шпаније. Најпопуларнија је и друга по величини аутономна заједница у Шпанији.аутономна заједница Андалузија је званично призната као једна од шпанских националности. Територија је подељена на осам покрајина: Алмерија, Кадиз, Кордоба, Гранада, Уелва, Хаен, Малага и Севиља. Главни град покрајине је Севиља.",
        "cena": "110.99",
        "statusDostupnosti": true
    }  
}
````
<p>Ps: preporucljivo je da se ne salje ovakav zahtev (Sa klijentom i sa paketom).
Jer se onda ne inicijalizuju datum rezervacije kod rezervacije i istorija rezervacije kod klijenta
(sto bi trebao program sam da odradi).</p>


package com.asss.pj.TuristickaAgencija.repo;

import com.asss.pj.TuristickaAgencija.entity.Rezervacija;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RezervacijaRepo extends JpaRepository<Rezervacija, Integer> {

    List<Rezervacija> findAllSortedBy(Sort sort);

}

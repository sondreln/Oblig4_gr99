package no.hvl.dat108.Oblig4_gr99.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import no.hvl.dat108.Oblig4_gr99.entities.Deltager;
import no.hvl.dat108.Oblig4_gr99.repositories.DeltagerRepository;

public class DeltagerService {
    
    @Autowired
    private DeltagerRepository deltagerRepository;

    public void saveDeltager(Deltager deltager){
        deltagerRepository.save(deltager);
    }

    public List<Deltager> finnAlleDeltagere(){
        return deltagerRepository.findAll();
    }

}

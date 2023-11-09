package no.hvl.dat108.Oblig4_gr99.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat108.Oblig4_gr99.entities.Deltager;
import no.hvl.dat108.Oblig4_gr99.entities.Passord;
import no.hvl.dat108.Oblig4_gr99.repositories.DeltagerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeltagerService {

    private final DeltagerRepository deltagerRepository;
    private final PassordService passordService;

    @Autowired
    public DeltagerService(DeltagerRepository deltagerRepository, PassordService passordService) {
        this.deltagerRepository = deltagerRepository;
        this.passordService = passordService;
    }

    public Deltager registrerDeltager(String mobil, String passordKlartekst, String fornavn, String etternavn, String kjonn) {
        if (!deltagerRepository.existsById(mobil)) {
            String salt = passordService.genererTilfeldigSalt();
            String hash = passordService.hashMedSalt(passordKlartekst, salt);
    
            Passord passordObjekt = new Passord(hash, salt);
            Deltager deltager = new Deltager();
            deltager.setMobil(mobil);
            deltager.setPassord(passordObjekt); 
            deltager.setFornavn(fornavn);
            deltager.setEtternavn(etternavn);
            deltager.setKjonn(kjonn);
    
            return deltagerRepository.save(deltager);
        } else {
            return null;
        }
    }

    public boolean sjekkPassord(String mobil, String passord) {
        Optional<Deltager> deltager = deltagerRepository.findById(mobil);

        if (deltager.isPresent()) {
            return passordService.erKorrektPassord(passord, deltager.get().getPassord().getSalt(), deltager.get().getPassord().getHash());
        }

        return false;
    }

    public Optional<Deltager>  findByMobil(String mobil){
        Optional<Deltager> deltager = deltagerRepository.findById(mobil);

        return (Optional<Deltager>) deltager;
    }

    public List<Deltager> hentAlleDeltagere() {
        return deltagerRepository.findAllByOrderByFornavnAscEtternavnAsc();
    }

}

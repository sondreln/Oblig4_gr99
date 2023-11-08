package no.hvl.dat108.Oblig4_gr99.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat108.Oblig4_gr99.entities.Deltager;

public interface DeltagerRepository extends JpaRepository<Deltager, Long>{
    List<Deltager> findDeltagerByFirstName(String fornavn);
} 

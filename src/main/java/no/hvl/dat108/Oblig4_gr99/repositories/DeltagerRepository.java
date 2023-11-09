package no.hvl.dat108.Oblig4_gr99.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.hvl.dat108.Oblig4_gr99.entities.Deltager;

import java.util.List;

@Repository
public interface DeltagerRepository extends JpaRepository<Deltager, String> {
    List<Deltager> findAllByOrderByFornavnAscEtternavnAsc();
}


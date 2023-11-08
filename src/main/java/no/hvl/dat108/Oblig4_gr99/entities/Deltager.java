package no.hvl.dat108.Oblig4_gr99.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import no.hvl.dat108.Oblig4_gr99.handlers.Kjonn;

@Entity
public class Deltager {
    
    @Column(name = "fornavn")
    public String fornavn;

    @Column(name = "etternavn")
    public String etternavn;

    @Column(name = "kjonn")
    public Kjonn kjonn;

    @Column(name = "salt")
    public String salt;

    @Column(name = "hash")
    public String hash;

}

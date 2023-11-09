package no.hvl.dat108.Oblig4_gr99.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "deltager")
public class Deltager {

    @Column(name = "mobil", nullable = false, length = 8)
    @Id private String mobil;

    @Embedded
    private Passord passord;
    
    @Column(name = "fornavn")
    private String fornavn;

    @Column(name = "etternavn")
    private String etternavn;

    @Column(name = "kjonn")
    private String kjonn;


    public Deltager() {
    
    }

    public Deltager(String mobil, String fornavn, String etternavn, Passord passord, String kjonn){
        this.mobil = mobil;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.passord = passord;
        this.kjonn = kjonn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getMobil() {
        return mobil;
    }

    public Passord getPassord(){
        return passord;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setPassord(Passord passord){
        this.passord = passord;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

}


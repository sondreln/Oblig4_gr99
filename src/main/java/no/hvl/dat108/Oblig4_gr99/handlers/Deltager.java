package no.hvl.dat108.Oblig4_gr99.handlers;

public class Deltager {
    private String fornavn; 
    private String etternavn;
    private int mobil;
    private Kjonn kjonn;

    public String getFornavn(){
        return fornavn;
    }

    public void setFornavn(String fornavn){
        this.fornavn = fornavn; 
    }

    public String getEtternavn(){
        return etternavn;
    }

    public void setEtternavn(String etternavn){
        this.etternavn = etternavn;
    }

    public int getMobil(){
        return mobil;
    }

    public void setMobil(int mobil){
        this.mobil = mobil;
    }

    public Kjonn getKjonn(){
        return kjonn; 
    }

    public void setKjonn(Kjonn kjonn){
        this.kjonn = kjonn;
    }

    @Override
    public String toString(){
        return fornavn + etternavn + mobil + kjonn;
    }
}

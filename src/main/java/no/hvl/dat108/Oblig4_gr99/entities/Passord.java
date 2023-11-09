package no.hvl.dat108.Oblig4_gr99.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Passord {

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false)
    private String salt;

    protected Passord() {
    }

    public Passord(String hash, String salt) {
        this.hash = hash;
        this.salt = salt;
    }


    public String getHash(){
        return hash;
    }

    public String getSalt(){
        return salt;
    }

    public void setHash(String hash){
        this.hash = hash;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }
}

package no.hvl.dat108.Oblig4_gr99;

public class InputValidator {

    public String validerKjonn(String kjonn){
        return kjonn;
    }
    public static boolean erMann(String kjonn){
        return kjonn.equals("mann");
    }
    public static boolean erKvinne(String kjonn){
        return kjonn.equals("kvinne");
    }
    public static boolean validerMobilnummer(String mobilnummer){
        return mobilnummer.matches("[0-9]{8}");
    }
    public static boolean validerFornavn(String fornavn){
        return fornavn.matches("[a-zA-ZæøåÆØÅ\\-]{2,20}");
    }
    public static boolean validerEtternavn(String etternavn){
        return etternavn.matches("[a-zA-ZæøåÆØÅ\\-]{2,20}");
    }
}

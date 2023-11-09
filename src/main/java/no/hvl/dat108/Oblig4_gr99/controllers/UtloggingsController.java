package no.hvl.dat108.Oblig4_gr99.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class UtloggingsController {

    @RequestMapping("utlogging")
    public String utlogging() {
        return "innlogging_med_melding";
    }

    
}

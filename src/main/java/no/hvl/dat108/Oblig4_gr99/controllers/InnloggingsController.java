package no.hvl.dat108.Oblig4_gr99.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class InnloggingsController {
    
    @RequestMapping("innlogging")
    public String innlogging() {
        return "deltagerliste";
    }

}

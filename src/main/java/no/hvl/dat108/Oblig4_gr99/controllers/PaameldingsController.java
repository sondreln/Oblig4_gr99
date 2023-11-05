package no.hvl.dat108.Oblig4_gr99.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaameldingsController {
    
    @RequestMapping("/paamelding")
    public String index() {
        return "paamelding_med_melding";
    }


}

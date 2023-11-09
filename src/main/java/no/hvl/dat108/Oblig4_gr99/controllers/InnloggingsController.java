package no.hvl.dat108.Oblig4_gr99.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Oblig4_gr99.entities.Deltager;
import no.hvl.dat108.Oblig4_gr99.service.DeltagerService;

public class InnloggingsController {
    @Autowired
    private DeltagerService deltagerService;

    @RequestMapping("innlogging")
    public String innlogging(
        @RequestParam String mobil, 
        @RequestParam String passord, 
        HttpSession session,
        Model model) {

        Optional<Deltager> erDeltager = deltagerService.findByMobil(mobil);

        if (erDeltager.isEmpty()){
            return null;
        }

        if (erDeltager.isPresent()){
            return "deltagerliste";
        }else {

            model.addAttribute("errorMessage", "Feil ved innlogging");
            return "innlogging_med_melding";
        }
    }

}

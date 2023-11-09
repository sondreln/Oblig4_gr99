package no.hvl.dat108.Oblig4_gr99.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Oblig4_gr99.entities.Deltager;
import no.hvl.dat108.Oblig4_gr99.service.DeltagerService;

@Controller
public class InnloggingsController {
    
    @Autowired
    private DeltagerService deltagerService;

    @RequestMapping("/innlogging")
    public String innlogging(
        @RequestParam(required = false) String mobil, 
        @RequestParam(required = false) String passord, 
        HttpSession session,
        Model model) {

        if (mobil != null && !mobil.isEmpty() && passord != null && !passord.isEmpty()) {
            Optional<Deltager> erDeltager = deltagerService.findByMobil(mobil);
            
            if (erDeltager.isPresent()) {
                Optional<Deltager> deltager = erDeltager;
                boolean passordMatch = deltagerService.sjekkPassord(mobil, passord);

                if (passordMatch) {
                    session.setAttribute("registrertDeltager", deltager);
                    return "redirect:/deltagerliste"; 
                } else {
                    model.addAttribute("errorMessage", "Feil passord.");
                    return "innlogging_med_melding";
                }

            } else {
                model.addAttribute("errorMessage", "Ingen deltager funnet med det mobilnummeret.");
                return "innlogging_med_melding";
            }

        } else {
            model.addAttribute("errorMessage", "Vennligst skriv inn mobil og passord.");
            return "innlogging_med_melding";
        }
    }
}


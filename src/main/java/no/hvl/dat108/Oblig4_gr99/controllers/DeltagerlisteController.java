package no.hvl.dat108.Oblig4_gr99.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Oblig4_gr99.entities.Deltager;
import no.hvl.dat108.Oblig4_gr99.service.DeltagerService;

import java.util.List;

@Controller
public class DeltagerlisteController {

    @Autowired
    private DeltagerService deltagerService;

    @RequestMapping("/deltagerliste")
    public String deltagerliste(HttpSession session, Model model) {
        Deltager registrertDeltager = (Deltager) session.getAttribute("deltager");

        if (registrertDeltager != null) {
            model.addAttribute("deltager", registrertDeltager); 
        }

        List<Deltager> alleDeltagere = deltagerService.hentAlleDeltagere(); 
        model.addAttribute("alleDeltagere", alleDeltagere); 
        model.addAttribute("deltager", registrertDeltager);


        return "deltagerliste"; 
    }

    @PostMapping("innlogging")
    public String utlogging(HttpSession session, Model model){
        session.removeAttribute("deltager");


        return "innlogging_med_melding";
    }
}
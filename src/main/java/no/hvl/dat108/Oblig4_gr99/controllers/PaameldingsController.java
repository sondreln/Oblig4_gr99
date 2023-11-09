package no.hvl.dat108.Oblig4_gr99.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Oblig4_gr99.entities.Deltager;
import no.hvl.dat108.Oblig4_gr99.service.DeltagerService;

@Controller
public class PaameldingsController {

    private final DeltagerService deltagerService;

    @Autowired
    public PaameldingsController(DeltagerService deltagerService) {
        this.deltagerService = deltagerService;
    }

    @RequestMapping("/paamelding")
    public String visPaamelding(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paamelding_med_melding";
    }


    @PostMapping("/paameldt")
    public String handleForm(@RequestParam String fornavn,
            @RequestParam String etternavn,
            @RequestParam String mobil,
            @RequestParam String passord,
            @RequestParam String passordRepetert,
            @RequestParam String kjonn,
            HttpSession session,
            Model model) {
        if (!passord.equals(passordRepetert)) {
            model.addAttribute("errorMessage", "Passordene er ikke like.");
            return "paamelding_med_melding";
        }

        Deltager registrert = deltagerService.registrerDeltager(
                mobil,
                passord,
                fornavn,
                etternavn,
                kjonn);

        if (registrert != null) {
            model.addAttribute("deltager", registrert);
            session.setAttribute("deltager", registrert);
            return "paameldt";
        } else {
            model.addAttribute("errorMessage", "En bruker med dette mobilnummeret er allerede registrert.");
            return "paamelding_med_melding";
        }
    }

}

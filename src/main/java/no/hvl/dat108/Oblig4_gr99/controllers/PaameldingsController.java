package no.hvl.dat108.Oblig4_gr99.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Oblig4_gr99.handlers.Deltager;

@Controller
public class PaameldingsController {

    @RequestMapping("/paamelding")
    public String index(Model model) {
        model.addAttribute("deltager", new Deltager());
        return "paamelding_med_melding";
    }

    @RequestMapping("innlogging")
    public String innlogging() {
        return "innlogging_med_melding";
    } 

    @RequestMapping("paameldt")
    public String paameldt() {
        return "paameldt";
    }

    @RequestMapping("deltagerliste")
    public String deltagerliste(HttpSession session, Model model){
        Deltager registrertDeltager = (Deltager) session.getAttribute("registrertDeltager");

        if(registrertDeltager != null){
            model.addAttribute("deltager", registrertDeltager);
        }

        return "deltagerliste";
    }

    @RequestMapping("utlogging")
    public String utlogging(){
        return this.innlogging();
    }

    @PostMapping("/submit")
    public String handleForm(
            @RequestParam String fornavn,
            @RequestParam String etternavn,
            @RequestParam String mobil,
            @RequestParam String passord,
            @RequestParam String passordRepetert,
            @RequestParam String kjonn,
            @ModelAttribute Deltager deltager,
            Model model,
            HttpSession session) {

        if (fornavn.isEmpty() || etternavn.isEmpty() || mobil.isEmpty() ||
                passord.isEmpty() || !passord.equals(passordRepetert)) {
            model.addAttribute("errorMessage", "Validation failed. Please check the fields.");
            return "paamelding_med_melding"; 
        }

        
        model.addAttribute("deltager", deltager);
        session.setAttribute("registrertDeltager", deltager);

        return "paameldt"; 
    }

}

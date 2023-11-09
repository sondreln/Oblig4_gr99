package no.hvl.dat108.Oblig4_gr99.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Oblig4_gr99.entities.Deltager;

@Controller 
public class PaameldtController {
    
    @RequestMapping("/paameldt")
    public String paameldt(HttpSession session, Model model) {
        Deltager deltager = (Deltager) session.getAttribute("deltager");

        if (deltager == null) {
            return "redirect:/paamelding";
        }

        model.addAttribute("deltager", deltager);
        return "paameldt";
    }
}

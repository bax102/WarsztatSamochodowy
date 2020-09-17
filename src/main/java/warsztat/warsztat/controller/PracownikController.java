package warsztat.warsztat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import warsztat.warsztat.model.Pracownik;
import warsztat.warsztat.service.PracownikService;

import java.util.Optional;


@Controller
@RequestMapping(path = "/pracownik")
public class PracownikController {

    @Autowired
    private PracownikService pracownikService;

    @GetMapping ("/add")
    public String dodaniePracownika (Model model){

        model.addAttribute("newPracownik", new Pracownik());

        return "pracownik-form";
    }

    @PostMapping("/add")
    public String dodaniePracownika (Pracownik pracownik){
        pracownikService.add(pracownik);

        return "redirect:/pracownik/list";

    }

    @GetMapping("/list")
    public String listaPracownikow (Model model){
        model.addAttribute("listaPracownikow", pracownikService.getBazaDanych());

        return "pracownik-list";
    }

    @GetMapping(path="/details")
    public String detalePracownka (Model model, @RequestParam Long pracownikIdentifer) {
        Optional<Pracownik> optionalPracownik = pracownikService.findPracownik(pracownikIdentifer);

        if (optionalPracownik.isPresent()){

            Pracownik pracownik = optionalPracownik.get();
            model.addAttribute("pracownikDetails", pracownik);

            return "pracownik-details";
        }
        return "redirect:/pracownik/list";
    }

    @GetMapping(path="/delete/{pracownikIdentifier}")
    public String deletePracownik (@PathVariable Long pracownikIdentifier){
        pracownikService.deleteById(pracownikIdentifier);

        return ("redirect:/pracownik/list");
    }

    @GetMapping("/edit/{pracownik_id}")
    public String editPracownik (Model model, @PathVariable(name="pracownik_id") Long pracownikId){

        return getPracownikToEdit(model, pracownikId);
    }

    @GetMapping("/edit")
    public String editPracownikParam(Model model, @RequestParam(name="pracownik_id") Long pracownikId){

        return getPracownikToEdit(model,pracownikId);
    }

    private String getPracownikToEdit (Model model, @RequestParam(name="pracownik_id") Long pracownikId){
        Optional<Pracownik> optionalPracownik = pracownikService.findPracownik(pracownikId);
        if (optionalPracownik.isPresent()){
            Pracownik pracownik = optionalPracownik.get();
            model.addAttribute("newPracownik",pracownik);

            return "pracownik-form";
        }
        return "redirect:/pracownik/list";
    }


}

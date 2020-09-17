package warsztat.warsztat.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import warsztat.warsztat.model.Funkcja;
import warsztat.warsztat.model.Wyplata;
import warsztat.warsztat.service.WyplataService;

import java.util.Optional;

@Controller
@RequestMapping ("/wyplata")
@AllArgsConstructor
public class WyplataController {

    private final WyplataService wyplataService;

    @GetMapping ("/add")
    public String addWyplataForm(Model model, @RequestParam("pracownik_id") Long pracownikId){

        model.addAttribute("newWyplata", new Wyplata());
        model.addAttribute("pracownikId", pracownikId);
        model.addAttribute("funkcja", Funkcja.values());

        return "wyplata-form";
    }

    @PostMapping("/add")
    public String wyplataSave(Wyplata wyplata, Long wyplacone){

        wyplataService.saveWyplata(wyplata, wyplacone);

        return "redirect:/pracownik/details?pracownikIdentifer=" + wyplacone;
    }

    @GetMapping("/edit")
    public String editWyplata(Model model, @RequestParam(name = "wyplataId") Long wyplataId){

        Optional<Wyplata> wyplataOptional = wyplataService.findById(wyplataId);
        if (wyplataOptional.isPresent()){

            Wyplata wyplata = wyplataOptional.get();
            model.addAttribute("newWyplata", wyplata);
            model.addAttribute("pracownikId", wyplata.getPracownik().getId());
            model.addAttribute("funkcja", Funkcja.values());

            return "wyplata-form";
        }
        return "redirect:/pracownik/list";
    }

}

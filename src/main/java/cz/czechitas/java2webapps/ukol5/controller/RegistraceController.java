package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
@RequestMapping("/")
public class RegistraceController {

  private final Random random = new Random();

  @GetMapping("/")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("/formular");
    modelAndView.addObject("form", new RegistraceForm());
    return modelAndView;
  }

  @PostMapping
  public Object form(@ModelAttribute("form") @Valid RegistraceForm form, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "/formular";
    }

    Period period = form.getDatumNarozeni().until(LocalDate.now());
    int vek = period.getYears();

      if (vek < 9 || vek > 15) {
        bindingResult.rejectValue("datumNarozeni", "", "Tábor je určrn pro děti od 9 do 15 let včetně.");
        return "formular";
      }
      if (form.getSport().size() <= 1) {
        bindingResult.rejectValue("sport", "", "Pro úspěšnou registraci je potřeba vybrat alespoň dva sporty.");
        return "formular";
      }

    return new ModelAndView("/registrovano")
            .addObject("kod", Math.abs(random.nextInt()))
            .addObject("email", form.getEmail())
            .addObject("turnus", form.getTurnus());
  }

}

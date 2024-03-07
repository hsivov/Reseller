package com.example.reseller.controller;

import com.example.reseller.model.dto.offer.OfferHomeDTO;
import com.example.reseller.service.OfferService;
import com.example.reseller.service.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final OfferService offerService;
    private final LoggedUser loggedUser;

    public HomeController(OfferService offerService, LoggedUser loggedUser) {
        this.offerService = offerService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index() {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("home");
        OfferHomeDTO offersForHomePage = offerService.getOffersForHomePage();

        modelAndView.addObject("offerHomeDTO", offersForHomePage);

        return modelAndView;
    }
}

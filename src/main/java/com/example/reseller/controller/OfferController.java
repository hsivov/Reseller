package com.example.reseller.controller;

import com.example.reseller.model.dto.offer.OfferCreateBindingModel;
import com.example.reseller.service.OfferService;
import com.example.reseller.service.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final LoggedUser loggedUser;

    public OfferController(OfferService offerService, LoggedUser loggedUser) {
        this.offerService = offerService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/offer/add")
    public ModelAndView add(@ModelAttribute("offerCreateBindingModel") OfferCreateBindingModel offerCreateBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("offer-add");
    }

    @PostMapping("/offer/add")
    public ModelAndView add(
            @ModelAttribute("offerCreateBindingModel") @Valid OfferCreateBindingModel offerCreateBindingModel,
            BindingResult bindingResult) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("offer-add");
        }

        boolean isCreated = offerService.create(offerCreateBindingModel);

        if (!isCreated) {
            ModelAndView modelAndView = new ModelAndView("offer-add");
            modelAndView.addObject("offerAddError", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("offer/buy/{id}")
    public ModelAndView buy(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        offerService.buy(id);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("offer/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        offerService.remove(id);

        return new ModelAndView("redirect:/home");
    }
}

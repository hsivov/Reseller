package com.example.reseller.service;

import com.example.reseller.model.dto.offer.OfferCreateBindingModel;
import com.example.reseller.model.dto.offer.OfferHomeDTO;

public interface OfferService {

    boolean create(OfferCreateBindingModel offerCreateBindingModel);

    OfferHomeDTO getOffersForHomePage();

    void buy(Long id);

    void remove(Long id);
}

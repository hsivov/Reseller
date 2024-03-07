package com.example.reseller.service.impl;

import com.example.reseller.model.dto.offer.*;
import com.example.reseller.model.entity.Condition;
import com.example.reseller.model.entity.Offer;
import com.example.reseller.model.entity.User;
import com.example.reseller.repository.ConditionRepository;
import com.example.reseller.repository.OfferRepository;
import com.example.reseller.repository.UserRepository;
import com.example.reseller.service.OfferService;
import com.example.reseller.service.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public OfferServiceImpl(OfferRepository offerRepository, ConditionRepository conditionRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean create(OfferCreateBindingModel offerCreateBindingModel) {
        Condition condition = conditionRepository.findByConditionName(offerCreateBindingModel.getCondition());
        User user = userRepository.findByUsername(loggedUser.getUsername());

        if (condition != null && user != null) {
            Offer offer = new Offer();
            offer.setDescription(offerCreateBindingModel.getDescription());
            offer.setPrice(offerCreateBindingModel.getPrice());
            offer.setCondition(condition);
            offer.setCreatedBy(user);

            offerRepository.save(offer);

            return true;
        }
        return false;
    }

    @Override
    public OfferHomeDTO getOffersForHomePage() {
        List<Offer> offers = offerRepository.findAll();

        List<MyOffersDTO> myOffers = new ArrayList<>();
        List<BoughtOffersDTO> boughtOffers = new ArrayList<>();
        List<OtherOffersDTO> otherOffers = new ArrayList<>();

        for (Offer offer : offers) {
            String loggedUsername = loggedUser.getUsername();

            if (offer.getBoughtBy() == null && offer.getCreatedBy().getUsername().equals(loggedUsername)) {
                myOffers.add(new MyOffersDTO(offer));
            } else if (offer.getBoughtBy() != null && offer.getBoughtBy().getUsername().equals(loggedUsername)) {
                boughtOffers.add(new BoughtOffersDTO(offer));
            } else if (offer.getBoughtBy() == null) {
                otherOffers.add(new OtherOffersDTO(offer));
            }
        }

        return new OfferHomeDTO(myOffers, boughtOffers, otherOffers);
    }

    @Override
    public void buy(Long id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);

        if (optionalOffer.isPresent()) {
            User user = userRepository.findByUsername(loggedUser.getUsername());
            Offer offer = optionalOffer.get();

            offer.setBoughtBy(user);

            offerRepository.save(offer);
        }
    }

    @Override
    public void remove(Long id) {
        offerRepository.deleteById(id);
    }
}

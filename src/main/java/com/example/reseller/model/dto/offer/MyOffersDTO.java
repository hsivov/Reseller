package com.example.reseller.model.dto.offer;

import com.example.reseller.model.entity.ConditionName;
import com.example.reseller.model.entity.Offer;

import java.util.UUID;

public class MyOffersDTO extends BoughtOffersDTO{
    private Long id;
    ConditionName condition;

    public MyOffersDTO() {
    }

    public MyOffersDTO(Offer offer) {
        super(offer);
        id = offer.getId();
        condition = offer.getCondition().getConditionName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConditionName getCondition() {
        return condition;
    }

    public void setCondition(ConditionName condition) {
        this.condition = condition;
    }
}

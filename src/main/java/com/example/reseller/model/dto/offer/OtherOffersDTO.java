package com.example.reseller.model.dto.offer;

import com.example.reseller.model.entity.Offer;

public class OtherOffersDTO extends MyOffersDTO{
    private String sellerUsername;

    public OtherOffersDTO() {
    }

    public OtherOffersDTO(Offer offer) {
        super(offer);
        sellerUsername = offer.getCreatedBy().getUsername();
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }
}

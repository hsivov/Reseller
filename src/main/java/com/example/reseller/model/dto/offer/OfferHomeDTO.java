package com.example.reseller.model.dto.offer;

import java.util.List;

public class OfferHomeDTO {
    private List<MyOffersDTO> myOffers;
    private List<BoughtOffersDTO> boughtOffers;
    private List<OtherOffersDTO> otherOffers;
    private long totalOtherOffers;

    public OfferHomeDTO(List<MyOffersDTO> myOffers, List<BoughtOffersDTO> boughtOffers, List<OtherOffersDTO> otherOffers) {
        this.myOffers = myOffers;
        this.boughtOffers = boughtOffers;
        this.otherOffers = otherOffers;
        this.totalOtherOffers = otherOffers.size();
    }

    public List<MyOffersDTO> getMyOffers() {
        return myOffers;
    }

    public void setMyOffers(List<MyOffersDTO> myOffers) {
        this.myOffers = myOffers;
    }

    public List<BoughtOffersDTO> getBoughtOffers() {
        return boughtOffers;
    }

    public void setBoughtOffers(List<BoughtOffersDTO> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }

    public List<OtherOffersDTO> getOtherOffers() {
        return otherOffers;
    }

    public void setOtherOffers(List<OtherOffersDTO> otherOffers) {
        this.otherOffers = otherOffers;
    }

    public long getTotalOtherOffers() {
        return totalOtherOffers;
    }

    public void setTotalOtherOffers(long totalOtherOffers) {
        this.totalOtherOffers = totalOtherOffers;
    }
}

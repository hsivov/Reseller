package com.example.reseller.model.dto.offer;

import com.example.reseller.model.entity.ConditionName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class OfferCreateBindingModel {

    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;
    @Positive(message = "Price must be positive number!")
    @NotNull(message = "Price cannot be empty!")
    private BigDecimal price;
    @NotNull(message = "You must select a condition!")
    private ConditionName condition;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ConditionName getCondition() {
        return condition;
    }

    public void setCondition(ConditionName condition) {
        this.condition = condition;
    }
}

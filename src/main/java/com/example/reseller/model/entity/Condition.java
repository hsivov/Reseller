package com.example.reseller.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ConditionName conditionName;

    @Column(nullable = false)
    private String description;

    public ConditionName getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionName conditionName) {
        this.conditionName = conditionName;
        this.setDescription(conditionName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(ConditionName name) {
        String description = "";

        switch (name) {
            case EXCELLENT -> description = "In perfect condition";
            case GOOD -> description = "Some signs of wear and tear or minor defects";
            case ACCEPTABLE -> description = "The item is fairly worn but continues to function properly";
        }

        this.description = description;
    }
}

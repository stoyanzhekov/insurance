package com.insurance.entity;

import java.math.BigDecimal;

/**
 * Created by Stoyan on 2/19/2017.
 */
public enum InsurancePolicyType {

    BIKE("Bike", new BigDecimal("0.30")),
    JEWELERY("Jewelry", new BigDecimal("0.5")),
    ELECTRONICS("Electronics", new BigDecimal("0.35")),
    SPORT_EQUIPMENT("Sports_Equipment", new BigDecimal("0.30"));

    private String type;
    private BigDecimal risk;

    InsurancePolicyType(String type, BigDecimal risk){
        this.risk = risk;
        this.type = type;
    }

    public String getInsuranceType(){
        return type;
    }

    public BigDecimal getRisk(){
        return risk;
    }
}

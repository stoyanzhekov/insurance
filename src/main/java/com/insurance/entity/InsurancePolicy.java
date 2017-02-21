package com.insurance.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Stoyan on 2/19/2017.
 */
public class InsurancePolicy implements Serializable{

    private InsurancePolicyType type;
    private User user;
    private BigDecimal tariff;
    private BigDecimal coverage;

    public InsurancePolicy(){}

    public InsurancePolicy(InsurancePolicyType type, User user, BigDecimal tariff, BigDecimal coverage) {
        this.type = type;
        this.user = user;
        this.tariff = tariff;
        this.coverage = coverage;
    }

    public InsurancePolicyType getType() {
        return type;
    }

    public void setType(InsurancePolicyType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTariff() {
        return tariff;
    }

    public void setTariff(BigDecimal tariff) {
        this.tariff = tariff;
    }

    public BigDecimal getCoverage() {
        return coverage;
    }

    public void setCoverage(BigDecimal coverage) {
        this.coverage = coverage;
    }
}

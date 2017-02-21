package com.insurance.service.impl;

import com.insurance.service.CalculateTariff;

import javax.inject.Named;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Stoyan on 2/19/2017.
 */
@Named
public class CalculateTariffImpl implements CalculateTariff{

    @Override
    public BigDecimal calculateTariff(BigDecimal coverageAmount, BigDecimal risk) {
        return coverageAmount.multiply(risk).setScale(2, RoundingMode.CEILING);
    }
}

package com.insurance.service;

import java.math.BigDecimal;

/**
 * Created by Stoyan on 2/19/2017.
 */

public interface CalculateTariff {

    BigDecimal calculateTariff(BigDecimal coverageAmount, BigDecimal risk);
}

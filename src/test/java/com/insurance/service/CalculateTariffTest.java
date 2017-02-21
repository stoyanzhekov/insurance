package com.insurance.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.service.impl.CalculateTariffImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		CalculateTariffImpl.class
})
public class CalculateTariffTest {

	@Inject
	private CalculateTariffImpl calculateTariff;
	
	@Test
	public void calculateTariffTest(){
		BigDecimal coverageAmount = new BigDecimal("100");
		BigDecimal risk = new BigDecimal("0.25");
		
		BigDecimal result = calculateTariff.calculateTariff(coverageAmount, risk);
		
		assertEquals(new BigDecimal("25.00"), result);
		assertNotEquals(new BigDecimal("30.00"), result);
	}
}

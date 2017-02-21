package com.insurance.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.insurance.entity.InsurancePolicyType;
import com.insurance.utils.Util;

public class UtilTest {

	@Test
	public void getInsuranceTypeTest(){
		InsurancePolicyType bike= Util.getInsuranceType("Bike");
		InsurancePolicyType jewelry = Util.getInsuranceType("Jewelry");
		InsurancePolicyType el = Util.getInsuranceType("Electronics");
		InsurancePolicyType se = Util.getInsuranceType("Sports_Equipment");
		InsurancePolicyType none = Util.getInsuranceType("None");
		
		assertNotNull(bike);
		assertNotNull(jewelry);
		assertNotNull(el);
		assertNotNull(se);
		assertNull(none);
	}
}

package com.insurance.utils;

import com.insurance.entity.InsurancePolicy;
import com.insurance.entity.InsurancePolicyType;

/**
 * Created by Stoyan on 2/19/2017.
 */
public class Util {

    private Util(){}

    public static InsurancePolicyType getInsuranceType(String type){
        if(type == null) return null;
        switch (type){
            case "Bike":
                return InsurancePolicyType.BIKE;
            case "Jewelry":
            	return InsurancePolicyType.JEWELERY;
            case "Electronics":
            	return InsurancePolicyType.ELECTRONICS;
            case "Sports_Equipment":
            	return InsurancePolicyType.SPORT_EQUIPMENT;
            default:
            	return null;
        }
    }
}

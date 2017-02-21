package com.insurance.controller;

import com.insurance.dto.UserDto;
import com.insurance.entity.InsurancePolicy;
import com.insurance.entity.InsurancePolicyType;
import com.insurance.entity.User;
import com.insurance.exception.InsurancePolicyTypeException;
import com.insurance.service.CalculateTariff;
import com.insurance.service.UserService;
import com.insurance.utils.Util;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Stoyan on 2/19/2017.
 */
@RestController
public class CalculateTariffController {

    @Inject
    private CalculateTariff calculateTariff;

    @Inject
    private UserService userService;

    @RequestMapping(value = "/user/calculate-tariff", 
    		method = RequestMethod.POST,
    		produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {

        User user = null;
        if(!userService.isUserExist(userDto.getID())) {
            user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setAge(userDto.getAge());
            user.setID(userDto.getID());
            user.setInsurancePolicy(new ArrayList<InsurancePolicy>());
        } else {
            user = userService.getUser(userDto.getID());
        }

        InsurancePolicyType insurancePolicyType = Util.getInsuranceType(userDto.getPolicyType());
        if(insurancePolicyType == null) throw new InsurancePolicyTypeException();
        BigDecimal tariff = calculateTariff.calculateTariff(userDto.getCoverageAmount(), insurancePolicyType.getRisk());

        InsurancePolicy insurancePolicy = new InsurancePolicy();
        insurancePolicy.setCoverage(userDto.getCoverageAmount());
        insurancePolicy.setTariff(tariff);
        insurancePolicy.setType(insurancePolicyType);

        user.getInsurancePolicy().add(insurancePolicy);
        
        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}

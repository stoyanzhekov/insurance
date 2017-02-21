package com.insurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Stoyan on 2/19/2017.
 */

@Controller
public class InsuranceHomeController {

    @RequestMapping(name = "/insurance_home", method = RequestMethod.GET)
    public String insuranceHome(){
        return "insurance_home";
    }
}

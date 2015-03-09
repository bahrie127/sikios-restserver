package com.blung.sikios.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
@Controller
@RequestMapping(value = "/homes")
public class HomeController {
 


    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "home";
    }
}

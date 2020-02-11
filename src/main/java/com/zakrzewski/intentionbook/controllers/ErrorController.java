package com.zakrzewski.intentionbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorController{

    @RequestMapping(value = "/access-forbidden")
    public String forbiddenAccess(){
        return "access-denied";
    }
}

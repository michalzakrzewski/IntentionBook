package com.zakrzewski.intentionbook.controllers;

import com.zakrzewski.intentionbook.entities.SacristanModel;
import com.zakrzewski.intentionbook.services.SacristianServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SacristianController {

    private SacristianServiceImpl sacristianService;

    @Autowired
    public SacristianController(SacristianServiceImpl sacristianService) {
        this.sacristianService = sacristianService;
    }

    @RequestMapping(value = "/show-sacristian", method = RequestMethod.GET)
    public List<SacristanModel> getAllSacristian(){
        List<SacristanModel> sacristanModels = sacristianService.getAllSacristian();
        return sacristanModels;
    }
}

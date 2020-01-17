package com.zakrzewski.intentionbook.services;

import com.zakrzewski.intentionbook.entities.SacristanModel;
import com.zakrzewski.intentionbook.repositories.SacristianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SacristianServiceImpl {

    private SacristianRepository sacristianRepository;

    @Autowired
    public SacristianServiceImpl(SacristianRepository sacristianRepository) {
        this.sacristianRepository = sacristianRepository;
    }

    public List<SacristanModel> getAllSacristian(){
        return sacristianRepository.findAll();
    }
}

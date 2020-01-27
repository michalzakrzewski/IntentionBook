package com.zakrzewski.intentionbook.controllers;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.services.ChurchWorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChurchWorkerConctroller {

    private ChurchWorkerServiceImpl churchWorkerService;

    @Autowired
    public ChurchWorkerConctroller(ChurchWorkerServiceImpl churchWorkerService) {
        this.churchWorkerService = churchWorkerService;
    }

    @RequestMapping(value = "/show-all-church-worker", method = RequestMethod.GET)
    public List<ChurchWorker> showAllChurchWorkers(){
        return churchWorkerService.getAllChurchWorker();
    }

    @RequestMapping(value = "/show-sacristians", method = RequestMethod.GET)
    public List<ChurchWorker> showSacristians(){
        return churchWorkerService.getAllSacristian();
    }

    @RequestMapping(value = "/show-priests", method = RequestMethod.GET)
    public List<ChurchWorker> showPriests(){
        return churchWorkerService.getAllPriest();
    }

}

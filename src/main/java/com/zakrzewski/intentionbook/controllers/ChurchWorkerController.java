package com.zakrzewski.intentionbook.controllers;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.services.ChurchWorkerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChurchWorkerController {

    private ChurchWorkerServiceImpl churchWorkerService;

    private Logger logger = LoggerFactory.getLogger(ChurchWorkerController.class);

    @Autowired
    public ChurchWorkerController(ChurchWorkerServiceImpl churchWorkerService) {
        this.churchWorkerService = churchWorkerService;
    }

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(Model model){
        List<ChurchWorker> churchWorkersList = churchWorkerService.getAllChurchWorker();
        model.addAttribute("churchWorker", churchWorkersList);
        return "workers";
    }*/

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

    @RequestMapping(value = "/add-new-worker", method = RequestMethod.POST)
    public ChurchWorker addNewWorker(@RequestBody ChurchWorker churchWorker){
        return churchWorkerService.addNewChurchWorker(churchWorker);
    }

    @RequestMapping(value = "/delete-worker/{id}", method = RequestMethod.DELETE)
    public void deleteWorker(@PathVariable Long id){
        churchWorkerService.deleteChurchWorker(id);
    }

}
package com.zakrzewski.intentionbook.controllers;

import com.zakrzewski.intentionbook.entities.ChurchWorker;
import com.zakrzewski.intentionbook.enums.AccessEnum;
import com.zakrzewski.intentionbook.services.ChurchWorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChurchWorkerController {

    private ChurchWorkerService churchWorkerService;

    private Logger logger = LoggerFactory.getLogger(ChurchWorkerController.class);

    @Autowired
    public ChurchWorkerController(ChurchWorkerService churchWorkerService) {
        this.churchWorkerService = churchWorkerService;
    }


    @RequestMapping(value = "/show-all-workers", method = RequestMethod.GET)
    public String showAllChurchWorkers(Model model){
        List<ChurchWorker> churchWorkersList = churchWorkerService.getAllChurchWorker();
        model.addAttribute("churchWorker", churchWorkersList);
        return "show-all-workers";
    }

    @RequestMapping(value = "/show-sacristians", method = RequestMethod.GET)
    public List<ChurchWorker> showSacristians(){
        return churchWorkerService.getAllSacristian();
    }

    @RequestMapping(value = "/show-priests", method = RequestMethod.GET)
    public List<ChurchWorker> showPriests(){
        return churchWorkerService.getAllPriest();
    }

    @RequestMapping(value = "/create-new-worker-page")
    public String addNewWorkerPage(Model model){
        model.addAttribute("newWorker", new ChurchWorker());
        return "create-new-worker";
    }

    @RequestMapping(value = "/add-new-worker", method = RequestMethod.POST)
    public String addNewWorker(ChurchWorker churchWorker){
        churchWorkerService.addNewChurchWorker(churchWorker);
        return "redirect:/";
    }


    @RequestMapping(value = "/delete-worker/{id}", method = RequestMethod.DELETE)
    public void deleteWorker(@PathVariable Long id){
        churchWorkerService.deleteChurchWorker(id);
    }

}

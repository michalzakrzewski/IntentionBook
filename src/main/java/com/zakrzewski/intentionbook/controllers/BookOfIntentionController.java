package com.zakrzewski.intentionbook.controllers;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import com.zakrzewski.intentionbook.services.BookOfIntentionsServiceImpl;
import com.zakrzewski.intentionbook.services.ChurchWorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class BookOfIntentionController {

    private BookOfIntentionsServiceImpl bookOfIntentionsService;
    private ChurchWorkerServiceImpl churchWorkerDetailsService;

    @Autowired
    public BookOfIntentionController(BookOfIntentionsServiceImpl bookOfIntentionsService, ChurchWorkerServiceImpl churchWorkerDetailsService) {
        this.bookOfIntentionsService = bookOfIntentionsService;
        this.churchWorkerDetailsService = churchWorkerDetailsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllIntentions(Model model) {
        List<BookOfIntentionModel> bookOfIntentionModelList = bookOfIntentionsService.getAllIntentions();
        model.addAttribute("intention", bookOfIntentionModelList);
        return "index";
    }

    @RequestMapping(value = "/add-new-intention")
    public String addIntention(Model model) {
        model.addAttribute("newIntention", new BookOfIntentionModel());

        List<ChurchWorker> churchPriest = churchWorkerDetailsService.getAllPriest();
        model.addAttribute("whichPriest", churchPriest);

        List<ChurchWorker> allChurchWorkers = churchWorkerDetailsService.getAllChurchWorker();
        model.addAttribute("whoAddIntention", allChurchWorkers);

        LocalDate date = LocalDate.now();
        model.addAttribute("now", date);
        return "add-new-intention";
    }

    @RequestMapping(value = "/show-one-intention/{id}", method = RequestMethod.GET)
    public BookOfIntentionModel getOneIntention(@PathVariable Long id) {
        return bookOfIntentionsService.getOneIntentionById(id);
    }

    @RequestMapping(value = "/add-intention", method = RequestMethod.POST)
    public String addNewIntention(@ModelAttribute BookOfIntentionModel bookOfIntentionModel) {
        bookOfIntentionsService.addNewIntention(bookOfIntentionModel);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit-intention/{id}", method = RequestMethod.PUT)
    public void editIntention(@PathVariable Long id, @RequestBody BookOfIntentionModel bookOfIntentionModel) {
        bookOfIntentionsService.editIntention(id, bookOfIntentionModel);
    }

    @RequestMapping(value = "/delete-intention/{id}", method = RequestMethod.DELETE)
    public void deleteIntention(@PathVariable Long id) {
        bookOfIntentionsService.deleteIntentionById(id);
    }
}


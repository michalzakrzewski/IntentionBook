package com.zakrzewski.intentionbook.controllers;

import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import com.zakrzewski.intentionbook.services.BookOfIntentionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookOfIntentionController {

    private BookOfIntentionsServiceImpl bookOfIntentionsService;

    @Autowired
    public BookOfIntentionController(BookOfIntentionsServiceImpl bookOfIntentionsService) {
        this.bookOfIntentionsService = bookOfIntentionsService;
    }

    @RequestMapping(value = "/show-intentions", method = RequestMethod.GET)
    public List<BookOfIntentionModel> getAllIntentions(){
        List<BookOfIntentionModel> bookOfIntentionModelList = bookOfIntentionsService.getAllIntentions();
        return bookOfIntentionModelList;
    }

    @RequestMapping(value = "/add-intention", method = RequestMethod.POST)
    public void addNewIntention(@RequestBody BookOfIntentionModel bookOfIntentionModel){
        bookOfIntentionsService.addNewIntention(bookOfIntentionModel);
    }

    @RequestMapping(value = "/edit-intention/{id}", method = RequestMethod.PUT)
    public void editIntention(@PathVariable Long id, @RequestBody BookOfIntentionModel bookOfIntentionModel){
        bookOfIntentionsService.editIntention(bookOfIntentionModel);
    }

    @RequestMapping(value = "/delete-intention/{id}", method = RequestMethod.DELETE)
    public void deleteIntention(@PathVariable Long id){
        bookOfIntentionsService.deleteIntentionById(id);
    }
}


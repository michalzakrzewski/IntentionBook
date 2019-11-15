package com.zakrzewski.intentionbook.controllers;

import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import com.zakrzewski.intentionbook.services.BookOfIntentionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}

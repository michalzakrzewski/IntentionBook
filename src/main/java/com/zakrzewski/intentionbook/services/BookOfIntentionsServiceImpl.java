package com.zakrzewski.intentionbook.services;

import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import com.zakrzewski.intentionbook.repositories.BookOfIntentionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOfIntentionsServiceImpl {

    private BookOfIntentionRepository bookOfIntentionRepository;

    @Autowired
    public BookOfIntentionsServiceImpl(BookOfIntentionRepository bookOfIntentionRepository) {
        this.bookOfIntentionRepository = bookOfIntentionRepository;
    }

    public List<BookOfIntentionModel> getAllIntentions(){
        return bookOfIntentionRepository.findAll();
    }

    public BookOfIntentionModel getOneIntentionById(Long id){
        return bookOfIntentionRepository.getOne(id);
    }

    public void addNewIntention(BookOfIntentionModel bookOfIntentionModel){
        bookOfIntentionRepository.save(bookOfIntentionModel);
    }

    public void editIntention(Long id, BookOfIntentionModel bookOfIntentionModel){
        bookOfIntentionRepository.save(bookOfIntentionModel);
    }
}

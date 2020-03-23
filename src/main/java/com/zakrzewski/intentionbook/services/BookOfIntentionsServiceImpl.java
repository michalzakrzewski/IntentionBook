package com.zakrzewski.intentionbook.services;

import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import com.zakrzewski.intentionbook.repositories.BookOfIntentionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BookOfIntentionsServiceImpl {

    private BookOfIntentionRepository bookOfIntentionRepository;

    @Autowired
    public BookOfIntentionsServiceImpl(BookOfIntentionRepository bookOfIntentionRepository) {
        this.bookOfIntentionRepository = bookOfIntentionRepository;
    }

    public List<BookOfIntentionModel> getAllIntentions(){
        List<BookOfIntentionModel> intentions = bookOfIntentionRepository.findAll();
        intentions.sort(Comparator.comparing(BookOfIntentionModel::getDateOfMass));
        return intentions;
    }

    public BookOfIntentionModel getOneIntentionById(Long id){
        return bookOfIntentionRepository.findById(id).orElseThrow(() -> new RuntimeException("Intention does not exist"));
    }

    public void addNewIntention(BookOfIntentionModel bookOfIntentionModel){
        bookOfIntentionRepository.save(bookOfIntentionModel);
    }

    public void editIntention(Long id, BookOfIntentionModel bookOfIntentionModel){
        bookOfIntentionRepository.findById(id)
                .map(element -> {
                    element.setDateOfMass(bookOfIntentionModel.getDateOfMass());
                    element.setTimeOfMass(bookOfIntentionModel.getTimeOfMass());
                    element.setDescriptionOfIntention(bookOfIntentionModel.getDescriptionOfIntention());
                    element.setWhichPriest(bookOfIntentionModel.getWhichPriest());
                    element.setOthersAttention(bookOfIntentionModel.getOthersAttention());
                    element.setPayment(bookOfIntentionModel.getPayment());
                    element.setWhoAddIntention(bookOfIntentionModel.getWhoAddIntention());
                    return bookOfIntentionRepository.save(element);
                }).orElseGet(() -> {
                    bookOfIntentionModel.setId(id);
                    return bookOfIntentionRepository.save(bookOfIntentionModel);
        });
    }

    public void deleteIntentionById(Long id){
        bookOfIntentionRepository.deleteById(id);
    }
}

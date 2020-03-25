package com.zakrzewski.intentionbook.repositories;

import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookOfIntentionRepository extends JpaRepository<BookOfIntentionModel, Long> {

    List<BookOfIntentionModel> findAllByDateOfMass(LocalDate dateOfMass);
}

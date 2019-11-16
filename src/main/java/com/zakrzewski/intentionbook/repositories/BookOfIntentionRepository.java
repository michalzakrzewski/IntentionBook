package com.zakrzewski.intentionbook.repositories;

import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOfIntentionRepository extends JpaRepository<BookOfIntentionModel, Long> {
}

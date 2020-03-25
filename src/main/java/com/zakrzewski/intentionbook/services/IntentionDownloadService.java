package com.zakrzewski.intentionbook.services;

import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import com.zakrzewski.intentionbook.repositories.BookOfIntentionRepository;
import com.zakrzewski.intentionbook.utils.GeneratePdfIntention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class IntentionDownloadService {

    private final BookOfIntentionRepository bookOfIntentionRepository;
    private final GeneratePdfIntention generatePdfIntention;

    @Autowired
    public IntentionDownloadService(BookOfIntentionRepository bookOfIntentionRepository, GeneratePdfIntention generatePdfIntention) {
        this.bookOfIntentionRepository = bookOfIntentionRepository;
        this.generatePdfIntention = generatePdfIntention;
    }

    public ResponseEntity<InputStreamResource> intentionReportGenerate(LocalDate dateOfMass){
        List<BookOfIntentionModel> intentionModelList = bookOfIntentionRepository.findAllByDateOfMass(dateOfMass);
        ByteArrayInputStream byteArrayInputStream = generatePdfIntention.intentionReport(intentionModelList, dateOfMass);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", null);
        return ResponseEntity.ok().header(String.valueOf(headers)).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(byteArrayInputStream));

    }
}

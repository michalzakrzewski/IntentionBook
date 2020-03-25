package com.zakrzewski.intentionbook.controllers;

import com.zakrzewski.intentionbook.services.BookOfIntentionsServiceImpl;
import com.zakrzewski.intentionbook.services.IntentionDownloadService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Controller
public class IntentionDownloadController {

    private final BookOfIntentionsServiceImpl bookOfIntentionsService;
    private final IntentionDownloadService intentionDownloadService;

    @Autowired
    public IntentionDownloadController(BookOfIntentionsServiceImpl bookOfIntentionsService, IntentionDownloadService intentionDownloadService) {
        this.bookOfIntentionsService = bookOfIntentionsService;
        this.intentionDownloadService = intentionDownloadService;
    }


    @RequestMapping("/intention-generate")
    public String generateIntentionPage(Model model){
        LocalDate localDate = LocalDate.now();
        model.addAttribute("minDate", localDate);
        return "intention-generate";
    }


    @RequestMapping(value = "/generate", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generateIntentionFile(@RequestParam(value = "dateMass") String dateMass){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ourDate = LocalDate.parse(dateMass, formatter);
        return intentionDownloadService.intentionReportGenerate(LocalDate.of(ourDate.getYear(), ourDate.getMonth(), ourDate.getDayOfMonth()));
    }
}

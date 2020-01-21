package com.zakrzewski.intentionbook;

import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import com.zakrzewski.intentionbook.entities.PriestModel;
import com.zakrzewski.intentionbook.entities.SacristanModel;
import com.zakrzewski.intentionbook.enums.AccessEnum;
import com.zakrzewski.intentionbook.repositories.BookOfIntentionRepository;
import com.zakrzewski.intentionbook.repositories.ChurchWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.persistence.Access;

@SpringBootApplication
public class IntentionBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntentionBookApplication.class, args);
    }

    private BookOfIntentionRepository bookOfIntentionRepository;
    private ChurchWorkerRepository churchWorkerRepository;

    @Autowired
    public IntentionBookApplication(BookOfIntentionRepository bookOfIntentionRepository, ChurchWorkerRepository churchWorkerRepository) {
        this.bookOfIntentionRepository = bookOfIntentionRepository;
        this.churchWorkerRepository = churchWorkerRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createFinalTemplate() {

        ChurchWorker priest1 = new PriestModel("Priest1", "Priest2", AccessEnum.USER_KAPLAN);
        ChurchWorker priest2 = new PriestModel("Priest2", "Priest2", AccessEnum.USER_KAPLAN);
        ChurchWorker priest3 = new PriestModel("SuperPriest1", "SuperPriest2", AccessEnum.SUPER_USER);
        ChurchWorker sacristian1 = new SacristanModel("Bogusław", "Pietras", AccessEnum.USER_ZAKRYS);
        ChurchWorker sacristian2 = new SacristanModel("Ryszard", "Gosztyła", AccessEnum.USER_ZAKRYS);
        churchWorkerRepository.save(priest1);
        churchWorkerRepository.save(priest2);
        churchWorkerRepository.save(priest3);
        churchWorkerRepository.save(sacristian1);
        churchWorkerRepository.save(sacristian2);

        BookOfIntentionModel intentionModel1 = new BookOfIntentionModel("15.11.2019", "8:00", "W dniu 19 urodzin Marysi.", "O. Proboszcz", "brak", "100zł", sacristian1);
        BookOfIntentionModel intentionModel2 = new BookOfIntentionModel("16.11.2019", "18:00", "Za + Izoldę w 13 rocznicę śmierci.", "O. Proboszcz", "brak", "80zł", priest2);
        BookOfIntentionModel intentionModel3 = new BookOfIntentionModel("17.11.2019", "7:00", "Za darczyńców.", "O. Małowiecki", "brak", "50zł", priest1);
        BookOfIntentionModel intentionModel4 = new BookOfIntentionModel("18.11.2019", "6:30", "Za dusze w czyścu cierpiące.", "O. Krasiak", "brak", "40zł", sacristian1);
        bookOfIntentionRepository.save(intentionModel1);
        bookOfIntentionRepository.save(intentionModel2);
        bookOfIntentionRepository.save(intentionModel3);
        bookOfIntentionRepository.save(intentionModel4);
    }

}

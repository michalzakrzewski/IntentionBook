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
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

        System.out.println("Admin: " + AccessEnum.ADMIN);
        System.out.println("Admin, get desc: " + AccessEnum.ADMIN.getRoleDescription());
        System.out.println("Admin, name: " + AccessEnum.ADMIN.name());

        System.out.println("=========================================");

        System.out.println("Zakrystianin: " + AccessEnum.USER_ZAKRYS);
        System.out.println("Zakrystianin, get desc: " + AccessEnum.USER_ZAKRYS.getRoleDescription());
        System.out.println("Zakrystianin, name: " + AccessEnum.USER_ZAKRYS.name());
        System.out.println("=========================================");
        System.out.println(AccessEnum.USER_ZAKRYS.getAuthority());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createFinalTemplate() {

        ChurchWorker priest1 = new PriestModel("priest1", passwordEncoder().encode("qwerty") , "Priest1", "Priest1", AccessEnum.USER_KAPLAN.getRoleDescription());
        ChurchWorker priest2 = new PriestModel("priest2", passwordEncoder().encode("qwerty"), "Priest2", "Priest2", AccessEnum.USER_KAPLAN.getRoleDescription());
        ChurchWorker priest3 = new PriestModel("superpriest", passwordEncoder().encode("qwerty"),"SuperPriest1", "SuperPriest2", AccessEnum.ADMIN.name());
        ChurchWorker sacristian1 = new SacristanModel("zakr1", passwordEncoder().encode("qwerty"), "Bogusław", "Pietras", AccessEnum.USER_ZAKRYS.getRoleDescription());
        ChurchWorker sacristian2 = new SacristanModel("zakr2", passwordEncoder().encode("qwerty"), "Ryszard", "Gosztyła", AccessEnum.USER_ZAKRYS.getRoleDescription());
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

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

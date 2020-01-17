package com.zakrzewski.intentionbook;

import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import com.zakrzewski.intentionbook.entities.SacristanModel;
import com.zakrzewski.intentionbook.enums.AccessEnum;
import com.zakrzewski.intentionbook.repositories.BookOfIntentionRepository;
import com.zakrzewski.intentionbook.repositories.SacristianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class IntentionBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntentionBookApplication.class, args);
	}

	private BookOfIntentionRepository bookOfIntentionRepository;
	private SacristianRepository sacristianRepository;

	@Autowired
    public IntentionBookApplication(BookOfIntentionRepository bookOfIntentionRepository, SacristianRepository sacristianRepository) {
        this.bookOfIntentionRepository = bookOfIntentionRepository;
        this.sacristianRepository = sacristianRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
	public void createFinalTemplate(){

		SacristanModel sacristanModel1 = new SacristanModel("Bogusław", "Pietras", AccessEnum.USER_ZAKR);
		SacristanModel sacristanModel2 = new SacristanModel("Ryszard", "Gosztyła", AccessEnum.USER_ZAKR);
		sacristianRepository.save(sacristanModel1);
		sacristianRepository.save(sacristanModel2);

        BookOfIntentionModel intentionModel1 = new BookOfIntentionModel("15.11.2019", "8:00", "W dniu 19 urodzin Marysi.", "O. Proboszcz", "brak", "100zł", sacristanModel1);
        BookOfIntentionModel intentionModel2 = new BookOfIntentionModel("16.11.2019", "18:00", "Za + Izoldę w 13 rocznicę śmierci.", "O. Proboszcz", "brak", "80zł", sacristanModel2);
        BookOfIntentionModel intentionModel3 = new BookOfIntentionModel("17.11.2019", "7:00", "Za darczyńców.", "O. Małowiecki", "brak", "50zł", sacristanModel2);
        BookOfIntentionModel intentionModel4= new BookOfIntentionModel("18.11.2019", "6:30", "Za dusze w czyścu cierpiące.", "O. Krasiak", "brak", "40zł", sacristanModel1);
        bookOfIntentionRepository.save(intentionModel1);
        bookOfIntentionRepository.save(intentionModel2);
        bookOfIntentionRepository.save(intentionModel3);
        bookOfIntentionRepository.save(intentionModel4);
    }

}

package ch.business.quickline.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.repository.AbteilungRepository;
import ch.business.quickline.service.AbteilungService;
import ch.quickline.business.config.JpaConfig;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
		AbteilungRepository abteilungRepository = (AbteilungRepository)context.getBean("abteilungRepository");
		AbteilungService service = (AbteilungService)context.getBean("abteilungService");
		
		Abteilung abteilung = new Abteilung();
		abteilung.setAbteilungName("Service Center");
		System.out.println("AbteilungID before persisting: " + abteilung.getAbteilungId());
		abteilungRepository.delete(2);
		//service.save(abteilung);
		System.out.println("AbteilungID after persisting: " + abteilung.getAbteilungId());
		

	}

}

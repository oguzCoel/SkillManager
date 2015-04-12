package ch.business.quickline.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.config.JpaConfig;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.repository.MitarbeiterSkillRepository;
import ch.business.quickline.service.MitarbeiterSkillService;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
		MitarbeiterSkillRepository skillRepository = (MitarbeiterSkillRepository)context.getBean("mitarbeiterSkillRepository");
		//MitarbeiterSkillService mitarbeiterSkillService = (MitarbeiterSkillService)context.getBean("mitarbeiterSkillService");
		MitarbeiterSkillService mitarbeiterSkillService = (MitarbeiterSkillService) context.getBean("mitarbeiterSkillService");
		
		/*Abteilung abteilung = new Abteilung();
		abteilung.setAbteilungName("Service Center");
		System.out.println("AbteilungID before persisting: " + abteilung.getAbteilungId());
		//abteilungRepository.delete(2);
		service.save(abteilung);
		System.out.println("AbteilungID after persisting: " + abteilung.getAbteilungId());
		*/
		Double sum = 0.0;
		for (MitarbeiterSkill skill: mitarbeiterSkillService.findAll()){
			
			sum = sum + skill.getMasterBewertung().doubleValue();
		}
		
		Double avg = sum / mitarbeiterSkillService.findAll().size();
		
		System.out.println("Gesamtdurchschnitt: "+ " " + avg);
		
		

	}

}

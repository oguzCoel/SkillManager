package ch.business.quickline.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.config.JpaConfig;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.repository.MitarbeiterRepository;
import ch.business.quickline.repository.MitarbeiterSkillRepository;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
		MitarbeiterSkillRepository mitarbeiterSkillRepository = (MitarbeiterSkillRepository)context.getBean("mitarbeiterSkillRepository");
		MitarbeiterSkillService mitarbeiterSkillService = (MitarbeiterSkillService) context.getBean("mitarbeiterSkillService");
		MitarbeiterRepository mitarbeiterRepository = (MitarbeiterRepository) context.getBean("mitarbeiterRepository");
		MitarbeiterService mitarbeiterService = (MitarbeiterService) context.getBean("mitarbeiterService");
		
		/*Abteilung abteilung = new Abteilung();
		abteilung.setAbteilungName("Service Center");
		System.out.println("AbteilungID before persisting: " + abteilung.getAbteilungId());
		//abteilungRepository.delete(2);
		service.save(abteilung);
		System.out.println("AbteilungID after persisting: " + abteilung.getAbteilungId());
		*/
		
		/*
		Double sum = 0.0;
		for (MitarbeiterSkill skill: mitarbeiterSkillService.findAll()){
			
			sum = sum + skill.getMasterBewertung().doubleValue();
		}
		
		Double avg = sum / mitarbeiterSkillService.findAll().size();
		
		System.out.println("Gesamtdurchschnitt: "+ " " + avg);
		
		*/
		
		//List<Mitarbeiter> mitarbeiter = mitarbeiterService.findByMitarbeiterID(1);
		//List<Skill> skills = new ArrayList<Skill>();
		
		/*
		for (MitarbeiterSkill i : mitarbeiterSkillService.findAll()){
			
			if (i.getMitarbeiter().getMitarbeiterId().equals(1))
			System.out.println(i.getMitarbeiter().getMitarbeiterNachname() + " " + i.getMasterBewertung() + " " + i.getSkill().getSkillName());
		}
*/
		 Mitarbeiter mitarbeiter = mitarbeiterService.findByMitarbeiterId(1);
	        
	        for(MitarbeiterSkill mitarbeiterSkill : mitarbeiterSkillService.findByMitarbeiter(mitarbeiter)){
	        	System.out.println(mitarbeiterSkill.getSkill().getSkillName() + " " + mitarbeiterSkill.getMasterBewertung());
	        }
	}

}

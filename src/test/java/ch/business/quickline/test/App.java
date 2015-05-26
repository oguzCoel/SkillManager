package ch.business.quickline.test;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import ch.business.quickline.config.JpaConfig;
import ch.business.quickline.config.SecurityConfig;
import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.repository.MitarbeiterRepository;
import ch.business.quickline.repository.MitarbeiterSkillRepository;
import ch.business.quickline.service.AbteilungService;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillService;
import ch.business.quickline.service.UserDetailService;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
		MitarbeiterSkillRepository mitarbeiterSkillRepository = (MitarbeiterSkillRepository)context.getBean("mitarbeiterSkillRepository");
		MitarbeiterSkillService mitarbeiterSkillService = (MitarbeiterSkillService) context.getBean("mitarbeiterSkillService");
		MitarbeiterRepository mitarbeiterRepository = (MitarbeiterRepository) context.getBean("mitarbeiterRepository");
		MitarbeiterService mitarbeiterService = (MitarbeiterService) context.getBean("mitarbeiterService");
		AbteilungService abteilungService = (AbteilungService) context.getBean("abteilungService");
		SkillService skillService = (SkillService) context.getBean("skillService");
		
		
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
		
		/*
		 Mitarbeiter mitarbeiter = mitarbeiterService.findByMitarbeiterId(1);
	        
	        for(MitarbeiterSkill mitarbeiterSkill : mitarbeiterSkillService.findByMitarbeiterOrderByMasterBewertungDesc(mitarbeiter)){
	        	System.out.println(mitarbeiterSkill.getSkill().getSkillName() + " " + mitarbeiterSkill.getMasterBewertung());
	        }
	        
	        List<Abteilung> abteilungen = abteilungService.findALL();
	        
	        
	        Mitarbeiter mitarbeiterNeu = new Mitarbeiter();
	        mitarbeiterNeu.setAbteilung(abteilungen.get(2));
	        mitarbeiterNeu.setMitarbeiterVorname("Toni");
	        mitarbeiterNeu.setMitarbeiterNachname("Mueller");
	        mitarbeiterNeu.setMitarbeiterRolle("Supporter");
	        Date date = new Date();
	        mitarbeiterNeu.setMitarbeiterGeburtsDatum(date);
	        mitarbeiterNeu.setMitarbeiterAnstellungsDatum(date);
	        mitarbeiterNeu.setMitarbeiterAdresse("Sonnenbergstrasse");
	        mitarbeiterNeu.setMitarbeiterHausNummer(9);
	        mitarbeiterNeu.setMitarbeiterPlz(4127);
	        mitarbeiterNeu.setMitarbeiterWohnort("Birsfelden");
	        
	        mitarbeiterService.save(mitarbeiterNeu);
	        
	        */
		
		Skill skill = skillService.findBySkillId(1);
		List<MitarbeiterSkill> liste = mitarbeiterSkillService.findBySkillAndMasterBewertungGreaterThanEqualOrderByMasterBewertung(skill, 1);
		
		for (MitarbeiterSkill i:liste){
			System.out.println(i.getMitarbeiter().getMitarbeiterVorname() + " " + i.getMasterBewertung());
		}
		
		



	        }
	
	

}

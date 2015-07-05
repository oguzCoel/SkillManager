package ch.business.quickline.story;

import java.util.Date;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.service.AbteilungService;
import ch.business.quickline.service.BenutzerService;
import ch.business.quickline.service.MitarbeiterService;

@Component
public class ManageBenutzerSteps {
	
	@Autowired
	private AbteilungService abteilungService;
	
	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	@Autowired
	private BenutzerService benutzerService;
	
	
	
	
	private Abteilung abteilung;
	private Mitarbeiter mitarbeiter = new Mitarbeiter();
	private Benutzer benutzer = new Benutzer();
	
	@Given("eine AbteilungX mit ID $id")
	public void initAbteilung(Integer id){
		
		abteilung = abteilungService.findByAbteilungId(id);
		
	}
	
	@Given("eine MitarbeiterX in der AbteilungX, mit Vornamen '$vorname' und Nachname '$nachname', geboren am $geburtsdatum und angestellt seit $anstellungsdatum")
	public void initMitarbeiter(String vorname, String nachname, Date geburtsdatum, Date anstellungsdatum){
		mitarbeiter.setAbteilung(abteilung);
		mitarbeiter.setMitarbeiterVorname(vorname);
		mitarbeiter.setMitarbeiterNachname(nachname);
		mitarbeiter.setMitarbeiterRolle("Informatiker");
		mitarbeiter.setMitarbeiterGeburtsDatum(geburtsdatum);
		mitarbeiter.setMitarbeiterAnstellungsDatum(anstellungsdatum);
		mitarbeiter.setMitarbeiterAdresse("Musterstrasse");
		mitarbeiter.setMitarbeiterHausNummer(9);
		mitarbeiter.setMitarbeiterPlz(4127);
		mitarbeiter.setMitarbeiterWohnort("Birsfelden");
	}
	
	@Given("einen Benutzeraccount für MitarbeiterX, mit Benutzername '$benutzername', passwort '$password' und Mailadresse '$email'")
	public void initBenutzer(String benutzername, String password, String email){
		benutzer.setMitarbeiter(mitarbeiter);
		benutzer.setBenutzerName(benutzername);
		benutzer.setBenutzerPasswort(password);
		benutzer.setBenutzerEmail(email);
		
	}
	

	
	@When("der Administrator den MitarbeiterX und seinen Benutzeraccount erfasst")
	public void saveMitarbeiter(){
		mitarbeiterService.save(mitarbeiter);
		benutzerService.save(benutzer);
	}
	
	
	@Then("ist MitarbeiterX in der AbteilungX mit ID $id erfasst")
	public void lookForMitarbeiter(Integer id){
		Assert.assertEquals( abteilungService.findByAbteilungId(id), mitarbeiter.getAbteilung() );
	}
	
	@Then("der zugehörige Benutzeraccount ist ebenfalls in der Datenbank gespeichert")
	public void lookForBenutzer(){
		Integer id = benutzer.getBenutzerId();
		Integer countOfBenutzer = benutzerService.findAll().size();
		Assert.assertEquals(id, countOfBenutzer);
	}
	
	
}



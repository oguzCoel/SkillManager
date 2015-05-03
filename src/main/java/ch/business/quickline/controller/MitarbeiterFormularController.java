package ch.business.quickline.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.service.AbteilungService;
import ch.business.quickline.service.MitarbeiterService;


@Component
@Scope("request")
public class MitarbeiterFormularController implements Serializable {
	
	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	@Autowired
	private AbteilungService abteilungService;
	
	private Mitarbeiter mitarbeiter = new Mitarbeiter();
	
	private List <Abteilung> abteilungen;
	private Abteilung abteilung;
	
	
	
	@PostConstruct
	public void init () {
		abteilungen = abteilungService.findALL();
		
		for (Abteilung abt:abteilungen){
			System.out.println(abt);
		}
		
	}
	
	public void initValues(){
		
	}
	

	public List<Abteilung> getAbteilungen() {
		
		
		return abteilungen;
	}


	public void setAbteilungen(List<Abteilung> abteilungen) {
		this.abteilungen = abteilungen;
	}



	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}
	
	

	public Abteilung getAbteilung() {
		return abteilung;
	}


	public void setAbteilung(Abteilung abteilung) {
		this.abteilung = abteilung;
	}

	
	public void save()throws Exception{
		mitarbeiterService.save(mitarbeiter);
		
		
	}
	
	
	

}

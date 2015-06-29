package ch.business.quickline.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.service.AbteilungService;
import ch.business.quickline.service.MitarbeiterService;

@ManagedBean
@Component
@ViewScoped
public class MitarbeiterTable implements Serializable {
	// Log
		final Logger logger = Logger.getLogger(MitarbeiterTable.class);
	


	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	@Autowired
	private AbteilungService abteilungService;
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	
	
	
	
	private Mitarbeiter mitarbeiter = new Mitarbeiter();
	private List<Mitarbeiter> mitarbeiters;
	private List <Abteilung> abteilungen;
	private Abteilung abteilung;

	
	@PostConstruct
	public void init (){
		mitarbeiters = mitarbeiterService.findAll();
		abteilungen = abteilungService.findALL();
		
	}

	public List<Mitarbeiter> getMitarbeiters() {
		return mitarbeiters;
	}

	public void setMitarbeiters(List<Mitarbeiter> mitarbeiterTable) {
		this.mitarbeiters = mitarbeiterTable;
	}

	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public List<Abteilung> getAbteilungen() {
		return abteilungen;
	}

	public void setAbteilungen(List<Abteilung> abteilungen) {
		this.abteilungen = abteilungen;
	}

	public Abteilung getAbteilung() {
		return abteilung;
	}

	public void setAbteilung(Abteilung abteilung) {
		this.abteilung = abteilung;
	}
	
	


	public void save()throws Exception{
		
		try {
			mitarbeiterService.save(mitarbeiter);
			init();
			unternehmenViewController.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Fehler beim Abspeichern . Details" +e.getMessage());
		}
		
			
		
	}
	
	
	
	
	

}

package ch.business.quickline.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.service.AbteilungService;
import ch.business.quickline.service.BenutzerRoleService;
import ch.business.quickline.service.BenutzerService;
import ch.business.quickline.service.MitarbeiterQualifikationService;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillMasterService;

@ManagedBean
@Component
@ViewScoped
public class MitarbeiterTable implements Serializable {
	


	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	@Autowired
	private AbteilungService abteilungService;
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	
	@Autowired
	private BenutzerService benutzerService;
	
	@Autowired
	private BenutzerRoleService benutzerRoleService;
	
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	@Autowired
	private SkillMasterService skillMasterService;
	
	@Autowired
	private MitarbeiterQualifikationService mitarbeiterQualifikationService;
	
	@ManagedProperty("#{param.id}")
    private Integer id;
	
	
	
	
	private Mitarbeiter mitarbeiter = new Mitarbeiter();
	private Mitarbeiter mitarbeiterToDelete;
	private Benutzer benutzerToDelete;
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
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void save()throws Exception{
		
		mitarbeiterService.save(mitarbeiter);
		init();
		unternehmenViewController.init();	
		
	}
	
	public void delete(){
		mitarbeiterToDelete = mitarbeiterService.findByMitarbeiterId(id);
		benutzerToDelete = benutzerService.findByMitarbeiter(mitarbeiterToDelete);
		
		benutzerRoleService.deleteByBenutzer(benutzerToDelete);
		benutzerService.deleteByMitarbeiter(mitarbeiterToDelete);
		mitarbeiterSkillService.deleteByMitarbeiter(mitarbeiterToDelete);
		skillMasterService.deleteByMitarbeiter(mitarbeiterToDelete);
		mitarbeiterQualifikationService.deleteByMitarbeiter(mitarbeiterToDelete);
		mitarbeiterService.deleteByMitarbeiterId(id);
		
		init();
		unternehmenViewController.init();
			
	}
	
	
	
	
	

}

package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.BenutzerRole;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.Role;
import ch.business.quickline.service.AbteilungService;
import ch.business.quickline.service.BenutzerRoleService;
import ch.business.quickline.service.BenutzerService;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.RoleService;

@ManagedBean
@Component
public class MitarbeiterEditController {
	
	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	@Autowired
	private AbteilungService abteilungService;
	
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	
	
	@Autowired
	private MitarbeiterTable mitarbeiterTable;
	
	
	@Autowired
	private BenutzerService benutzerService;
	
	
	@Autowired
	private RoleService roleService;
	
	
	@Autowired
	private BenutzerRoleService benutzerRoleService;
	
	@ManagedProperty("#{param.id}")
    private Integer id;
	
	
	private Mitarbeiter mitarbeiter;
	private Benutzer benutzer;
	private BenutzerRole benutzerRole;
	private Abteilung abteilung;
	private List <Role> roles;
	private List <Abteilung> abteilungen;
	
	
	
	public void init (){
		mitarbeiter = mitarbeiterService.findByMitarbeiterId(id);
		benutzer = benutzerService.findByMitarbeiter(mitarbeiter);
		benutzerRole = benutzerRoleService.findByBenutzer(benutzer);
		abteilungen = abteilungService.findALL();
		roles = roleService.findAll();

	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}



	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}



	public Benutzer getBenutzer() {
		return benutzer;
	}



	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}



	public BenutzerRole getBenutzerRole() {
		return benutzerRole;
	}



	public void setBenutzerRole(BenutzerRole benutzerRole) {
		this.benutzerRole = benutzerRole;
	}



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
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


	@PreAuthorize("hasRole ('ROLE_ADMIN')")
	public void save(){
		mitarbeiterService.save(mitarbeiter);
		benutzer.setMitarbeiter(mitarbeiter);
		benutzerService.save(benutzer);
		benutzerRole.setBenutzer(benutzer);
		benutzerRoleService.save(benutzerRole);
		unternehmenViewController.init();
		mitarbeiterTable.init();
		
		
		FacesMessage msg = new FacesMessage
				("Änderungen wurden erfolgreich gespeichert");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	
}

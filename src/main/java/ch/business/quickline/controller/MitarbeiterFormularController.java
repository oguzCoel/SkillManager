package ch.business.quickline.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.service.AbteilungService;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.UserDetailService;
import ch.business.quickline.domain.*;

@ManagedBean
@Component
@Scope ("session")
public class MitarbeiterFormularController implements Serializable {
	
	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	@Autowired
	private AbteilungService abteilungService;
	
	@Autowired 
	private UserDetailService userDetailService;
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	
	
	
	private Mitarbeiter mitarbeiter = new Mitarbeiter();
	
	private List <Abteilung> abteilungen;
	private Abteilung abteilung;
	private Benutzer benutzer;
	
	
	
	
	@PostConstruct
	public void init () {
		abteilungen = abteilungService.findALL();
		   
		
		for (Abteilung abt:abteilungen){
			System.out.println(abt);
		}
		
		System.out.println(benutzer.getBenutzerName());
		
		
		
		

	    
		
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
		unternehmenViewController.init();
			
		
	}
	
	
	

}

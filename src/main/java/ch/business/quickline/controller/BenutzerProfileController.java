package ch.business.quickline.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.service.BenutzerService;

@Component
@Scope ("request")
public class BenutzerProfileController {

	@Autowired
	private BenutzerService benutzerService;
	
	private Benutzer benutzer;
	
	String benutzerName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	
	@PostConstruct
	public void init (){
		
		benutzer = benutzerService.findByBenutzerName(benutzerName);
	}
	
	public void save (){
		benutzerService.save(benutzer);
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	
	
}

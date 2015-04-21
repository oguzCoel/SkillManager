package ch.business.quickline.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.service.MitarbeiterService;


@ManagedBean
@Component
@ViewScoped
public class MitarbeiterIndividual {
	
	@Autowired 
	private MitarbeiterService mitarbeiterService;
	
	private Mitarbeiter mitarbeiter;
	
	@PostConstruct
	public void init (){
		mitarbeiter = mitarbeiterService.findByMitarbeiterId(1);
	}

	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}
	
	
	

}

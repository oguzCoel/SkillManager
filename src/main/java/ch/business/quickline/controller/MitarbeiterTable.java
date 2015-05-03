package ch.business.quickline.controller;

import java.io.Serializable;
import java.util.List;

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
public class MitarbeiterTable implements Serializable {
	
	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	private List<Mitarbeiter> mitarbeiters;
	
	@PostConstruct
	public void init (){
		mitarbeiters = mitarbeiterService.findAll();
	}

	public List<Mitarbeiter> getMitarbeiters() {
		return mitarbeiters;
	}

	public void setMitarbeiters(List<Mitarbeiter> mitarbeiterTable) {
		this.mitarbeiters = mitarbeiterTable;
	}
	
	
	
	
	

}

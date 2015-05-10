package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.service.AbteilungService;


@ManagedBean
@Component
@ViewScoped
public class AbteilungController  {
	
	


	@Autowired
	private AbteilungService abteilungService;
	
	
private Abteilung abteilung = new Abteilung ();
private List<Abteilung> abteilungen;




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

@PreAuthorize("hasRole ('ADMIN')")
public String save(){
	abteilungService.save(abteilung);
	return "Abteilung saved";
}


public List<Abteilung> loadAbteilungen(){
	abteilungen = abteilungService.findALL();
	
	return abteilungen;
}

}

package ch.business.quickline.controller;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.service.AbteilungService;


@ManagedBean
@Component
public class AbteilungController {
	@Autowired
	private AbteilungService abteilungService;
	
private Abteilung abteilung = new Abteilung ();

public Abteilung getAbteilung() {
	return abteilung;
}

public void setAbteilung(Abteilung abteilung) {
	this.abteilung = abteilung;
}

public String save(){
	abteilungService.save(abteilung);
	return "Abteilung saved";
}


}

package ch.business.quickline.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.service.AbteilungService;
import ch.business.quickline.service.UserDetailService;



@Component
@Scope ("request")
public class AbteilungController  {
	
	


	@Autowired
	private AbteilungService abteilungService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	

	
	
private Abteilung abteilung = new Abteilung ();
private List<Abteilung> abteilungen;

@PostConstruct
public void init (){
	
	System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
	
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
public String save(){
	abteilungService.save(abteilung);
	return "Abteilung saved";
}


public List<Abteilung> loadAbteilungen(){
	abteilungen = abteilungService.findALL();
	
	return abteilungen;
}

}

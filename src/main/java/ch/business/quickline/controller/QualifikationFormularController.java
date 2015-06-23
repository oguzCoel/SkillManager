package ch.business.quickline.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.service.QualifikationService;

@ManagedBean
@Component
@Scope("request")
public class QualifikationFormularController {
	
	@Autowired
	private QualifikationService qualifikationService;
	
	@Autowired
	private QualifikationTable qualifikationTable;
	
	private Qualifikation qualifikation = new Qualifikation();

	public Qualifikation getQualifikation() {
		return qualifikation;
	}

	public void setQualifikation(Qualifikation qualifikation) {
		this.qualifikation = qualifikation;
	}
	
	@PreAuthorize("hasRole ('ROLE_ADMIN')")
	public void save (){
		
		qualifikationService.save(qualifikation);
		qualifikationTable.init();
		
		FacesMessage msg = new FacesMessage
				(getQualifikation().getQualifikationName() + " " +
		         " erfolgreich registriert");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}

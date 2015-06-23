package ch.business.quickline.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.service.QualifikationService;

@ManagedBean
@Component
@ViewScoped
public class QualifikationEditController {
	
	@Autowired
	private QualifikationService qualifikationService;
	
	@Autowired
	private QualifikationTable qualifikationTable;
	
	
	
	@ManagedProperty("#{param.id}")
    private Integer id;
	
	private Qualifikation qualifikation;
	
	
	
	@PostConstruct
	public void init(){
		
		qualifikation = qualifikationService.findByQualifikationId(id);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Qualifikation getQualifikation() {
		return qualifikation;
	}


	public void setQualifikation(Qualifikation qualifikation) {
		this.qualifikation = qualifikation;
	}
	
	
	@PreAuthorize("hasRole ('ROLE_ADMIN')")
	public void save(){
		
		qualifikationService.save(qualifikation);
		qualifikationTable.init();
		
		
		FacesMessage msg = new FacesMessage
				("Änderungen wurden erfolgreich gespeichert");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	

}

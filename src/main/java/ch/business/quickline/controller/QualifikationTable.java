package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.service.QualifikationService;

@ManagedBean
@Component
@ViewScoped
public class QualifikationTable {
	
	@Autowired
	private QualifikationService qualifikationService;
	
	private List<Qualifikation> qualifikations;
	
	@PostConstruct
	public void init (){
		
		qualifikations = qualifikationService.findAll();
	}

	public List<Qualifikation> getQualifikations() {
		return qualifikations;
	}

	public void setQualifikations(List<Qualifikation> qualifikations) {
		this.qualifikations = qualifikations;
	}
	
	

}

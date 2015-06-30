package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.service.MitarbeiterQualifikationService;
import ch.business.quickline.service.QualifikationService;

@ManagedBean
@Component
@ViewScoped
public class QualifikationTable {
	
	@Autowired
	private QualifikationService qualifikationService;
	
	@Autowired
	private MitarbeiterQualifikationService mitarbeiterQualifikationService;
	
	@Autowired
	private MitarbeiterViewController mitarbeiterViewController;
	
	@ManagedProperty("#{param.id}")
    private Integer id;
	
	private List<Qualifikation> qualifikations;
	private Qualifikation qualifikationToDelete;
	
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void delete(){
		qualifikationToDelete = qualifikationService.findByQualifikationId(id);
		
		mitarbeiterQualifikationService.deleteByQualifikation(qualifikationToDelete);
		qualifikationService.deleteByQualifikationId(id);
		
		init();
		mitarbeiterViewController.init();
	}
	

}

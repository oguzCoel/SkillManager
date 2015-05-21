package ch.business.quickline.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterQualifikation;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;


@ManagedBean
@Component
@ViewScoped
public class MitarbeiterIndividual {
	
	@Autowired 
	private MitarbeiterService mitarbeiterService;
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	private Mitarbeiter mitarbeiter;
	private Set<MitarbeiterQualifikation> qualifikations;
	private List<MitarbeiterSkill> mitarbeiterSkills;
	private List<MitarbeiterSkill> mitarbeiterInterests;
	
	private Integer id;
	
	
	public void init (){
		mitarbeiter = mitarbeiterService.findByMitarbeiterId(id);
		qualifikations = mitarbeiter.getMitarbeiterQualifikations();
		mitarbeiterSkills = mitarbeiterSkillService.findByMitarbeiterOrderByMasterBewertungDesc(mitarbeiter);
		mitarbeiterInterests = mitarbeiterSkillService.findByMitarbeiterOrderBySelbstBewertungDesc(mitarbeiter);
	}
	
		

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public List<MitarbeiterSkill> getMitarbeiterSkills() {
		return mitarbeiterSkills;
	}


	public void setMitarbeiterSkills(List<MitarbeiterSkill> mitarbeiterSkills) {
		this.mitarbeiterSkills = mitarbeiterSkills;
	}


	public List<MitarbeiterSkill> getMitarbeiterInterests() {
		return mitarbeiterInterests;
	}


	public void setMitarbeiterInterests(List<MitarbeiterSkill> mitarbeiterInterests) {
		this.mitarbeiterInterests = mitarbeiterInterests;
	}


	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public Set<MitarbeiterQualifikation> getQualifikations() {
		return qualifikations;
	}

	public void setQualifikations(Set<MitarbeiterQualifikation> qualifikations) {
		this.qualifikations = qualifikations;
	}
	
	
	

}

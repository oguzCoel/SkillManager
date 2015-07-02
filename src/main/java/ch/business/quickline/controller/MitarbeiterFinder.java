package ch.business.quickline.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillService;

@ManagedBean
@Component
@ViewScoped
public class MitarbeiterFinder {
	
	@Autowired
	MitarbeiterService mitarbeiterService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	MitarbeiterSkillService mitarbeiterSkillService;
	
	@Autowired
	MatchedMitarbeiter matchedMitarbeiter;
	
	private List<Integer> masterBewertungValues = new ArrayList<Integer>();
	private Integer masterBewertung;
	private Skill skill =new Skill();
	private List<Skill> skills;
	private List<MitarbeiterSkill> mitarbeiterSkills;
	
	
	@PostConstruct
	public void init (){
		
		skills =  skillService.findAll();
		//mitarbeiterSkills = mitarbeiterSkillService.findBySkillAndMasterBewertungGreaterThanEqualOrderByMasterBewertung(skill, masterBewertung);
		masterBewertungValues.add(1);
		masterBewertungValues.add(2);
		masterBewertungValues.add(3);
		masterBewertungValues.add(4);
		masterBewertungValues.add(5);
	}
	



	public Integer getMasterBewertung() {
		return masterBewertung;
	}


	public void setMasterBewertung(Integer masterBewertung) {
		this.masterBewertung = masterBewertung;
	}


	public Skill getSkill() {
		return skill;
	}


	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	
	


	public List<Integer> getMasterBewertungValues() {
		return masterBewertungValues;
	}

	public void setMasterBewertungValues(List<Integer> masterBewertungValues) {
		this.masterBewertungValues = masterBewertungValues;
	}

	public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}


	public List<MitarbeiterSkill> getMitarbeiterSkills() {
		return mitarbeiterSkills;
	}


	public void setMitarbeiterSkills(List<MitarbeiterSkill> mitarbeiterSkills) {
		this.mitarbeiterSkills = mitarbeiterSkills;
	}
	
	
	public void viewMitarbeiter() {
        RequestContext.getCurrentInstance().openDialog("faces.matchedmitarbeiter.xhtml");
		
		
    }
	
	public String save (){
		matchedMitarbeiter.setSkill(getSkill());
		matchedMitarbeiter.setMasterBewertung(getMasterBewertung());
		matchedMitarbeiter.init();
				
		return "matchedmitarbeiter.xhtml";
	}
	
	
	
	
	

}

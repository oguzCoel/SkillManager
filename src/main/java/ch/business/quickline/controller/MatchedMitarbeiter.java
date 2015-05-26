package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.service.MitarbeiterSkillService;

@ManagedBean
@Component
@ViewScoped
public class MatchedMitarbeiter {
	
	@Autowired
	MitarbeiterSkillService mitarbeiterSkillService;
	
	
	//@ManagedProperty(value="#{mitarbeiterFinder.skill}")
	private Skill skill;
	
	//@ManagedProperty(value="#{mitarbeiterFinder.masterBewertung}")
	private Integer masterBewertung;
	
	
	
	private List<MitarbeiterSkill> matchedMitarbeiter;
	
	
	
	
	public void init (){
		//skill = mitarbeiterFinder.getSkill();
		//masterBewertung = mitarbeiterFinder.getMasterBewertung();
		
		matchedMitarbeiter = mitarbeiterSkillService.findBySkillAndMasterBewertungGreaterThanEqualOrderByMasterBewertung(skill, masterBewertung);
	}

	public List<MitarbeiterSkill> getMatchedMitarbeiter() {
		return matchedMitarbeiter;
	}

	public void setMatchedMitarbeiter(List<MitarbeiterSkill> matchedMitarbeiter) {
		this.matchedMitarbeiter = matchedMitarbeiter;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Integer getMasterBewertung() {
		return masterBewertung;
	}

	public void setMasterBewertung(Integer masterBewertung) {
		this.masterBewertung = masterBewertung;
	}
	
	
	

}

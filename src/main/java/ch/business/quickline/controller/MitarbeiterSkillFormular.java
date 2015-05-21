package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillService;

@Component
@Scope("request")
public class MitarbeiterSkillFormular {
	
	@Autowired
	private MitarbeiterService mitarbeiterService;

	@Autowired
	private SkillService skillService;
	
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	
	
	
	private List<Mitarbeiter> mitarbeiter;
	private List<Skill> skills;
	private MitarbeiterSkill mitarbeiterSkill = new MitarbeiterSkill();
	
	
	@PostConstruct
	public void init (){
		mitarbeiter = mitarbeiterService.findAll();
		skills = skillService.findAll();
	}


	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}


	public void setMitarbeiter(List<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}


	public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}


	public MitarbeiterSkill getMitarbeiterSkill() {
		return mitarbeiterSkill;
	}


	public void setMitarbeiterSkill(MitarbeiterSkill mitarbeiterSkill) {
		this.mitarbeiterSkill = mitarbeiterSkill;
	}
	
	public void save(){
		mitarbeiterSkillService.save(mitarbeiterSkill);
		unternehmenViewController.init();
		//mitarbeiterViewController.initValues();
		//mitarbeiterViewController.init();
		
		
	}
}

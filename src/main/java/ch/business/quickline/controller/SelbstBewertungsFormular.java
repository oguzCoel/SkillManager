package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.service.BenutzerService;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillService;

@Component
@Scope("request")
public class SelbstBewertungsFormular {
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	@Autowired
	private BenutzerService benutzerService;
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	
	
	
	private MitarbeiterSkill mitarbeiterSkill = new MitarbeiterSkill();
	private List<Skill> skills;
	private Mitarbeiter mitarbeiter;
	private String benutzerName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	
	
	@PostConstruct
	public void init (){
		
		skills = skillService.findAll();
		mitarbeiter = benutzerService.findByBenutzerName(benutzerName).getMitarbeiter();	
	}


	public MitarbeiterSkill getMitarbeiterSkill() {
		return mitarbeiterSkill;
	}


	public void setMitarbeiterSkill(MitarbeiterSkill mitarbeiterSkill) {
		this.mitarbeiterSkill = mitarbeiterSkill;
	}


	public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
	public void save(){
		mitarbeiterSkill.setMitarbeiter(mitarbeiter);
		mitarbeiterSkillService.save(mitarbeiterSkill);
		unternehmenViewController.init();
		//mitarbeiterViewController.initValues();
		//mitarbeiterViewController.init();
		
		
	}
	

}

package ch.business.quickline.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.domain.SkillMaster;
import ch.business.quickline.service.BenutzerService;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillMasterService;
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
	private SkillMasterService skillMasterService;
	
	@Autowired
	private BenutzerService benutzerService;
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	

	
	
	
	private List<Mitarbeiter> mitarbeiters;
	private List<Skill> skills = new ArrayList<Skill>();
	private List<SkillMaster> authorities;
	private MitarbeiterSkill mitarbeiterSkillToInsert = new MitarbeiterSkill();
	private MitarbeiterSkill mitarbeiterSkillToUpdate;
	private Mitarbeiter mitarbeiter;
	private String benutzerName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	
	@PostConstruct
	public void init (){
		mitarbeiters = mitarbeiterService.findAll();
		mitarbeiter = benutzerService.findByBenutzerName(benutzerName).getMitarbeiter();
		authorities = skillMasterService.findByMitarbeiter(mitarbeiter);
		
		for (SkillMaster skillMaster : authorities){
			
			skills.add(skillMaster.getSkill());
		}
		
		
		
	}


	public List<Mitarbeiter> getMitarbeiters() {
		return mitarbeiters;
	}


	public void setMitarbeiters(List<Mitarbeiter> mitarbeiter) {
		this.mitarbeiters = mitarbeiters;
	}


	public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}


	public MitarbeiterSkill getMitarbeiterSkillToInsert() {
		return mitarbeiterSkillToInsert;
	}


	public void setMitarbeiterSkillToInsert(MitarbeiterSkill mitarbeiterSkill) {
		this.mitarbeiterSkillToInsert = mitarbeiterSkill;
	}
	
	public void save() throws Exception{
		mitarbeiterSkillToUpdate = mitarbeiterSkillService.findByMitarbeiterAndSkill(getMitarbeiterSkillToInsert().getMitarbeiter(), getMitarbeiterSkillToInsert().getSkill());
		
		if(mitarbeiterSkillToUpdate == null){
			mitarbeiterSkillService.save(mitarbeiterSkillToInsert);
		}
		
		
		
		else { mitarbeiterSkillToUpdate.setMasterBewertung(getMitarbeiterSkillToInsert().getMasterBewertung());
				mitarbeiterSkillToUpdate.setSelbstBewertung(getMitarbeiterSkillToInsert().getSelbstBewertung());
				mitarbeiterSkillService.save(mitarbeiterSkillToUpdate);
		}
		
		unternehmenViewController.init();
		//mitarbeiterViewController.initValues();
		//mitarbeiterViewController.init();
		
		
	}
}

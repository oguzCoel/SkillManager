package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Gruppe;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.domain.SkillMaster;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.service.GruppeService;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.SkillMasterService;
import ch.business.quickline.service.SkillService;

@ManagedBean
@Component
@Scope("request")
public class SkillFormularController {
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private GruppeService gruppeService;
	
	@Autowired
	private SkillMasterService skillMasterService;
	
	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	
	private Skill skill = new Skill();
	private SkillMaster skillMaster = new SkillMaster();
	private List<Mitarbeiter> mitarbeiters;
	private List<Gruppe> gruppen;
	
	
	@PostConstruct
	public void init (){
		mitarbeiters = mitarbeiterService.findAll();
		gruppen = gruppeService.findAll();
	}
	
	public Skill getSkill() {
		return skill;
	}
	
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	public SkillMaster getSkillMaster() {
		return skillMaster;
	}
	
	public void setSkillMaster(SkillMaster skillMaster) {
		this.skillMaster = skillMaster;
	}
	
	public List<Mitarbeiter> getMitarbeiters() {
		return mitarbeiters;
	}
	
	public void setMitarbeiters(List<Mitarbeiter> mitarbeiters) {
		this.mitarbeiters = mitarbeiters;
	}
	
	public List<Gruppe> getGruppen() {
		return gruppen;
	}
	
	public void setGruppen(List<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}
	
	
	public void save(){
		skillService.save(skill);
		skillMaster.setSkill(skill);
		skillMasterService.save(skillMaster);
		
		FacesMessage msg = new FacesMessage
				(getSkill().getSkillName() + "  erfolgreich registriert");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	

}

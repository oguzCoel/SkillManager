package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Gruppe;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.domain.SkillMaster;
import ch.business.quickline.service.GruppeService;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.SkillMasterService;
import ch.business.quickline.service.SkillService;

@ManagedBean
@Component
public class SkillEditController {
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private GruppeService gruppeService;
	
	@Autowired
	private SkillMasterService skillMasterService;
	
	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	
	@Autowired
	SkillTable skillTable;
	
	@ManagedProperty("#{param.id}")
    private Integer id;
	
	
	private Skill skill;
	private SkillMaster skillMaster;
	private List<Mitarbeiter> mitarbeiters;
	private List<Gruppe> gruppen;
	
	
	
	public void init (){
		mitarbeiters = mitarbeiterService.findAll();
		gruppen = gruppeService.findAll();
		skill = skillService.findBySkillId(id);
		skillMaster = skillMasterService.findBySkill(skill);
		
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
	
	@PreAuthorize("hasRole ('ROLE_ADMIN')")
	public void save(){
		skillService.save(skill);
		skillMaster.setSkill(skill);
		skillMasterService.save(skillMaster);
		skillTable.init();
		unternehmenViewController.init();
		
	
		FacesMessage msg = new FacesMessage
				("Änderungen wurden erfolgreich gespeichert");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}

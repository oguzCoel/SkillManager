package ch.business.quickline.controller;

import java.io.Serializable;
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
import ch.business.quickline.repository.MitarbeiterSkillRepository;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillMasterService;
import ch.business.quickline.service.SkillService;

@ManagedBean
@Component
@ViewScoped
public class SkillTable implements Serializable {
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private SkillMasterService skillMasterService;
	
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	
	@ManagedProperty("#{param.id}")
    private Integer id;
	
	private List<Skill> skills;
	private Skill skillToDelete;
	
	
	@PostConstruct
	public void init (){
		
		skills = skillService.findAll();
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void delete (){
		skillToDelete = skillService.findBySkillId(id);
		
		skillMasterService.deleteBySkill(skillToDelete);
		mitarbeiterSkillService.deleteBySkill(skillToDelete);
		skillService.deleteBySkillId(id);
		
		init();
		unternehmenViewController.init();
		
		
		
	}
	
	

}

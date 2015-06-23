package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Skill;
import ch.business.quickline.service.SkillService;

@ManagedBean
@Component
@ViewScoped
public class SkillTable {
	
	@Autowired
	private SkillService skillService;
	
	private List<Skill> skills;
	
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
	
	

}

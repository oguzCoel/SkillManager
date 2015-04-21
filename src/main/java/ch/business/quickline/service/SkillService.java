package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Skill;

public interface SkillService {
	public Skill save (Skill skill);
	public List<Skill>findAll();

}

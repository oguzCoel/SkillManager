package ch.business.quickline.service;

import java.math.BigDecimal;
import java.util.List;

import ch.business.quickline.domain.Skill;

public interface SkillService {
	public Skill save (Skill skill);
	public List<Skill>findAll();
	public Skill findBySkillId(Integer id);
	public Double retrieveMasterBewertungDurchschnitt(Integer id);
	public Double retrieveSelbstBewertungDurchschnitt(Integer id); 
	public long count();

}

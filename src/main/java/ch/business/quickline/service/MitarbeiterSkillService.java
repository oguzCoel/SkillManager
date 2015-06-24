package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;

public interface MitarbeiterSkillService {
	
	public void save (MitarbeiterSkill mitarbeiterSkill);
	public List<MitarbeiterSkill>findAll();
	public List<MitarbeiterSkill> findByMitarbeiterOrderByMasterBewertungDesc (Mitarbeiter mitarbeiter);
	public List<MitarbeiterSkill> findByMitarbeiterOrderBySelbstBewertungDesc (Mitarbeiter mitarbeiter);
	public List<MitarbeiterSkill> findBySkillOrderByMasterBewertungDesc (Skill skill);
	public List<MitarbeiterSkill> findBySkillOrderBySelbstBewertungDesc (Skill skill);
	public List<MitarbeiterSkill> findByMitarbeiter (Mitarbeiter mitarbeiter);
	public List<MitarbeiterSkill> findBySkill (Skill skill);
 	public Double retrieveMasterBewertungGlobalAverage();
	public Double retrieveSelbstBewertungGlobalAverage();
	public Long countBySkill(Skill skill);
	public List<MitarbeiterSkill> findBySkillAndMasterBewertungGreaterThanEqualOrderByMasterBewertung(Skill skill, Integer masterBewertung );
	public MitarbeiterSkill findByMitarbeiterAndSkill (Mitarbeiter mitarbeiter, Skill skill);

 
}

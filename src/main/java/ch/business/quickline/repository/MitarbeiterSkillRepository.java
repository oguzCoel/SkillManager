package ch.business.quickline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;

public interface MitarbeiterSkillRepository extends JpaRepository<MitarbeiterSkill, Integer> {
	
	public List<MitarbeiterSkill> findByMitarbeiterOrderByMasterBewertungDesc(Mitarbeiter mitarbeiter);
	public List<MitarbeiterSkill> findByMitarbeiterOrderBySelbstBewertungDesc(Mitarbeiter mitarbeiter);
	public List<MitarbeiterSkill> findBySkillOrderByMasterBewertungDesc(Skill skill);
	public List<MitarbeiterSkill> findBySkillOrderBySelbstBewertungDesc(Skill skill);
	public List<MitarbeiterSkill> findByMitarbeiter (Mitarbeiter mitarbeiter);
	public List<MitarbeiterSkill> findBySkill (Skill skill);
	public Long countBySkill(Skill skill);
	public List<MitarbeiterSkill> findBySkillAndMasterBewertungGreaterThanEqualOrderByMasterBewertungDesc(Skill skill, Integer masterBewertung );
	public MitarbeiterSkill findByMitarbeiterAndSkill (Mitarbeiter mitarbeiter, Skill skill);
	public Integer deleteBySkill (Skill skill);
	public Integer deleteByMitarbeiter (Mitarbeiter mitarbeiter);
	
	

}

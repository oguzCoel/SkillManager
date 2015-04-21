package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;

public interface MitarbeiterSkillService {
	
	public MitarbeiterSkill save (MitarbeiterSkill mitarbeiterSkill);
	public List<MitarbeiterSkill>findAll();
	public List<MitarbeiterSkill> findByMitarbeiterOrderByMasterBewertungDesc (Mitarbeiter mitarbeiter);
	public List<MitarbeiterSkill> findByMitarbeiterOrderBySelbstBewertungDesc (Mitarbeiter mitarbeiter);
 
}

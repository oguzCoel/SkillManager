package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.SkillMaster;

public interface SkillMasterService {
	
	public List<SkillMaster> findByMitarbeiter (Mitarbeiter mitarbeiter);

}

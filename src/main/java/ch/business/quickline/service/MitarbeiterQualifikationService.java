package ch.business.quickline.service;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterQualifikation;
import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.domain.Skill;

public interface MitarbeiterQualifikationService {
	
	public MitarbeiterQualifikation save (MitarbeiterQualifikation mitarbeiterQualifikation);
	public void deleteByMitarbeiter (Mitarbeiter mitarbeiter);
	public void deleteByQualifikation (Qualifikation qualifikation);

}

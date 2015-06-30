package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterQualifikation;
import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.domain.Skill;

public interface MitarbeiterQualifikationRepository extends	JpaRepository<MitarbeiterQualifikation, Integer> {
	
	public Integer deleteByMitarbeiter (Mitarbeiter mitarbeiter);
	public Integer deleteByQualifikation (Qualifikation qualifikation);

}

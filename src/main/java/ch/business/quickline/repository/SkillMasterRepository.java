package ch.business.quickline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.SkillMaster;

public interface SkillMasterRepository extends JpaRepository <SkillMaster, Integer> {
	
	public List<SkillMaster> findByMitarbeiter(Mitarbeiter mitarbeiter);

}

package ch.business.quickline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;

public interface MitarbeiterSkillRepository extends JpaRepository<MitarbeiterSkill, Integer> {
	
	public List<MitarbeiterSkill> findByMitarbeiter(Mitarbeiter mitarbeiter);

}

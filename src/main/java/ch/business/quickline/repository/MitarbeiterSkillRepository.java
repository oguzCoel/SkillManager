package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.business.quickline.domain.MitarbeiterSkill;

public interface MitarbeiterSkillRepository extends JpaRepository<MitarbeiterSkill, Integer> {

}

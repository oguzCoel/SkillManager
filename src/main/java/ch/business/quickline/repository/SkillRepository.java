package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
	
	public Skill findBySkillId(Integer id);

}

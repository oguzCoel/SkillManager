package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Skill;
import ch.business.quickline.repository.SkillRepository;

@Service("skillService")
@Transactional
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillRepository skillRepository;

	public Skill save(Skill skill) {
		
		return skillRepository.save(skill);
	}

}

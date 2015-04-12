package ch.business.quickline.service;

import java.util.List;

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
	
	public List<Skill>findAll(){
		
		return skillRepository.findAll();
	}

}

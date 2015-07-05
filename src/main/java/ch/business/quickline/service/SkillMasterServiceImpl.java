package ch.business.quickline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.domain.SkillMaster;
import ch.business.quickline.repository.SkillMasterRepository;

@Service("skillMasterService")
@Transactional
public class SkillMasterServiceImpl implements SkillMasterService {
	
	@Autowired
	private SkillMasterRepository skillMasterRepository;

	public List<SkillMaster> findByMitarbeiter(Mitarbeiter mitarbeiter) {
	
		return skillMasterRepository.findByMitarbeiter(mitarbeiter);
	}
	
	public SkillMaster save (SkillMaster skillMaster){
		
		return skillMasterRepository.save(skillMaster);
	}
	
	public SkillMaster findBySkill (Skill skill){
		
		return skillMasterRepository.findBySkill(skill);
	}

	
	public void deleteByMitarbeiter (Mitarbeiter mitarbeiter){
		
		skillMasterRepository.deleteByMitarbeiter(mitarbeiter);
	}
	
	public void deleteBySkill(Skill skill){
		
		skillMasterRepository.deleteBySkill(skill);
	}
}

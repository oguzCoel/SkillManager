package ch.business.quickline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.repository.MitarbeiterSkillRepository;

@Service("mitarbeiterSkillService")
@Transactional
public class MitarbeiterSkillServiceImpl implements MitarbeiterSkillService {

	@Autowired
	MitarbeiterSkillRepository mitarbeiterSkillRepository;
	
	public MitarbeiterSkill save(MitarbeiterSkill mitarbeiterSkill) {
		
		return mitarbeiterSkillRepository.save(mitarbeiterSkill);
	}
	
	public List<MitarbeiterSkill> findAll(){
		return mitarbeiterSkillRepository.findAll();
	}

}

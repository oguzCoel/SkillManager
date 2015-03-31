package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.SkillMaster;
import ch.business.quickline.repository.SkillMasterRepository;

@Service ("skillMasterService")
@Transactional
public class SkillMasterServiceImpl implements SkillMasterService {
	
	@Autowired
	SkillMasterRepository skillMasterRepository;

	public SkillMaster save(SkillMaster skillMaster) {
		
		return skillMasterRepository.save(skillMaster);
	}

}

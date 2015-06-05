package ch.business.quickline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;
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
	
	public List<MitarbeiterSkill> findByMitarbeiterOrderByMasterBewertungDesc(Mitarbeiter mitarbeiter){
		return mitarbeiterSkillRepository.findByMitarbeiterOrderByMasterBewertungDesc(mitarbeiter);
	}
	
	public List<MitarbeiterSkill> findByMitarbeiterOrderBySelbstBewertungDesc(Mitarbeiter mitarbeiter){
		return mitarbeiterSkillRepository.findByMitarbeiterOrderBySelbstBewertungDesc(mitarbeiter);
	}
	
	
	public List<MitarbeiterSkill> findBySkillOrderByMasterBewertungDesc (Skill skill){
		return mitarbeiterSkillRepository.findBySkillOrderByMasterBewertungDesc(skill);
	}
	
	
	public List<MitarbeiterSkill> findBySkillOrderBySelbstBewertungDesc (Skill skill){
		return mitarbeiterSkillRepository.findBySkillOrderBySelbstBewertungDesc(skill);
	}
	
	public Double retrieveMasterBewertungGlobalAverage(){
	    	Double sum = 0.0;
	    	for (MitarbeiterSkill skill: findAll()){
	    		sum = sum + skill.getMasterBewertung();
	    	}
	    	
	    	return sum / findAll().size();
	}
	
	
	 public Double retrieveSelbstBewertungGlobalAverage(){
	    	Double sum =0.0;
	    	for(MitarbeiterSkill interest: findAll()){
	    		sum = sum + interest.getSelbstBewertung();
	    	}
	    	
	    	return sum / findAll().size();
	}
	 
	 
	public Long countBySkill (Skill skill){
		
		return mitarbeiterSkillRepository.countBySkill(skill);
	}
	
	
	

	public List<MitarbeiterSkill> findBySkillAndMasterBewertungGreaterThanEqualOrderByMasterBewertung(
			Skill skill, Integer masterBewertung) {
		return mitarbeiterSkillRepository.findBySkillAndMasterBewertungGreaterThanEqualOrderByMasterBewertungDesc(skill, masterBewertung);
	}
	
	public MitarbeiterSkill findByMitarbeiterAndSkill (Mitarbeiter mitarbeiter, Skill skill){
		
		return mitarbeiterSkillRepository.findByMitarbeiterAndSkill(mitarbeiter, skill);
	}

	
	

}

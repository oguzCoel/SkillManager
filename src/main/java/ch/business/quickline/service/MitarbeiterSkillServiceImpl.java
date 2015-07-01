package ch.business.quickline.service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
public class MitarbeiterSkillServiceImpl implements MitarbeiterSkillService{

	@Autowired
	MitarbeiterSkillRepository mitarbeiterSkillRepository;
	
	@Autowired
	MitarbeiterService mitarbeiterService;
	
	@Autowired
	SkillService skillService;
	
	public void save(MitarbeiterSkill mitarbeiterSkill){
		
		
	try { 
		
		if(mitarbeiterSkill.getMasterBewertung()==null){
			mitarbeiterSkill.setMasterBewertung(0);
		}
		
		else {
			mitarbeiterSkill.setSelbstBewertung(0);
		}
		
		
		}
		catch (NullPointerException ex){
			ex.printStackTrace();
		}
		
	mitarbeiterSkillRepository.save(mitarbeiterSkill);
	
	triggerMitarbeiterAfterSave(mitarbeiterSkill);
	triggerSkillAfterSave(mitarbeiterSkill);
		

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
	
	public List<MitarbeiterSkill> findByMitarbeiter (Mitarbeiter mitarbeiter){
		return mitarbeiterSkillRepository.findByMitarbeiter(mitarbeiter);
	}
	
	public List<MitarbeiterSkill> findBySkill (Skill skill){
		return mitarbeiterSkillRepository.findBySkill(skill);
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

	
	public void triggerMitarbeiterAfterSave(MitarbeiterSkill mitarbeiterSkill){
		Double masterBewertungSum = 0.0;
		Double masterBewertungAvg; 
		Double selbstBewertungSum = 0.0;
		Double selbstBewertungAvg;
		
		List<MitarbeiterSkill> mitarbeiterSkillList = findByMitarbeiter(mitarbeiterSkill.getMitarbeiter());
		
		for (MitarbeiterSkill mskill : mitarbeiterSkillList){
			
			masterBewertungSum = masterBewertungSum + mskill.getMasterBewertung();
		}

		masterBewertungAvg= masterBewertungSum / mitarbeiterSkillList.size();
		mitarbeiterSkill.getMitarbeiter().setMitarbeiterMasterBewertungDurchschnitt(masterBewertungAvg);
		
		for (MitarbeiterSkill mskill : mitarbeiterSkillList){
			
			selbstBewertungSum = selbstBewertungSum + mskill.getSelbstBewertung();
		}
		
		selbstBewertungAvg = (selbstBewertungSum / mitarbeiterSkillList.size());
		mitarbeiterSkill.getMitarbeiter().setMitarbeiterSelbstBewertungDurchschnitt(selbstBewertungAvg);
		
		mitarbeiterService.save(mitarbeiterSkill.getMitarbeiter());
	}
	
	
	public void triggerSkillAfterSave(MitarbeiterSkill mitarbeiterSkill){
		Double masterBewertungSum = 0.0;
		Double masterBewertungAvg; 
		Double selbstBewertungSum = 0.0;
		Double selbstBewertungAvg;
		
		List<MitarbeiterSkill> mitarbeiterSkillList = findBySkill(mitarbeiterSkill.getSkill());
		
		for (MitarbeiterSkill mskill : mitarbeiterSkillList){
			
			masterBewertungSum = masterBewertungSum + mskill.getMasterBewertung();
		}

		masterBewertungAvg= masterBewertungSum / mitarbeiterSkillList.size();
		mitarbeiterSkill.getSkill().setSkillMasterBewertungDurchschnitt(masterBewertungAvg);
		
		for (MitarbeiterSkill mskill : mitarbeiterSkillList){
			
			selbstBewertungSum = selbstBewertungSum + mskill.getSelbstBewertung();
		}
		
		selbstBewertungAvg = (selbstBewertungSum / mitarbeiterSkillList.size());
		mitarbeiterSkill.getSkill().setSkillSelbstBewertungDurchschnitt(selbstBewertungAvg);
		
		skillService.save(mitarbeiterSkill.getSkill());
	}
	
	
	public void deleteByMitarbeiter (Mitarbeiter mitarbeiter){
		
		mitarbeiterSkillRepository.deleteByMitarbeiter(mitarbeiter);
	}
	
	public void deleteBySkill (Skill skill){
		
		mitarbeiterSkillRepository.deleteBySkill(skill);
	}

}

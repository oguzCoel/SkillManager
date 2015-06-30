package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterQualifikation;
import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.repository.MitarbeiterQualifikationRepository;

@Service ("mitarbeiterQualifikationService")
@Transactional
public class MitarbeiterQualifikationServiceImpl implements
		MitarbeiterQualifikationService {

	@Autowired
	MitarbeiterQualifikationRepository mitarbeiterQualifikationRepository;
	
	public MitarbeiterQualifikation save(MitarbeiterQualifikation mitarbeiterQualifikation) {
		return mitarbeiterQualifikationRepository.save(mitarbeiterQualifikation);

	}
	
	public void deleteByMitarbeiter (Mitarbeiter mitarbeiter){
		
		mitarbeiterQualifikationRepository.deleteByMitarbeiter(mitarbeiter);
	}
	
	public void deleteByQualifikation (Qualifikation qualifikation){
		
		mitarbeiterQualifikationRepository.deleteByQualifikation(qualifikation);
	}

}

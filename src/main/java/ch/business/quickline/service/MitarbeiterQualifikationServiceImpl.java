package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;

import ch.business.quickline.domain.MitarbeiterQualifikation;
import ch.business.quickline.repository.MitarbeiterQualifikationRepository;

public class MitarbeiterQualifikationServiceImpl implements
		MitarbeiterQualifikationService {

	@Autowired
	MitarbeiterQualifikationRepository mitarbeiterQualifikationRepository;
	
	public MitarbeiterQualifikation save(MitarbeiterQualifikation mitarbeiterQualifikation) {
		return mitarbeiterQualifikationRepository.save(mitarbeiterQualifikation);

	}

}

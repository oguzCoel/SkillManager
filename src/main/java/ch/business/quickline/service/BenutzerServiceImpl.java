package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.repository.BenutzerRepository;

@Service("benutzerService")
@Transactional
public class BenutzerServiceImpl implements BenutzerService {

	@Autowired
	BenutzerRepository benutzerRepository;
	
	public Benutzer save(Benutzer benutzer) {
		
		return benutzerRepository.save(benutzer);
	}
	
	public Benutzer findByBenutzerName(String benutzerName){
		
		return benutzerRepository.findByBenutzerName(benutzerName);
	}

}

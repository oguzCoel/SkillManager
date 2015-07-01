package ch.business.quickline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.Mitarbeiter;
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
	
	public Benutzer findByMitarbeiter(Mitarbeiter mitarbeiter){
		
		return benutzerRepository.findByMitarbeiter(mitarbeiter);
	}

	
	public void deleteByMitarbeiter (Mitarbeiter mitarbeiter){
		
		benutzerRepository.deleteByMitarbeiter(mitarbeiter);
	}
	
	public List<Benutzer> findAll(){
		
		return benutzerRepository.findAll();
	}
}

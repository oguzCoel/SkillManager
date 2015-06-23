package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.BenutzerRole;
import ch.business.quickline.repository.BenutzerRoleRepository;

@Service("benutzerRoleService")
@Transactional
public class BenutzerRoleServiceImpl implements BenutzerRoleService {
	
	@Autowired
	BenutzerRoleRepository benutzerRoleRepository;

	public BenutzerRole save(BenutzerRole benutzerRole) {
		
		return benutzerRoleRepository.save(benutzerRole);
	}

	
	public BenutzerRole findByBenutzer(Benutzer benutzer){
		
		return benutzerRoleRepository.findByBenutzer(benutzer);
	}
}

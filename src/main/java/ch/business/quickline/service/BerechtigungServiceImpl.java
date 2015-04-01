package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Berechtigung;
import ch.business.quickline.repository.BerechtigungRepository;

@Service("berechtigungService")
@Transactional
public class BerechtigungServiceImpl implements BerechtigungService {

	@Autowired
	BerechtigungRepository berechtigungRepository;
	
	public Berechtigung save(Berechtigung berechtigung) {
		
		return berechtigungRepository.save(berechtigung);
	}

}

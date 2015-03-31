package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.repository.MitarbeiterRepository;

@Service("mitarbeiterService")
@Transactional
public class MitarbeiterServiceImpl implements MitarbeiterService {
	
	@Autowired
	MitarbeiterRepository mitarbeiterRepository;

	public Mitarbeiter save(Mitarbeiter mitarbeiter) {
		
		return mitarbeiterRepository.save(mitarbeiter);
	}

}

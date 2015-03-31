package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Gruppe;
import ch.business.quickline.repository.GruppeRepository;

@Service ("gruppeService")
@Transactional
public class GruppeServiceImpl implements GruppeService {
	
	@Autowired
	GruppeRepository gruppeRepository;

	public Gruppe save(Gruppe gruppe) {
		
		return gruppeRepository.save(gruppe);
	}

}

package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Projekt;
import ch.business.quickline.repository.ProjektRepository;

@Service("projektService")
@Transactional
public class ProjektServiceImpl implements ProjektService {
	
	@Autowired
	ProjektRepository projektRepository;

	public Projekt save(Projekt projekt) {
		
		return projektRepository.save(projekt);
	}

}

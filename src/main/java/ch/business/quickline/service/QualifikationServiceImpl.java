package ch.business.quickline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.repository.QualifikationRepository;

@Service("qualifikationService")
@Transactional
public class QualifikationServiceImpl implements QualifikationService {

	@Autowired
	QualifikationRepository qualifikationRepository;
	public Qualifikation save(Qualifikation qualifikation) {
		
		return qualifikationRepository.save(qualifikation);
	}
	
	public List<Qualifikation>findAll(){
		
		return qualifikationRepository.findAll();
	}
	
	public Qualifikation findByQualifikationId(Integer id){
		
		return qualifikationRepository.findByQualifikationId(id);
	}
	
}

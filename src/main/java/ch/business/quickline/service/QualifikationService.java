package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Qualifikation;

public interface QualifikationService {
	
	public Qualifikation save (Qualifikation qualifikation);
	public List<Qualifikation> findAll();
	public Qualifikation findByQualifikationId(Integer id);

}

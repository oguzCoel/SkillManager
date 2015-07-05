package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Qualifikation;

public interface QualifikationRepository extends JpaRepository<Qualifikation, Integer> {
	
	public Qualifikation findByQualifikationId(Integer id);
	public Integer deleteByQualifikationId(Integer id);

}

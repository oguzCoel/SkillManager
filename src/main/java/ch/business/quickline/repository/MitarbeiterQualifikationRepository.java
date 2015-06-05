package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.MitarbeiterQualifikation;

public interface MitarbeiterQualifikationRepository extends	JpaRepository<MitarbeiterQualifikation, Integer> {

}

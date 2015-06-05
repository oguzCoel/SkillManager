package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Mitarbeiter;

public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Integer> {
	
	public Mitarbeiter findByMitarbeiterId(Integer id);
	public long count ();
	

}

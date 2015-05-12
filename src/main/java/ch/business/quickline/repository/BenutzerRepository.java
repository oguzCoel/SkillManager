package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.business.quickline.domain.Benutzer;

public interface BenutzerRepository extends JpaRepository<Benutzer, Integer> {
	
	public Benutzer findByBenutzerName(String benutzerName);

}

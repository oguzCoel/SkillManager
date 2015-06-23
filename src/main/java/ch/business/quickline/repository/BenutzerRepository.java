package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.Mitarbeiter;

public interface BenutzerRepository extends JpaRepository<Benutzer, Integer> {
	
	public Benutzer findByBenutzerName(String benutzerName);
	public Benutzer findByMitarbeiter (Mitarbeiter mitarbeiter);

}

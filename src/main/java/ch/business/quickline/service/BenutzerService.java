package ch.business.quickline.service;

import ch.business.quickline.domain.Benutzer;

public interface BenutzerService {
	
	public Benutzer save (Benutzer benutzer);
	public Benutzer findByBenutzerName(String benutzername);

}

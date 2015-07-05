package ch.business.quickline.service;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.BenutzerRole;

public interface BenutzerRoleService {
	
	public BenutzerRole save (BenutzerRole benutzerRole);	
	public BenutzerRole findByBenutzer(Benutzer benutzer);
	public void deleteByBenutzer (Benutzer benutzer);

}

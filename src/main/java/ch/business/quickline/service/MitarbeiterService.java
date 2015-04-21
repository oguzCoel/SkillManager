package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Mitarbeiter;

public interface MitarbeiterService {
	public Mitarbeiter save (Mitarbeiter mitarbeiter);
	public List<Mitarbeiter> mitarbeiterMasterBewertungRangliste();
	public List<Mitarbeiter> mitarbeiterSelbstBewertungRangliste();
	public Mitarbeiter findByMitarbeiterId(Integer id);
	


}

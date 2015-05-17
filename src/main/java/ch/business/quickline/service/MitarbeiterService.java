package ch.business.quickline.service;

import java.math.BigDecimal;
import java.util.List;

import ch.business.quickline.domain.Mitarbeiter;

public interface MitarbeiterService {
	public void save (Mitarbeiter mitarbeiter);
	public List<Mitarbeiter> findAll();
	public List<Mitarbeiter> mitarbeiterMasterBewertungRangliste();
	public List<Mitarbeiter> mitarbeiterSelbstBewertungRangliste();
	public Mitarbeiter findByMitarbeiterId(Integer id);
	public BigDecimal retrieveMasterBewertungDurchschnitt(Integer id);
	public BigDecimal retrieveSelbstBewertungDurchschnitt(Integer id);
	


}

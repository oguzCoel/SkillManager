package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Abteilung;

public interface AbteilungService {

	public Abteilung save(Abteilung abteilung);
	public List<Abteilung> findALL();

}

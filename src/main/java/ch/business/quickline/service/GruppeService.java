package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Gruppe;

public interface GruppeService {
	public Gruppe save (Gruppe gruppe);
	public List<Gruppe> findAll();

}

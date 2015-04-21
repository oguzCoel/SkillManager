package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.service.MitarbeiterService;


@ManagedBean
@Component
@ViewScoped
public class RankingDataList {
	
	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	private List<Mitarbeiter>mitarbeiterMasterBewertungRangliste;
	private List<Mitarbeiter> mitarbeiterSelbstBewertungRangliste;
	
	@PostConstruct
	public void init (){
		mitarbeiterMasterBewertungRangliste = mitarbeiterService.mitarbeiterMasterBewertungRangliste();
		mitarbeiterSelbstBewertungRangliste = mitarbeiterService.mitarbeiterSelbstBewertungRangliste();
	}

	public MitarbeiterService getMitarbeiterService() {
		return mitarbeiterService;
	}

	public void setMitarbeiterService(MitarbeiterService mitarbeiterService) {
		this.mitarbeiterService = mitarbeiterService;
	}

	public List<Mitarbeiter> getMitarbeiterMasterBewertungRangliste() {
		return mitarbeiterMasterBewertungRangliste;
	}

	public void setMitarbeiterMasterBewertungRangliste(
			List<Mitarbeiter> mitarbeiterMasterBewertungRangliste) {
		this.mitarbeiterMasterBewertungRangliste = mitarbeiterMasterBewertungRangliste;
	}

	public List<Mitarbeiter> getMitarbeiterSelbstBewertungRangliste() {
		return mitarbeiterSelbstBewertungRangliste;
	}

	public void setMitarbeiterSelbstBewertungRangliste(
			List<Mitarbeiter> mitarbeiterSelbstBewertungRangliste) {
		this.mitarbeiterSelbstBewertungRangliste = mitarbeiterSelbstBewertungRangliste;
	}

		

}

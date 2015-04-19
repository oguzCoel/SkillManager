package ch.business.quickline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.repository.MitarbeiterRepository;

@Service("mitarbeiterService")
@Transactional
public class MitarbeiterServiceImpl implements MitarbeiterService {
	
	@Autowired
	MitarbeiterRepository mitarbeiterRepository;

	public Mitarbeiter save(Mitarbeiter mitarbeiter) {
		
		return mitarbeiterRepository.save(mitarbeiter);
	}
	
	public List<Mitarbeiter> mitarbeiterMasterBewertungRangliste(){
		
		return mitarbeiterRepository.findAll(sortBymitarbeiterMasterBewertungDurchschnittDesc());
	}
	
	public List<Mitarbeiter> mitarbeiterSelbstBewertungRangliste(){
		
		return mitarbeiterRepository.findAll(sortBymitarbeiterSelbstBewertungDurchschnittDesc());
	}
	
	private Sort sortBymitarbeiterMasterBewertungDurchschnittDesc() {
        return new Sort(Sort.Direction.DESC, "mitarbeiterMasterBewertungDurchschnitt");
    }
	
	private Sort sortBymitarbeiterSelbstBewertungDurchschnittDesc() {
        return new Sort(Sort.Direction.DESC, "mitarbeiterSelbstBewertungDurchschnitt");
    }
	

	public Mitarbeiter findByMitarbeiterId(Integer id){
		return mitarbeiterRepository.findByMitarbeiterId(1);
	}
	
	
	
	

}

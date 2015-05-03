package ch.business.quickline.service;

import java.math.BigDecimal;
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
	
	public List<Mitarbeiter> findAll(){
		
		return mitarbeiterRepository.findAll();
	}
	
	public List<Mitarbeiter> mitarbeiterMasterBewertungRangliste(){
		
		return mitarbeiterRepository.findAll(sortBymitarbeiterMasterBewertungDurchschnittDesc());
	}
	
	public List<Mitarbeiter> mitarbeiterSelbstBewertungRangliste(){
		
		return mitarbeiterRepository.findAll(sortBymitarbeiterSelbstBewertungDurchschnittDesc());
	}
	
	public Sort sortBymitarbeiterMasterBewertungDurchschnittDesc() {
        return new Sort(Sort.Direction.DESC, "mitarbeiterMasterBewertungDurchschnitt");
    }
	
	public Sort sortBymitarbeiterSelbstBewertungDurchschnittDesc() {
        return new Sort(Sort.Direction.DESC, "mitarbeiterSelbstBewertungDurchschnitt");
    }
	

	public Mitarbeiter findByMitarbeiterId(Integer id){
		return mitarbeiterRepository.findByMitarbeiterId(id);
	}
	
	public BigDecimal retrieveMasterBewertungDurchschnitt(Integer id){
	    	BigDecimal average = findByMitarbeiterId(id).getMitarbeiterMasterBewertungDurchschnitt();
	    	
	    	return average;
	}
	
	public BigDecimal retrieveSelbstBewertungDurchschnitt(Integer id){
	    	BigDecimal average = findByMitarbeiterId(id).getMitarbeiterSelbstBewertungDurchschnitt();
	    	
	    	return average;
	}
	
	
	
	
	
	
	

}

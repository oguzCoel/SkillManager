package ch.business.quickline.viewservice;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;

@ManagedBean(name = "mitarbeiterGlobalService")
@Component
@ApplicationScoped
public class MitarbeiterGlobalService implements Serializable {
	
	@Autowired 
	private MitarbeiterService mitarbeiterService;
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	private BigDecimal masterBewertungIndividualAverage;
	private BigDecimal selbstBewertungIndividualAverage;
	private Double masterBewertungGlobalAverage;
	private Double selbstBewertungGlobalAverage;
	
	public void init(){
		masterBewertungIndividualAverage = mitarbeiterService.findByMitarbeiterId(1).getMitarbeiterMasterBewertungDurchschnitt();
		selbstBewertungIndividualAverage = mitarbeiterService.findByMitarbeiterId(1).getMitarbeiterSelbstBewertungDurchschnitt();
		masterBewertungGlobalAverage = retrieveMasterBewertungGlobalAverage();
		selbstBewertungGlobalAverage = retrieveSelbstBewertungGlobalAverage();
	}
	
	
    

    
    
    public BigDecimal getMasterBewertungIndividualAverage() {
		return masterBewertungIndividualAverage;
	}






	public void setMasterBewertungIndividualAverage(
			BigDecimal masterBewertungIndividualAverage) {
		this.masterBewertungIndividualAverage = masterBewertungIndividualAverage;
	}






	public BigDecimal getSelbstBewertungIndividualAverage() {
		return selbstBewertungIndividualAverage;
	}






	public void setSelbstBewertungIndividualAverage(
			BigDecimal selbstBewertungIndividualAverage) {
		this.selbstBewertungIndividualAverage = selbstBewertungIndividualAverage;
	}






	public Double getMasterBewertungGlobalAverage() {
		return masterBewertungGlobalAverage;
	}






	public void setMasterBewertungGlobalAverage(Double masterBewertungGlobalAverage) {
		this.masterBewertungGlobalAverage = masterBewertungGlobalAverage;
	}






	public Double getSelbstBewertungGlobalAverage() {
		return selbstBewertungGlobalAverage;
	}






	public void setSelbstBewertungGlobalAverage(Double selbstBewertungGlobalAverage) {
		this.selbstBewertungGlobalAverage = selbstBewertungGlobalAverage;
	}






	public Double retrieveMasterBewertungGlobalAverage(){
    	Double sum = 0.0;
    	for (MitarbeiterSkill skill: mitarbeiterSkillService.findAll()){
    		sum = sum + skill.getMasterBewertung();
    	}
    	
    	return sum / mitarbeiterSkillService.findAll().size();
    }
    
    
    public Double retrieveSelbstBewertungGlobalAverage(){
    	Double sum =0.0;
    	for(MitarbeiterSkill interest: mitarbeiterSkillService.findAll()){
    		sum = sum + interest.getSelbstBewertung();
    	}
    	
    	return sum / mitarbeiterSkillService.findAll().size();
    }

}

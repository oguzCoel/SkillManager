package ch.business.quickline.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;

@ManagedBean
@Component
@ViewScoped
public class MeterGaugeChartView {
	
	@Autowired
	MitarbeiterService mitarbeiterService;
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	private MeterGaugeChartModel masterBewertungenIndividual;
    private MeterGaugeChartModel selbstBewertungenIndividual;
    private MeterGaugeChartModel masterBewertungenGlobal;
    private MeterGaugeChartModel selbstBewertungenGlobal;
 
    @PostConstruct
    public void init() {
        createMeterGaugeModels();
    }
 
    public MeterGaugeChartModel getMasterBewertungenIndividual() {
        return masterBewertungenIndividual;
    }
     
    public MeterGaugeChartModel getSelbstBewertungenIndividual() {
        return selbstBewertungenIndividual;
    }
    
    public MeterGaugeChartModel getMasterBewertungenGlobal() {
        return masterBewertungenGlobal;
    }
     
    public MeterGaugeChartModel getSelbstBewertungenGlobal() {
        return selbstBewertungenGlobal;
    }
 
    private MeterGaugeChartModel initMeterGaugeModel() {
        List<Number> intervals = new ArrayList<Number>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
         
        return new MeterGaugeChartModel(5, intervals);
    }
 
    private void createMeterGaugeModels() {
        masterBewertungenIndividual = initMeterGaugeModel();
        //masterBewertungenIndividual.setTitle("Masterbewertungen");
        masterBewertungenIndividual.setGaugeLabel("Skill");
        masterBewertungenIndividual.setValue(getMasterBewertungIndividualAverage());
        
         
        selbstBewertungenIndividual = initMeterGaugeModel();
        //selbstBewertungenIndividual.setTitle("Selbstbewertungen");
        selbstBewertungenIndividual.setGaugeLabel("Interesse");
        selbstBewertungenIndividual.setValue(getMasterSelbstBewertungIndividualAverage());
        
        
        masterBewertungenGlobal = initMeterGaugeModel();
        //masterBewertungenGlobal.setTitle("Masterbewertungen");
        masterBewertungenGlobal.setGaugeLabel("Skill");
        masterBewertungenGlobal.setValue(getMasterBewertungGlobalAverage());
        
        selbstBewertungenGlobal = initMeterGaugeModel();
        //selbstBewertungenGlobal.setTitle("Selbstbewertungen");
        selbstBewertungenGlobal.setGaugeLabel("Interesse");
        selbstBewertungenGlobal.setValue(getSelbstBewertungGlobalAverage());
    }
    
    @PostConstruct
    private BigDecimal getMasterBewertungIndividualAverage(){
    	BigDecimal average = mitarbeiterService.findByMitarbeiterId(1).getMitarbeiterSelbstBewertungDurchschnitt();
    	
    	return average;
}
    
    @PostConstruct
    private BigDecimal getMasterSelbstBewertungIndividualAverage(){
    	BigDecimal average = mitarbeiterService.findByMitarbeiterId(1).getMitarbeiterSelbstBewertungDurchschnitt();
    	
    	return average;
}
    
    @PostConstruct
    private Double getMasterBewertungGlobalAverage(){
    	Double sum = 0.0;
    	for (MitarbeiterSkill skill: mitarbeiterSkillService.findAll()){
    		sum = sum + skill.getMasterBewertung();
    	}
    	
    	return sum / mitarbeiterSkillService.findAll().size();
    }
    
    @PostConstruct
    private Double getSelbstBewertungGlobalAverage(){
    	Double sum =0.0;
    	for(MitarbeiterSkill interest: mitarbeiterSkillService.findAll()){
    		sum = sum + interest.getSelbstBewertung();
    	}
    	
    	return sum / mitarbeiterSkillService.findAll().size();
    }

}

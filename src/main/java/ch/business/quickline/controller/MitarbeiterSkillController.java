package ch.business.quickline.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.service.MitarbeiterSkillService;
 
@ManagedBean
@Component
@ViewScoped
public class MitarbeiterSkillController  {
	
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
 
    private MeterGaugeChartModel masterBewertungen;
    private MeterGaugeChartModel selbstBewertungen;
   
 
    @PostConstruct
    public void init() {
        createMeterGaugeModels();
    }
 
    public MeterGaugeChartModel getMasterBewertungen() {
        return masterBewertungen;
    }
    
    public MeterGaugeChartModel getSelbstBewertungen(){
    	return selbstBewertungen;
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
    
    @PostConstruct
    private Double getMasterBewertungAverage(){
    	Double sum = 0.0;
    	for (MitarbeiterSkill skill: mitarbeiterSkillService.findAll()){
    		sum = sum + skill.getMasterBewertung();
    	}
    	
    	return sum / mitarbeiterSkillService.findAll().size();
    }
    
    @PostConstruct
    private Double getSelbstBewertungAverage(){
    	Double sum =0.0;
    	for(MitarbeiterSkill interest: mitarbeiterSkillService.findAll()){
    		sum = sum + interest.getSelbstBewertung();
    	}
    	
    	return sum / mitarbeiterSkillService.findAll().size();
    }
 
    private void createMeterGaugeModels() {
        masterBewertungen = initMeterGaugeModel();
        masterBewertungen.setTitle("Masterbewertungen");
        masterBewertungen.setGaugeLabel("Skill");
        masterBewertungen.setValue(getMasterBewertungAverage());
        
        selbstBewertungen = initMeterGaugeModel();
        selbstBewertungen.setTitle("Selbstbewertungen");
        selbstBewertungen.setGaugeLabel("Interesse");
        selbstBewertungen.setValue(getSelbstBewertungAverage());
         
     
    }
 
}
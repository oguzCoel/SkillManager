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
 
    private MeterGaugeChartModel meterGaugeModel1;
   
 
    @PostConstruct
    public void init() {
        createMeterGaugeModels();
    }
 
    public MeterGaugeChartModel getMeterGaugeModel1() {
        return meterGaugeModel1;
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
    private Double getSkillBewertungAverage(){
    	Double sum = 0.0;
    	for (MitarbeiterSkill skill: mitarbeiterSkillService.findAll()){
    		sum = sum + skill.getMasterBewertung();
    	}
    	
    	return sum / mitarbeiterSkillService.findAll().size();
    }
 
    private void createMeterGaugeModels() {
        meterGaugeModel1 = initMeterGaugeModel();
        meterGaugeModel1.setTitle("Masterbewertungen");
        meterGaugeModel1.setGaugeLabel("Skill");
        meterGaugeModel1.setValue(getSkillBewertungAverage());
         
     
    }
 
}
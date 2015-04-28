package ch.business.quickline.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
    private MeterGaugeChartModel masterBewertungenGlobal;
    private MeterGaugeChartModel selbstBewertungenGlobal;
   
    
 
    @PostConstruct
    public void init() {
        createMeterGaugeModels();
        
    }
    

    
    public MeterGaugeChartModel getMasterBewertungenGlobal() {
        return masterBewertungenGlobal;
    }
     
    public MeterGaugeChartModel getSelbstBewertungenGlobal() {
        return selbstBewertungenGlobal;
    }
 
    public MeterGaugeChartModel initMeterGaugeModel() {
        List<Number> intervals = new ArrayList<Number>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
         
        return new MeterGaugeChartModel(5, intervals);
    }
 
    public void createMeterGaugeModels() {    
        
        masterBewertungenGlobal = initMeterGaugeModel();
        //masterBewertungenGlobal.setTitle("Masterbewertungen");
        masterBewertungenGlobal.setGaugeLabel("Skill");
        masterBewertungenGlobal.setValue(mitarbeiterSkillService.retrieveMasterBewertungGlobalAverage());
        
        selbstBewertungenGlobal = initMeterGaugeModel();
        //selbstBewertungenGlobal.setTitle("Selbstbewertungen");
        selbstBewertungenGlobal.setGaugeLabel("Interesse");
        selbstBewertungenGlobal.setValue(mitarbeiterSkillService.retrieveSelbstBewertungGlobalAverage());
    }
    
  
  
    
    
   

}

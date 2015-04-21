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
import ch.business.quickline.service.MitarbeiterService;

@ManagedBean
@Component
@ViewScoped
public class MitarbeiterIndividualController {
	
	@Autowired
	MitarbeiterService mitarbeiterService;
	
	private MeterGaugeChartModel masterBewertungen;
    private MeterGaugeChartModel selbstBewertungen;

 
    @PostConstruct
    public void init() {
        createMeterGaugeModels();
    }
    
    
 
    public MeterGaugeChartModel getMasterBewertungen() {
        return masterBewertungen;
    }
     
    public MeterGaugeChartModel getSelbstBewertungen() {
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
 
    private void createMeterGaugeModels() {
        masterBewertungen = initMeterGaugeModel();
        masterBewertungen.setTitle("Masterbewertungen");
        masterBewertungen.setGaugeLabel("Skill");
        masterBewertungen.setValue(getMasterBewertungDurchschnitt());
        
         
        selbstBewertungen = initMeterGaugeModel();
        selbstBewertungen.setTitle("Selbstbewertungen");
        selbstBewertungen.setGaugeLabel("Interesse");
        selbstBewertungen.setValue(getMasterSelbstBewertungDurchschnitt());
    }
    
    @PostConstruct
    private BigDecimal getMasterBewertungDurchschnitt(){
    	BigDecimal average = mitarbeiterService.findByMitarbeiterId(1).getMitarbeiterSelbstBewertungDurchschnitt();
    	
    	return average;
}
    
    @PostConstruct
    private BigDecimal getMasterSelbstBewertungDurchschnitt(){
    	BigDecimal average = mitarbeiterService.findByMitarbeiterId(1).getMitarbeiterSelbstBewertungDurchschnitt();
    	
    	return average;
}

}

package ch.business.quickline.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillService;

@ManagedBean
@Component
@ViewScoped
public class UnternehmenViewController {
	
	@Autowired
	MitarbeiterService mitarbeiterService;
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	@Autowired
	private SkillService skillService;
	
	
    private MeterGaugeChartModel masterBewertungenGlobal;
    private MeterGaugeChartModel selbstBewertungenGlobal;
	private List<Mitarbeiter>mitarbeiterMasterBewertungRangliste;
	private List<Mitarbeiter> mitarbeiterSelbstBewertungRangliste;
	private String masterBewertungAverage;
	private String selbstBewertungAverage;
	private long mitarbeiterCount;
	private long skillCount;
	
	private DecimalFormat df = new DecimalFormat("#.###");

    
   
    
 
    @PostConstruct
    public void init() {
        createMeterGaugeModels();
        mitarbeiterMasterBewertungRangliste = mitarbeiterService.mitarbeiterMasterBewertungRangliste();
		mitarbeiterSelbstBewertungRangliste = mitarbeiterService.mitarbeiterSelbstBewertungRangliste();
		masterBewertungAverage = df.format(mitarbeiterSkillService.retrieveMasterBewertungGlobalAverage());
		selbstBewertungAverage = df.format(mitarbeiterSkillService.retrieveSelbstBewertungGlobalAverage());
		mitarbeiterCount = mitarbeiterService.count();
		skillCount = skillService.count();
        
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
        masterBewertungenGlobal.setTitle("Masterbewertungen");
        masterBewertungenGlobal.setGaugeLabel("Skill");
        masterBewertungenGlobal.setValue(mitarbeiterSkillService.retrieveMasterBewertungGlobalAverage());
        
        selbstBewertungenGlobal = initMeterGaugeModel();
        selbstBewertungenGlobal.setTitle("Selbstbewertungen");
        selbstBewertungenGlobal.setGaugeLabel("Interesse");
        selbstBewertungenGlobal.setValue(mitarbeiterSkillService.retrieveSelbstBewertungGlobalAverage());
        
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



	public String getMasterBewertungAverage() {
		return masterBewertungAverage;
	}



	public void setMasterBewertungAverage(String masterBewertungAverage) {
		this.masterBewertungAverage = masterBewertungAverage;
	}



	public String getSelbstBewertungAverage() {
		return selbstBewertungAverage;
	}



	public void setSelbstBewertungAverage(String selbstBewertungAverage) {
		this.selbstBewertungAverage = selbstBewertungAverage;
	}



	public long getMitarbeiterCount() {
		return mitarbeiterCount;
	}



	public void setMitarbeiterCount(long mitarbeiterCount) {
		this.mitarbeiterCount = mitarbeiterCount;
	}



	public long getSkillCount() {
		return skillCount;
	}



	public void setSkillCount(long skillCount) {
		this.skillCount = skillCount;
	}
	
	
	
    
    
    
    
  
  
    
    
   

}

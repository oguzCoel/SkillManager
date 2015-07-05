package ch.business.quickline.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterQualifikation;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Qualifikation;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;

@ManagedBean
@Component
@ViewScoped
public class MitarbeiterViewController implements Serializable {
	
	@Autowired
	MitarbeiterService mitarbeiterService;
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	private MeterGaugeChartModel masterBewertungenIndividual;
    private MeterGaugeChartModel selbstBewertungenIndividual;
    private Double masterBewertungDurchschnitt;
    private Double selbstBewertungDurchschnitt;
    private String masterBewertungDurchschnittString;
    private String selbstBewertungDurchschnittString;
	private Mitarbeiter mitarbeiter;
	private Set<Qualifikation> qualifikations;
	private Set<MitarbeiterQualifikation> mitarbeiterQualifikations;
	private List<MitarbeiterSkill> mitarbeiterSkills;
	private List<MitarbeiterSkill> mitarbeiterInterests;
	
    private DecimalFormat df = new DecimalFormat("#.###");


   
	@ManagedProperty("#{param.id}")
    private Integer id;
    
 
 
    
    @PostConstruct
    public void init(){
		
		createMeterGaugeModels();
    	
    }
    
    
    public void initValues(){
    	mitarbeiter = mitarbeiterService.findByMitarbeiterId(id);
		mitarbeiterQualifikations = mitarbeiterService.findByMitarbeiterId(id).getMitarbeiterQualifikations();
		
	
		
		
		mitarbeiterSkills = mitarbeiterSkillService.findByMitarbeiterOrderByMasterBewertungDesc(mitarbeiter);
		mitarbeiterInterests = mitarbeiterSkillService.findByMitarbeiterOrderBySelbstBewertungDesc(mitarbeiter);
    	masterBewertungDurchschnitt = mitarbeiterService.retrieveMasterBewertungDurchschnitt(mitarbeiter.getMitarbeiterId());
    	selbstBewertungDurchschnitt = mitarbeiterService.retrieveSelbstBewertungDurchschnitt(mitarbeiter.getMitarbeiterId());
		masterBewertungDurchschnittString = df.format(mitarbeiterService.retrieveMasterBewertungDurchschnitt(mitarbeiter.getMitarbeiterId()));
		selbstBewertungDurchschnittString = df.format(mitarbeiterService.retrieveSelbstBewertungDurchschnitt(mitarbeiter.getMitarbeiterId()));
    	
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
    private void createMeterGaugeModels(){
        masterBewertungenIndividual = initMeterGaugeModel();
        masterBewertungenIndividual.setTitle("Masterbewertungen");
        masterBewertungenIndividual.setGaugeLabel("Skill");
        masterBewertungenIndividual.setValue(masterBewertungDurchschnitt);
        
         
        selbstBewertungenIndividual = initMeterGaugeModel();
        selbstBewertungenIndividual.setTitle("Selbstbewertungen");
        selbstBewertungenIndividual.setGaugeLabel("Interesse");
        selbstBewertungenIndividual.setValue(selbstBewertungDurchschnitt);
    }
    
    
    
    public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}
		


	public Double getMasterBewertungDurchschnitt() {
		return masterBewertungDurchschnitt;
	}


	public void setMasterBewertungDurchschnitt(
			Double masterBewertungDurchschnitt) {
		this.masterBewertungDurchschnitt = masterBewertungDurchschnitt;
	}


	public Double getSelbstBewertungDurchschnitt() {
		return selbstBewertungDurchschnitt;
	}


	public void setSelbstBewertungDurchschnitt(
			Double selbstBewertungDurchschnitt) {
		this.selbstBewertungDurchschnitt = selbstBewertungDurchschnitt;
	}
	
	

	public String getMasterBewertungDurchschnittString() {
		return masterBewertungDurchschnittString;
	}


	public void setMasterBewertungDurchschnittString(
			String masterBewertungDurchschnittString) {
		this.masterBewertungDurchschnittString = masterBewertungDurchschnittString;
	}


	public String getSelbstBewertungDurchschnittString() {
		return selbstBewertungDurchschnittString;
	}


	public void setSelbstBewertungDurchschnittString(
			String selbstBewertungDurchschnittString) {
		this.selbstBewertungDurchschnittString = selbstBewertungDurchschnittString;
	}


	public MeterGaugeChartModel getMasterBewertungenIndividual() {
        return masterBewertungenIndividual;
    }
     
    public MeterGaugeChartModel getSelbstBewertungenIndividual() {
        return selbstBewertungenIndividual;
    }


	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}


	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}


	public Set<MitarbeiterQualifikation> getMitarbeiterQualifikations() {
		return mitarbeiterQualifikations;
	}


	public void setMitarbeiterQualifikations(Set<MitarbeiterQualifikation> mitarbeiterQualifikations) {
		this.mitarbeiterQualifikations = mitarbeiterQualifikations;
	}
	
	


	public Set<Qualifikation> getQualifikations() {
		return qualifikations;
	}


	public void setQualifikations(Set<Qualifikation> qualifikations) {
		this.qualifikations = qualifikations;
	}


	public List<MitarbeiterSkill> getMitarbeiterSkills() {
		return mitarbeiterSkills;
	}


	public void setMitarbeiterSkills(List<MitarbeiterSkill> mitarbeiterSkills) {
		this.mitarbeiterSkills = mitarbeiterSkills;
	}


	public List<MitarbeiterSkill> getMitarbeiterInterests() {
		return mitarbeiterInterests;
	}


	public void setMitarbeiterInterests(List<MitarbeiterSkill> mitarbeiterInterests) {
		this.mitarbeiterInterests = mitarbeiterInterests;
	}
    
    
   

}

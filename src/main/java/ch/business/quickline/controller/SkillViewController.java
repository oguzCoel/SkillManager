package ch.business.quickline.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.domain.SkillMaster;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillMasterService;
import ch.business.quickline.service.SkillService;

@ManagedBean
@Component
@ViewScoped
public class SkillViewController {
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	@Autowired
	private SkillMasterService skillMasterService;
	
	 private MeterGaugeChartModel masterBewertungenSkill;
	 private MeterGaugeChartModel selbstBewertungenSkill;
	 private Skill skill;
	 private Long countOfSkilledMitarbeiter;
	 private List<MitarbeiterSkill> masterBewertungRanking;
	 private List<MitarbeiterSkill> selbstBewertungRanking;
	 private Double masterBewertungDurchschnitt;
	 private Double selbstBewertungDurchschnitt;
	 private String masterBewertungDurchschnittString;
	 private String selbstBewertungDurchschnittString;
	 private SkillMaster skillMaster;
	 
	 private DecimalFormat df = new DecimalFormat("#.###");
	 
	 
	 @ManagedProperty("#{param.id}")
	    private Integer id;
	
	 
	 
	 @PostConstruct
	 public void init(){
		 createMeterGaugeModels();
	 }
	 
	 public void initValues (){
		    
		    skill = skillService.findBySkillId(id);
		    countOfSkilledMitarbeiter = mitarbeiterSkillService.countBySkill(skill);
		    masterBewertungRanking = mitarbeiterSkillService.findBySkillOrderByMasterBewertungDesc(skill);
		    selbstBewertungRanking = mitarbeiterSkillService.findBySkillOrderBySelbstBewertungDesc(skill);
		    masterBewertungDurchschnitt = skillService.retrieveMasterBewertungDurchschnitt(skill.getSkillId());
		    selbstBewertungDurchschnitt = skillService.retrieveSelbstBewertungDurchschnitt(skill.getSkillId());
		    masterBewertungDurchschnittString = df.format(skillService.retrieveMasterBewertungDurchschnitt(skill.getSkillId()));
			selbstBewertungDurchschnittString = df.format(skillService.retrieveSelbstBewertungDurchschnitt(skill.getSkillId()));
			skillMaster = skillMasterService.findBySkill(skill);
		
	 }
	 
	 
	 public MeterGaugeChartModel getMasterBewertungenSkill() {
	        return masterBewertungenSkill;
	 }
	     
	    public MeterGaugeChartModel getSelbstBewertungenSkill() {
	        return selbstBewertungenSkill;
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
	        
	        masterBewertungenSkill = initMeterGaugeModel();
	        masterBewertungenSkill.setTitle("Masterbewertungen");
	        masterBewertungenSkill.setGaugeLabel("Skill");
	        masterBewertungenSkill.setValue(masterBewertungDurchschnitt);
	        
	        selbstBewertungenSkill = initMeterGaugeModel();
	        selbstBewertungenSkill.setTitle("Selbstbewertungen");
	        selbstBewertungenSkill.setGaugeLabel("Interesse");
	        selbstBewertungenSkill.setValue(selbstBewertungDurchschnitt);
	    }


		public Skill getSkill() {
			return skill;
		}


		public void setSkill(Skill skill) {
			this.skill = skill;
		}


		public Long getCountOfSkilledMitarbeiter() {
			return countOfSkilledMitarbeiter;
		}


		public void setCountOfSkilledMitarbeiter(Long countOfSkilledMitarbeiter) {
			this.countOfSkilledMitarbeiter = countOfSkilledMitarbeiter;
		}


		public List<MitarbeiterSkill> getMasterBewertungRanking() {
			return masterBewertungRanking;
		}


		public void setMasterBewertungRanking(
				List<MitarbeiterSkill> masterBewertungRanking) {
			this.masterBewertungRanking = masterBewertungRanking;
		}


		public List<MitarbeiterSkill> getSelbstBewertungRanking() {
			return selbstBewertungRanking;
		}


		public void setSelbstBewertungRanking(
				List<MitarbeiterSkill> selbstBewertungRanking) {
			this.selbstBewertungRanking = selbstBewertungRanking;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
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

		public SkillMaster getSkillMaster() {
			return skillMaster;
		}

		public void setSkillMaster(SkillMaster skillMaster) {
			this.skillMaster = skillMaster;
		}
		
		 public void handleToggle(ToggleEvent event) {
		        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		    }


}

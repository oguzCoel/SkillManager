package ch.business.quickline.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.MitarbeiterSkillService;

@ManagedBean
@Component
@RequestScoped
public class BarChartView {
	
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	@Autowired
	private MitarbeiterService mitarbeiterService;
	

	
	 private BarChartModel barModel;
	
	  @PostConstruct
	    public void init() {
	        createBarModels();
	    }
	 
	    public BarChartModel getBarModel() {
	        return barModel;
	    }
	    
	    @PostConstruct
	    private ChartSeries getChartSeries(){
	    	ChartSeries skills = new ChartSeries();
	    	skills.setLabel("Skill");
	    	Mitarbeiter mitarbeiter = mitarbeiterService.findByMitarbeiterId(1);
	    	  
		        
		        for(MitarbeiterSkill mitarbeiterSkill : mitarbeiterSkillService.findByMitarbeiterOrderByMasterBewertungDesc(mitarbeiter)){
		        	skills.set(mitarbeiterSkill.getSkill().getSkillName().toString(), mitarbeiterSkill.getMasterBewertung());
		        }
		        
		        return skills;
	    }
	     
	  
	    
	    private BarChartModel initBarModel() {
	        BarChartModel model = new BarChartModel();
	        
	        model.addSeries(getChartSeries());
	    
	        return model;
	    }
	     
	    private void createBarModels() {
	        createBarModel();
	    }
	     
	    private void createBarModel() {
	        barModel = initBarModel();
	         
	        barModel.setTitle("Mitarbeiterskills");
	        barModel.setLegendPosition("ne");
	         
	        Axis xAxis = barModel.getAxis(AxisType.X);
	        xAxis.setLabel("Skills");
	        xAxis.setTickAngle(-30);

	         
	        Axis yAxis = barModel.getAxis(AxisType.Y);
	        yAxis.setLabel("Skilllevel");
	        yAxis.setMin(0);
	        yAxis.setMax(5);
	    }

}

package ch.business.quickline.story;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.service.AbteilungService;
import ch.business.quickline.service.MitarbeiterService;
import ch.business.quickline.service.SkillService;




@Component
public class ManageAbteilungSteps {

@Autowired
private AbteilungService abteilungService;
  
 
Abteilung abteilung = new Abteilung();
  
		
  @When("der Admin einen neue Abteilung '$testabteilung' erfasst")
  public void createSkill(String testabteilung){
   
	  
	  abteilung.setAbteilungName(testabteilung);
	  abteilungService.save(abteilung);
  }
		
  @Then("ist AbteilungX in der Datenbank gespeichert")
  public void lookForAbteilung() {
    
	  Assert.assertTrue("check if new Abteilung exist", abteilungService.findALL().contains(abteilung)  );
  }
		
  
}

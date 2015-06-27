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
import ch.business.quickline.service.AbteilungService;




@Component
public class ManageAbteilungSteps {

  @Autowired
  private AbteilungService abteilungService;
		
  @Given("the list of abteilungen $abteilungTable")
  public void createAbteilung( ExamplesTable abteilungTable ){
    for( Parameters p: abteilungTable.getRowsAsParameters()){
      Abteilung abteilung = new Abteilung();
      abteilung.setAbteilungName(p.valueAs("AbteilungName", String.class));
      abteilungService.save(abteilung);
    }
  }
		
  @When("When the user adds the abteilung $testabteilung")
  public void addStudent(String tesabteilung) throws ParseException{
    Abteilung abteilung = new Abteilung();
    abteilung.setAbteilungName(tesabteilung);
    abteilungService.save(abteilung);
  }
		
  @Then("the list of abteilung is $abteilungTable")
  public void assertStudentTable(ExamplesTable studTable){
    Iterator<Abteilung> iter = abteilungService.findALL().iterator();
    for( Parameters p: studTable.getRowsAsParameters()){
      if( !iter.hasNext()) Assert.fail("unexpected end of list");
      Abteilung actual = iter.next();
      Assert.assertEquals(p.valueAs("AbteilungName", String.class), actual.getAbteilungName());
    }
  }
}

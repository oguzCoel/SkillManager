package ch.business.quickline.repository;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.config.JpaConfig;
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterQualifikation;

public class MitarbeiterQualifikationRepositoryTest {
	  static MitarbeiterQualifikationRepository mitarbeiterQualifikationRepository;

	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception {
	    ApplicationContext context = 
	       new AnnotationConfigApplicationContext(JpaConfig.class);
	       
	    mitarbeiterQualifikationRepository = (MitarbeiterQualifikationRepository) 
	    	              context.getBean("mitarbeiterQualifikationRepository");
	  }  
	@Test
	public void test() {
		MitarbeiterQualifikation mitarbeiterQualifikation = new MitarbeiterQualifikation();
		Mitarbeiter mitarbeiter =new Mitarbeiter();
		mitarbeiterQualifikation.setMitarbeiter(mitarbeiter);	   
	    assertEquals(mitarbeiter,mitarbeiterQualifikation.getMitarbeiter());
	}

}

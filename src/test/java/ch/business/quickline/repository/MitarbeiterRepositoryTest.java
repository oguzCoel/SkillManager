package ch.business.quickline.repository;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.config.JpaConfig;
import ch.business.quickline.domain.Mitarbeiter;

public class MitarbeiterRepositoryTest {
	  static MitarbeiterRepository mitarbeiterRepository;

	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception {
	    ApplicationContext context = 
	       new AnnotationConfigApplicationContext(JpaConfig.class);
	       
	    mitarbeiterRepository = (MitarbeiterRepository) 
	    	              context.getBean("mitarbeiterRepository");
	  }
	@Test
	public void test() {
		String name="neuerName";
		Mitarbeiter mitarbeiter = new Mitarbeiter();
		mitarbeiter.setMitarbeiterVorname(name);
		//user.setBenutzerName(name);    
	    assertEquals(name,mitarbeiter.getMitarbeiterVorname());	
	}
}

package ch.business.quickline.repository;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.config.JpaConfig;
import ch.business.quickline.domain.Gruppe;

public class GruppeRepositoryTest {
	  static GruppeRepository gruppeRepository;

	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception {
	    ApplicationContext context = 
	       new AnnotationConfigApplicationContext(JpaConfig.class);
	       
	    gruppeRepository = (GruppeRepository) 
	    	              context.getBean("gruppeRepository");
	  }   
	  
	@Test
	public void test() {
		String name="neuegroup";
		Gruppe group = new Gruppe();
		group.setGruppeName(name);	   
	    assertEquals(name,group.getGruppeName());
	}

}

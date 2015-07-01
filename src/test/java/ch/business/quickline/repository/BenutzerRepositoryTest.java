package ch.business.quickline.repository;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.config.JpaConfig;

public class BenutzerRepositoryTest {
	  static BenutzerRepository benutzerRepository;

	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception {
	    ApplicationContext context = 
	       new AnnotationConfigApplicationContext(JpaConfig.class);
	       
	    benutzerRepository = (BenutzerRepository) 
	    	              context.getBean("benutzerRepository");
	  }
	@Test
	public void test() {
		String name="neuerName";
		Benutzer user = new Benutzer();
		user.setBenutzerName(name);    
	    assertEquals(name,user.getBenutzerName());
	}

}

package ch.business.quickline.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.config.JpaConfig;
import ch.business.quickline.domain.Abteilung;



public class AbteilungRepositoryTest {
  static AbteilungRepository abteilungRepository;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    ApplicationContext context = 
       new AnnotationConfigApplicationContext(JpaConfig.class);
       
    abteilungRepository = (AbteilungRepository) 
    	              context.getBean("abteilungRepository");
  }
	  
  @Test
  public void testSave() {
    Abteilung abt = new Abteilung();
    abt.setAbteilungName("Projektmanagement");
    assertNull("empty pk", abt.getAbteilungId());
    abt = abteilungRepository.save(abt);
    assertNotNull("generated pk", abt.getAbteilungId());
  }
}
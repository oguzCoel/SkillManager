package ch.business.quickline.repository;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.business.quickline.config.JpaConfig;
import ch.business.quickline.domain.MitarbeiterSkill;

public class MitarbeiterSkillRepositoryTest {
	  static MitarbeiterSkillRepository mitarbeiterSkillRepository;

	  @BeforeClass
	  public static void setUpBeforeClass() throws Exception {
	    ApplicationContext context = 
	       new AnnotationConfigApplicationContext(JpaConfig.class);
	       
	    mitarbeiterSkillRepository = (MitarbeiterSkillRepository) 
	    	              context.getBean("mitarbeiterSkillRepository");
	  }
	@Test
	public void test() {
		MitarbeiterSkill mitarbeiterSkill = new MitarbeiterSkill();
		mitarbeiterSkill.setMitarbeiterSkillId(3);   	
	    assertTrue("true",mitarbeiterSkill.getMitarbeiterSkillId()==3);
	}

}

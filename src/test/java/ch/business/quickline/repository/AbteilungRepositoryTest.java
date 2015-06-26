package ch.business.quickline.repository;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import ch.business.quickline.config.JpaConfig;
import ch.business.quickline.config.TestConfig;
import ch.business.quickline.domain.Abteilung;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class, TestConfig.class })
@TestExecutionListeners({
    TransactionalTestExecutionListener.class,
    DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class})

public class AbteilungRepositoryTest {
	
  @Autowired
  AbteilungRepository abteilungRepository;
  
  private Abteilung abteilung;
  
  @Before
  public void setUp(){
	  abteilung = new Abteilung();
	  abteilung.setAbteilungName("Testabteilung");
  }
	  
    @Test
	@DatabaseSetup("/dbunit/db-export.xml")
	public void testFindAll() {
		Assert.assertTrue(!abteilungRepository.findAll().isEmpty());
		
	}
    
    @Test
    @DatabaseSetup("/dbunit/db-export.xml")
    public void testSave(){
    	int before = abteilungRepository.findAll().size();
    	abteilungRepository.save(abteilung);
    	int after = abteilungRepository.findAll().size();
    	
    	
    	Assert.assertTrue(before != after);
    }
  
  

}
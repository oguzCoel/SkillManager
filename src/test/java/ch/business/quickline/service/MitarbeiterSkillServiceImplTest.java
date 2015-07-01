package ch.business.quickline.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class, TestConfig.class })
@TestExecutionListeners({
    TransactionalTestExecutionListener.class,
    DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class MitarbeiterSkillServiceImplTest {
	
	@Autowired
	private MitarbeiterService mitarbeiterService;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	private Mitarbeiter mitarbeiter;
	private Skill skill;
	private MitarbeiterSkill mitarbeiterSkill;
	private List<MitarbeiterSkill> mitarbeiterSkills;

	@Before
	public  void setUp() {
		mitarbeiter = mitarbeiterService.findByMitarbeiterId(1); 
		skill = skillService.findBySkillId(2);
		mitarbeiterSkill = new MitarbeiterSkill();
		mitarbeiterSkills = new ArrayList<MitarbeiterSkill>();
		
	}

	@Test
	@DatabaseSetup("/dbunit/db-export.xml")
	public void testSave() {
		mitarbeiterSkill.setMitarbeiter(mitarbeiter);
		mitarbeiterSkill.setSkill(skill);
		mitarbeiterSkill.setMasterBewertung(5);
		
		Assert.assertFalse(mitarbeiterSkillService.findAll().contains(mitarbeiterSkill));
		mitarbeiterSkillService.save(mitarbeiterSkill);
		Assert.assertTrue(mitarbeiterSkillService.findAll().contains(mitarbeiterSkill));
	}

	@Test
	@DatabaseSetup("/dbunit/db-export.xml")
	public void testFindByMitarbeiterOrderByMasterBewertungDesc() {
		mitarbeiterSkills = mitarbeiterSkillService.findByMitarbeiterOrderByMasterBewertungDesc(mitarbeiter);
		
		Assert.assertNotNull(mitarbeiterSkills);
		Assert.assertTrue(mitarbeiterSkills.get(0).getMasterBewertung() >= mitarbeiterSkills.get(1).getMasterBewertung());
	}

	@Test
	public void testFindByMitarbeiterOrderBySelbstBewertungDesc() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBySkillOrderByMasterBewertungDesc() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBySkillOrderBySelbstBewertungDesc() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveMasterBewertungGlobalAverage() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveSelbstBewertungGlobalAverage() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByMitarbeiter() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBySkill() {
		fail("Not yet implemented");
	}

}

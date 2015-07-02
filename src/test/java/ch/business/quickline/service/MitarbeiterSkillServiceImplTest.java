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
	private Double mitarbeiterMasterBewertungDurchschnittBeforeSave;
	private Double mitarbeiterSelbstBewertungDurchschnittBeforeSave;
	private Double skillMasterBewertungDurchschnittBeforeSave;
	private Double skillSelbstBewertungDurchschnittBeforeSave;

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
		mitarbeiterMasterBewertungDurchschnittBeforeSave = mitarbeiter.getMitarbeiterMasterBewertungDurchschnitt();
		mitarbeiterSelbstBewertungDurchschnittBeforeSave = mitarbeiter.getMitarbeiterSelbstBewertungDurchschnitt();
		skillMasterBewertungDurchschnittBeforeSave = skill.getSkillMasterBewertungDurchschnitt();
		skillSelbstBewertungDurchschnittBeforeSave = skill.getSkillSelbstBewertungDurchschnitt();
		
		
		Assert.assertFalse(mitarbeiterSkillService.findAll().contains(mitarbeiterSkill));
		mitarbeiterSkillService.save(mitarbeiterSkill);
		Assert.assertTrue(mitarbeiterSkillService.findAll().contains(mitarbeiterSkill));
		Assert.assertNotEquals(mitarbeiter.getMitarbeiterMasterBewertungDurchschnitt(), mitarbeiterMasterBewertungDurchschnittBeforeSave);
		Assert.assertNotEquals(mitarbeiter.getMitarbeiterSelbstBewertungDurchschnitt(), mitarbeiterSelbstBewertungDurchschnittBeforeSave);
		Assert.assertNotEquals(skill.getSkillMasterBewertungDurchschnitt(), skillMasterBewertungDurchschnittBeforeSave);
		Assert.assertNotEquals(skill.getSkillSelbstBewertungDurchschnitt(), skillSelbstBewertungDurchschnittBeforeSave);
	}

	@Test
	public void testFindByMitarbeiterOrderByMasterBewertungDesc() {
		mitarbeiterSkills = mitarbeiterSkillService.findByMitarbeiterOrderByMasterBewertungDesc(mitarbeiter);
		
		Assert.assertNotNull(mitarbeiterSkills);
		Assert.assertTrue(mitarbeiterSkills.get(0).getMasterBewertung() >= mitarbeiterSkills.get(1).getMasterBewertung());
	}

	@Test
	public void testFindByMitarbeiterOrderBySelbstBewertungDesc() {
		mitarbeiterSkills = mitarbeiterSkillService.findByMitarbeiterOrderBySelbstBewertungDesc(mitarbeiter);
		
		Assert.assertEquals(mitarbeiterSkills.get(0).getMitarbeiter(), this.mitarbeiter);
		Assert.assertTrue(mitarbeiterSkills.get(0).getSelbstBewertung() >= mitarbeiterSkills.get(1).getMasterBewertung());
	}

	@Test
	public void testFindBySkillOrderByMasterBewertungDesc() {
		mitarbeiterSkills = mitarbeiterSkillService.findBySkillOrderByMasterBewertungDesc(skill);
		
		Assert.assertEquals(mitarbeiterSkills.get(0).getSkill(), this.skill);
		Assert.assertTrue(mitarbeiterSkills.get(0).getMasterBewertung() >= mitarbeiterSkills.get(1).getMasterBewertung());
	}

	@Test
	public void testFindBySkillOrderBySelbstBewertungDesc() {
		mitarbeiterSkills = mitarbeiterSkillService.findBySkillOrderBySelbstBewertungDesc(skill);
		
		Assert.assertEquals(mitarbeiterSkills.get(0).getSkill(), this.skill);
		Assert.assertTrue(mitarbeiterSkills.get(0).getSelbstBewertung() >= mitarbeiterSkills.get(1).getSelbstBewertung());
	}


	@Test
	public void testCountBySkill(){
		mitarbeiterSkills = mitarbeiterSkillService.findBySkill(skill);
		
		Assert.assertEquals(mitarbeiterSkills.size(), mitarbeiterSkillService.countBySkill(skill).intValue());
	}
	
	

	@Test
	@DatabaseSetup("/dbunit/db-export.xml")
	public void testDeleteByMitarbeiter() {
		Assert.assertFalse(mitarbeiterSkillService.findByMitarbeiter(mitarbeiter).isEmpty());
		mitarbeiterSkillService.deleteByMitarbeiter(mitarbeiter);
		Assert.assertTrue(mitarbeiterSkillService.findByMitarbeiter(mitarbeiter).isEmpty());
	}

	@Test
	@DatabaseSetup("/dbunit/db-export.xml")
	public void testDeleteBySkill() {
		Assert.assertFalse(mitarbeiterSkillService.findBySkill(skill).isEmpty());
		mitarbeiterSkillService.deleteBySkill(skill);
		Assert.assertTrue(mitarbeiterSkillService.findBySkill(skill).isEmpty());
	}

}

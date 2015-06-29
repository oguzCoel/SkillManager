package ch.business.quickline.repository;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.BenutzerRole;
import ch.business.quickline.domain.Role;
import ch.business.quickline.repository.BenutzerRoleRepository;
import ch.business.quickline.service.BenutzerRoleService;

public class BenutzerRoleRepositoryTest {

private Benutzer benutzer;
private BenutzerRole benutzerRole;
private Role role;
private Set<BenutzerRole> benutzerRoles;
private BenutzerRoleRepository benutzerRoleRepository;

@Autowired
BenutzerRoleService benutzerRoleService;

@Before
public void setUp(){
	benutzerRoleRepository = EasyMock.createMock(BenutzerRoleRepository.class);
	
	benutzer = new Benutzer();
	role = new Role();
	benutzerRole = new BenutzerRole();
	benutzerRoles = new HashSet<BenutzerRole>();
	benutzerRoles.add(benutzerRole);
	
	benutzer.setBenutzerId(1);
	benutzer.setBenutzerName("testUser");
	benutzer.setBenutzerEmail("testEmail");
	benutzer.setBenutzerPasswort("testPassword");
	benutzer.setBenutzerRoles(benutzerRoles);
	
	role.setRoleId(1);
	role.setRoleName("testRole");
	role.setBenutzerRoles(benutzerRoles);
	
	benutzerRole.setBenutzerRoleId(1);
	benutzerRole.setBenutzer(benutzer);
	benutzerRole.setRole(role);	
	
}

	@Test
	public void testSave() {
		
		EasyMock.expect(benutzerRoleRepository.save(benutzerRole)).andReturn(benutzerRole);
		
		EasyMock.replay(benutzerRoleRepository);
		
		String expected = benutzerRoleRepository.save(benutzerRole).getBenutzer().getBenutzerName();
		Assert.assertEquals("check username","testUser",expected );
		EasyMock.verify(benutzerRoleRepository);
	}

	@Test
	public void testFindByBenutzer() {
		
		for (BenutzerRole br : benutzerRoles){
			if(br.getBenutzer().equals(benutzer)){
			EasyMock.expect(benutzerRoleRepository.findByBenutzer(benutzer)).andReturn(this.benutzerRole);
			
			}
			
			EasyMock.replay(benutzerRoleRepository);
			
			BenutzerRole expected = benutzerRoleRepository.findByBenutzer(benutzer);
			
			Assert.assertEquals(expected, benutzerRole  );
			
			EasyMock.verify(benutzerRoleRepository);
		}
		
	}

}

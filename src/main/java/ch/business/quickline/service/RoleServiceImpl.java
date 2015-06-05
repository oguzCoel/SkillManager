package ch.business.quickline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Role;
import ch.business.quickline.repository.RoleRepository;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	public Role save(Role role) {
		
		return roleRepository.save(role);
	}
	
	public List<Role> findAll(){
		
		return roleRepository.findAll();
	}

}

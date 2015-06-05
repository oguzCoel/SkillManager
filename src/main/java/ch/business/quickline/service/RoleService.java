package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Role;

public interface RoleService {
	
	public Role save (Role role);
	public List<Role> findAll();

}

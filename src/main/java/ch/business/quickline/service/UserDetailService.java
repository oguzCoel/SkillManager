package ch.business.quickline.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.BenutzerRole;
import ch.business.quickline.domain.Role;
import ch.business.quickline.repository.BenutzerRepository;

@Service("userDetailService")
@Transactional
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	BenutzerRepository benutzerRepository;
	
	
	private User user;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Benutzer benutzer = benutzerRepository.findByBenutzerName(username);
		
		List<GrantedAuthority> authorities = buildUserAuthority (benutzer.getBenutzerRoles());
		
		return buildUserForAuthentication (benutzer, authorities);
	}
	
	private User buildUserForAuthentication (Benutzer benutzer, List<GrantedAuthority> authorities){
		
		user = new User (benutzer.getBenutzerName(), benutzer.getBenutzerPasswort(), true, true, true, true, authorities );
		
		return user;
		
	}
	
	
	private List<GrantedAuthority> buildUserAuthority(Set<BenutzerRole> roles) {
		 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (BenutzerRole role : roles) {
			setAuths.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
		}
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}
	
	public String getUsername(){
		return user.getUsername();
	}

}

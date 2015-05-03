package ch.business.quickline.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(eager = true)
@RequestScoped
public class NavigationController {
	
	public String toMitarbeiterFormular(){
		return "mitarbeiter";
	}

}

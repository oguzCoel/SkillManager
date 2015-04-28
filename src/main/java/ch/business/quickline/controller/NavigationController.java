package ch.business.quickline.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(eager = true)
@SessionScoped
public class NavigationController {
	
	public String outcome(){
		return "mitarbeiter";
	}

}

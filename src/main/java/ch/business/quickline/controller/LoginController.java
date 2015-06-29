package ch.business.quickline.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
@Scope("request")
public class LoginController {
 
   /* public String doLogin() throws IOException, ServletException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        
        return null;
    }
    */
    
    public void logout() {
    	SecurityContextHolder.clearContext();
    	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    	ec.invalidateSession();
    	try {
    	ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
    	} catch (IOException ex) {
    	ex.printStackTrace();
    	}
    	
    	
    }

    
  
}
 

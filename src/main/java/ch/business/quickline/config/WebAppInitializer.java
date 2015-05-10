package ch.business.quickline.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.sun.faces.config.ConfigureListener;

public class WebAppInitializer implements WebApplicationInitializer {

	   
	    public void onStartup(ServletContext servletContext)
	            throws ServletException {
	    	
	    	
	    	// Use JSF view templates saved as *.xhtml, for use with Facelets
	    	servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", "*.xhtml");
	    	servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", "*.jsf");
	    	servletContext.setInitParameter("javax.faces.DEFAULT_POSTFIX", "/faces*");
	    	// Enable special Facelets debug output during development
	    	servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
	    	// Causes Facelets to refresh templates during development
	    	servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
	    	servletContext.addListener(ConfigureListener.class);


		      // Create the 'root' Spring application context
		      AnnotationConfigWebApplicationContext rootContext =
		        new AnnotationConfigWebApplicationContext();
		      rootContext.register(JpaConfig.class);
		      rootContext.register(WebConfig.class);
		      rootContext.register(SecurityConfig.class);
		      
		      
		      // Manage the lifecycle of the root application context
		      servletContext.addListener(new ContextLoaderListener(rootContext));
		      
		      FilterRegistration.Dynamic securityFilter = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
		        securityFilter.addMappingForUrlPatterns(null, false, "/*");
		      
		      
		      
	
		      
		           

	    }
	    
	    protected Class<?>[] getRootConfigClasses() {
		    return new Class<?>[] {JpaConfig.class, SecurityConfig.class};
		    }
	    
	    
	    protected Filter[] getServletFilters() {
		    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		    characterEncodingFilter.setEncoding("UTF-8");
		    characterEncodingFilter.setForceEncoding(true);
		    return new Filter[] {characterEncodingFilter, new DelegatingFilterProxy("springSecurityFilterChain")};
		    }
	    
	 
	    
	 
	    
	    
	    
	    
	
	    
	    
	    
	  
	    }

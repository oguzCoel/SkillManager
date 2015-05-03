package ch.business.quickline.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebAppInitializer implements WebApplicationInitializer {

	   
	    public void onStartup(ServletContext servletContext)
	            throws ServletException {


		      // Create the 'root' Spring application context
		      AnnotationConfigWebApplicationContext rootContext =
		        new AnnotationConfigWebApplicationContext();
		      rootContext.register(JpaConfig.class);
		      rootContext.register(WebConfig.class);
		      
		      
		      // Manage the lifecycle of the root application context
		      servletContext.addListener(new ContextLoaderListener(rootContext));
			      


	    }
	    
	  
	    }

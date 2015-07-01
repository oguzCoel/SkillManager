package ch.business.quickline.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true )
@ComponentScan(basePackages={"ch.business.quickline.service"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Log
	final Logger logger = Logger.getLogger(SecurityConfig.class);
	
	@Autowired
	UserDetailsService userDetailsService;
	
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
        // The authentication provider below is the simplest provider you can use
        // The users, their passwords and roles are all added as clear text
      /*auth
          .inMemoryAuthentication()
          .withUser( "admin" )
              .password( "admin" )
              .roles( "USER", "ADMIN" )
              .and()
          .withUser( "user" )
              .password( "user" )
              .roles( "USER" );
      */
    	
    	try {
			auth.userDetailsService(userDetailsService);
		} catch (Exception e) {
			logger.error("Fehler aufgetreten bei Autendification. Details: "+ e.getMessage() );
		}
    	  	
    } 
    @Override
    public void configure( WebSecurity web ) throws Exception
    {
        try {
			// This is here to ensure that the static content (JavaScript, CSS, etc)
			// is accessible from the login page without authentication
			web.ignoring().antMatchers("/javax.faces.resource/**");
		} catch (Exception e) {
			logger.error("Fehler aufgetreten bei Configuration. Details: "+ e.getMessage() );
			// TODO: handle exception
		}
                
                
         
    }
 
   
    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
    	/*
    	http.csrf().disable()
    	.authorizeRequests()
    	.anyRequest().authenticated()
    	.and()
    	.formLogin()
    	.loginPage("/faces/login.xhtml")
    	   .and()
           .logout().logoutSuccessUrl("/faces/login.xhtml?logout=true")
               .permitAll();
    	*/
    		
    
    	

    	try {
			http.csrf().disable().authorizeRequests().anyRequest()
					.authenticated().and().formLogin();
		} catch (Exception e) {
			logger.error("Fehler aufgetreten bei Configuration HTTP Security. Details: "+ e.getMessage() );
		}
    	  	

                	
    }
    
  
 
}

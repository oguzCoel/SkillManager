package ch.business.quickline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
        // The authentication provider below is the simplest provider you can use
        // The users, their passwords and roles are all added as clear text
      auth
          .inMemoryAuthentication()
          .withUser( "admin" )
              .password( "admin" )
              .roles( "USER", "ADMIN" )
              .and()
          .withUser( "user" )
              .password( "user" )
              .roles( "USER" );
      
      
    } 
    @Override
    public void configure( WebSecurity web ) throws Exception
    {
        // This is here to ensure that the static content (JavaScript, CSS, etc)
        // is accessible from the login page without authentication
    	web
            .ignoring()
                .antMatchers("/faces/javax.faces.resource/**");
                
         
    }
 
   
    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
    	http.csrf().disable()
    	.authorizeRequests()
    	.anyRequest().authenticated()
    	.and()
    	.formLogin().loginPage("/faces/login.xhtml").permitAll();
    	
    	
    	
    	
    	
    
    	
                	
    }
 
}
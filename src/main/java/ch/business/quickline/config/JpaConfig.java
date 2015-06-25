package ch.business.quickline.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"ch.business.quickline.service"})
@EnableJpaRepositories("ch.business.quickline.repository")
@PropertySource(value="classpath:/hibernate.properties")
//@PropertySource(value="classpath:/hibernate-test.properties")
@EnableTransactionManagement
public class JpaConfig {
	@Autowired
	Environment env;
		
	@Bean
	public static PropertySourcesPlaceholderConfigurer 
	  propertySourcesPlaceholderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}
	
  @Bean
  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("hibernate.connection.driver_class"));
	    dataSource.setUrl(env.getProperty("hibernate.connection.url"));
	    dataSource.setUsername(env.getProperty("hibernate.connection.username"));
	    dataSource.setPassword(env.getProperty("hibernate.connection.password"));
	    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = 
        new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPackagesToScan(new String[] { "ch.business.quickline.domain" });

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
    properties.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));

    em.setJpaProperties(properties);

    return em;
  }
  
  @Bean
  public PlatformTransactionManager transactionManager(
  			EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);

    return transactionManager;
  }
  
  


}

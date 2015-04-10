package ch.business.quickline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:hibernate-test.properties")
public class TestConfig {

}
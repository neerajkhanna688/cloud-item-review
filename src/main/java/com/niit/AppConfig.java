package com.niit;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
@ComponentScan
public class AppConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dmds.setUrl(environment.getProperty("spring.datasource.url"));
		dmds.setUsername(environment.getProperty("spring.datasource.username"));
		dmds.setPassword(environment.getProperty("spring.datasource.password"));
		return dmds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter hJPAAdaptor = new HibernateJpaVendorAdapter(); 
		lcemfb.setJpaVendorAdapter(hJPAAdaptor);
		lcemfb.setPackagesToScan("com.niit.model");
		lcemfb.setJpaProperties(getProperties());
		lcemfb.setDataSource(dataSource());

		return lcemfb;
		
	}
	
	
	private Properties getProperties(){
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return p;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager jpaTransactionManager = new  JpaTransactionManager();
		return jpaTransactionManager;
	}
	
}
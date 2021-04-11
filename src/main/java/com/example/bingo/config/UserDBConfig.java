package com.example.bingo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Clase configuracion conexion a la base de datos test_usuarios
 * @author Cristian
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManagerFactory", transactionManagerRef = "userTransactionManager",
basePackages = {"com.example.bingo.repo.user"})
public class UserDBConfig {

	@Autowired
	private Environment env;
	
	/**
	 * Crear datasource
	 * @return
	 */
	@Bean(name = "userDataSource")
	public DataSource userDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("spring2.datasource.url"));
		dataSource.setUsername(env.getProperty("spring2.datasource.username"));
		dataSource.setPassword(env.getProperty("spring2.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("spring2.datasource.dbcp2.driver-class-name"));
		
		return dataSource;
	}
	
	/**
	 * Crear Entity manager
	 * @return
	 */
	@Bean(name = "userEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(userDatasource());
		em.setPackagesToScan("com.example.bingo.entity.user");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring2.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.show-sql", env.getProperty("spring2.jpa.show-sql"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
		
	}
	
	/**
	 * Crear Transaction manager
	 * @return
	 */
	@Bean(name = "userTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}

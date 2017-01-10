package fr.pizzeria.console;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


@Configuration
@ComponentScan("fr.pizzeria")
@EnableAspectJAutoProxy
public class PizzeriaAppSpringConfig {

	@Bean
	public Scanner scanner() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}

	@Bean
	public EmbeddedDatabase dataSourceEmbedded(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder
				.setType(EmbeddedDatabaseType.H2)
				.addScript("test-data.sql")
				.build();
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPersistenceUnitName("pizzeria-console");
		return em;
	}
	
	@Bean
	public JpaTransactionManager txManager(){
		return new JpaTransactionManager();
	}
	

}

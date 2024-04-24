package com.main.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.main.repo.prod", entityManagerFactoryRef = "orcEMF", transactionManagerRef = "orclTxMngr")
public class OracleDBConfig 
{
      
	@Bean(name="orcDS")
	@ConfigurationProperties(prefix = "oracle.datasource")
	@Primary
	public DataSource createOracleDS()
	{
		return DataSourceBuilder.create().build();
	}
	@Bean(name="orcEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createOracleEntityManagerFactoryBean(EntityManagerFactoryBuilder builder)
	{
	          Map<String,Object> props = new HashMap<>();
	          props.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
	          props.put("hibernate.show_sql", "true");
	          props.put("hibernate.hbm2ddl.auto", "update");
	          
	          return  builder.dataSource(createOracleDS())
	        		  .packages("com.main.entity.prod")
	        		  .properties(props)
	        		  .build();
	}
	
	@Bean("orclTxMngr")
	public JpaTransactionManager createOracleTxMnger(@Qualifier("orcEMF") EntityManagerFactory factory)
	{
		
		return new JpaTransactionManager(factory);
	}
}

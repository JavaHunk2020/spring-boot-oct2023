package com.spring;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ThothITConfiguration {
	
	//when we return DataSource
	@Bean
    public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:33006/kia_db?useSSL=false");
		dataSource.setUsername("dbadmin");
		dataSource.setPassword("cmapdbadmin");
        return dataSource;
    }
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public Dog getDog(){
		return new Dog("tommy","white","test","NA");
	}

}

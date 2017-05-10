package com.chase.hackathon.cafeteria.app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.chase.hackathon.*")
@EnableWebMvc
public class AppConfig {

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSrc = new BasicDataSource();
		dataSrc.setDriverClassName("com.mysql.jdbc.Driver");
		dataSrc.setUrl("jdbc:mysql://jpmcafe.crdh6hwnzwki.us-west-2.rds.amazonaws.com:3306/JPMCafe");
		dataSrc.setPassword("JPMCafe123");
		dataSrc.setUsername("JPMCafe");
		return dataSrc;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

		return jdbcTemplate;

	}

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}

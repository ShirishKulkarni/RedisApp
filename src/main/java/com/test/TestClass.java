package com.test;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestClass {

	public static void main(String[] args) {

		new TestClass().getJdbcTemplate();
	}

	public DataSource getDataSource() {
		BasicDataSource dataSrc = new BasicDataSource();
		dataSrc.setDriverClassName("com.mysql.jdbc.Driver");
		dataSrc.setUrl("jdbc:mysql://jpmcafe.crdh6hwnzwki.us-west-2.rds.amazonaws.com:3306/JPMCafe");
		dataSrc.setPassword("JPMCafe123");
		dataSrc.setUsername("JPMCafe");
		return dataSrc;
	}

	public JdbcTemplate getJdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

		Map<String, Object> resMap = null;
		resMap = jdbcTemplate.queryForMap("select name,owner from test");

		return jdbcTemplate;

	}

}

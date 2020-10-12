package com.jde.ws.jdebpmws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@SpringBootApplication
@Slf4j
public class JdebpmwsApplication {

	@Bean
	@Autowired
	public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
		return new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("FOO").usingGeneratedKeyColumns("ID");
	}

	@Bean
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	public static void main(String[] args) {
		SpringApplication.run(JdebpmwsApplication.class, args);
	}

}

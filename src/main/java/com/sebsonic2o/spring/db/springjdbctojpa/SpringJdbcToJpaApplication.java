package com.sebsonic2o.spring.db.springjdbctojpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sebsonic2o.spring.db.springjdbctojpa.entity.Person;
import com.sebsonic2o.spring.db.springjdbctojpa.jdbc.PersonJdbcDao;

@SpringBootApplication
public class SpringJdbcToJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcToJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All persons - {}", dao.findAll());
		logger.info("Person id 10001 - {}", dao.findById(10001));
		logger.info("Deleting person id 10002 - {} updated row(s)", dao.deleteById(10002));
		Person person = new Person(10004, "Jean", "Paris", new Date());
		logger.info("Inserting person id 10004 - {} updated row(s)", dao.insert(person));
		person.setName("Paul");
		logger.info("Updating person id 10004 - {} updated row(s)", dao.update(person));
	}
}

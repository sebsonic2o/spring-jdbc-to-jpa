package com.sebsonic2o.spring.db.springjdbctojpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sebsonic2o.spring.db.springjdbctojpa.entity.Person;
import com.sebsonic2o.spring.db.springjdbctojpa.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Person id 10001 - {}", repo.findById(10001));
		logger.info("Deleting person id 10002");
		repo.deleteById(10002);
		logger.info("Deleted person id 10002");
		Person person = new Person("Jean", "Paris", new Date());
		logger.info("Inserting new person - {}", person = repo.insert(person));
		person.setName("Paul");
		logger.info("Updating new person - {}", repo.update(person));
	}
}

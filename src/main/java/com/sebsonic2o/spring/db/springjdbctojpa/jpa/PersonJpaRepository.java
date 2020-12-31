package com.sebsonic2o.spring.db.springjdbctojpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sebsonic2o.spring.db.springjdbctojpa.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	// database connection
	@PersistenceContext
	EntityManager entityManager;

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
}

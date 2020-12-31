package com.sebsonic2o.spring.db.springjdbctojpa.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebsonic2o.spring.db.springjdbctojpa.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}

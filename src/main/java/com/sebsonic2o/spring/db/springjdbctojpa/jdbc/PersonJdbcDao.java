package com.sebsonic2o.spring.db.springjdbctojpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sebsonic2o.spring.db.springjdbctojpa.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();

			person.setId(rs.getInt("id"));
			person.setName(rs.getString("first_name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));

			return person;
		}
	}

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person",
				new PersonRowMapper());
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?",
				new PersonRowMapper(),
				id);
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", id);
	}

	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, first_name, location, birth_date) values(?, ?, ?, ?)",
				person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
	}

	public int update(Person person) {
		return jdbcTemplate.update("update person set first_name = ?, location = ?, birth_date = ? where id = ?",
				person.getName(), person.getLocation(), person.getBirthDate(), person.getId());
	}
}

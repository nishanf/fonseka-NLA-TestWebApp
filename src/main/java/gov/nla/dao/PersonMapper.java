package gov.nla.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import gov.nla.model.Person;


/**
 * Mapper class to transform ResultSet into value object Person
 * 
 * Returns value object Person
 * 
 * @author Nishan Fonseka
 *
 */
public class PersonMapper implements ResultSetMapper<Person> {

	public Person map(int index, ResultSet rs, StatementContext ctx)
			throws SQLException {

		return new Person(rs.getInt("PersonId"), rs.getString("Email"),
				rs.getString("Name"), rs.getString("Phone"));
	}
}

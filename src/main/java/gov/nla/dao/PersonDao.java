package gov.nla.dao;

import gov.nla.model.Person;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * PersonDao for defining all sql queries for the Person table using JDBI
 * Uses mapper class PersonMapper to transform result set into value object
 * 
 * @author Nishan Fonseka
 *
 */
@RegisterMapper(PersonMapper.class)
public interface PersonDao {

	  @SqlQuery("select PersonId, Email, Name, Phone from Person where PersonId = :personId")
	  Person findByPersonId(@Bind("personId") int personId);
	  
	  @SqlQuery("select PersonId, Email, Name, Phone from Person")
	  List<Person> findAllPersons();
}
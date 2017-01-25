package gov.nla.service;

import gov.nla.dao.PersonDao;
import gov.nla.model.Person;

import java.util.List;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Service implementation class for Person table interaction via PersonDao
 * Calls PersonDao defined methods and return results
 * 
 * @author Nishan Fonseka
 *
 */
@Repository
public class PersonServiceImpl implements PersonServce
{
	
	private DataSource dataSource;
	
	/**
	 * Autowire dataSource and enable dependency injection for testing
	 * @param dataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	

	/**
	 * Create a new PersonDao sql object which will obtain and release connections from this dbi instance, 
	 * as it needs to, and can, respectively. You should not explicitely close this sql object
	 * @return
	 */
	private PersonDao getPersonDao() {
		
		DBI dbi = new DBI(dataSource);
		PersonDao dao = dbi.onDemand(PersonDao.class);
		
		return dao;
	}
	
	public Person findByPersonId(int personId) {
		
		PersonDao dao = getPersonDao();
        Person person = dao.findByPersonId(personId);
        
		return person;
	}
	
	public List<Person> findAllPersons() {
		
		PersonDao dao = getPersonDao();
        List<Person> list = dao.findAllPersons();
        
		return list;
	}
	
}

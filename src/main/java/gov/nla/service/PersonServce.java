package gov.nla.service;

import gov.nla.model.Person;

import java.util.List;


/**
 * Interface for defining methods for PersonServce
 * 
 * @author Nishan Fonseka
 *
 */
public interface PersonServce {

	
    public Person findByPersonId(int personId);
	
	public List<Person> findAllPersons();
	
}

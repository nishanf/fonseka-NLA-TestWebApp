package gov.nla.service;


import gov.nla.model.Person;
import gov.nla.service.PersonServiceImpl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Test cases for testing in memory database to ensure JDBI queries work 
 * and return valid objects.
 * Test the Person service methods which in turn calls into the in memory database
 * 
 * @author Nishan Fonseka
 *
 */
public class PersonServiceTest {

    private EmbeddedDatabase dataSource;

    PersonServiceImpl personService = null;
    
    /**
     * Sets up the database and injects the database into PersonServiceImpl
     */
    @Before
    public void setUp() {
        
    	dataSource = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.H2)
    		.addScript("db/sql/create-db.sql")
    		.addScript("db/sql/insert-data.sql")
    		.build();
    	
    	personService = new PersonServiceImpl();
    	personService.setDataSource(dataSource);
    }
    

    @Test
    public void testfindAllPersons() {
    	
    	List<Person> personList = personService.findAllPersons();
  
    	Assert.assertNotNull(personList);
    	Assert.assertEquals(3, personList.size());
    	Assert.assertEquals("Nishan Fonseka", personList.get(0).getName());
    	Assert.assertEquals("nishan@gmail.com", personList.get(0).getEmail());
    }


    @Test
    public void testfindByPersonId() {
    	
    	Person person = personService.findByPersonId(1);
  
    	Assert.assertNotNull(person);
    	Assert.assertEquals("Nishan Fonseka", person.getName());
    	Assert.assertEquals("nishan@gmail.com", person.getEmail());
    }    
    
    @After
    public void tearDown() {
    	personService = null;
    	dataSource.shutdown();
    }

}
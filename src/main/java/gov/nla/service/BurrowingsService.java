package gov.nla.service;

import gov.nla.model.Book;
import gov.nla.model.Burrowing;

import java.util.List;


/**
 * Interface for defining methods for BurrowingsService
 * 
 * @author Nishan Fonseka
 *
 */
public interface BurrowingsService {

	public List<Burrowing> findBurrowingsByPersonId(int personId);
	
	public List<Book> findBooksByPersonId(int personId);
	
}

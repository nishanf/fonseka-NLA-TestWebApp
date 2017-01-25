package gov.nla.service;

import gov.nla.dao.BurrowingsDao;
import gov.nla.model.Book;
import gov.nla.model.Burrowing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Service implementation class for Burrowings table interaction via BurrowingsDao
 * Calls BurrowingsDao defined methods and return results
 * 
 * @author Nishan Fonseka
 *
 */
@Repository
public class BurrowingsServiceImpl implements BurrowingsService
{
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BookService bookService;
	
	
	public List<Burrowing> findBurrowingsByPersonId(int personId) {
		
		DBI dbi = new DBI(dataSource);
		BurrowingsDao dao = dbi.onDemand(BurrowingsDao.class);
		List<Burrowing> list = dao.findBurrowingsByPersonId(personId);
        
		return list;
	}
	
	public List<Book> findBooksByPersonId(int personId) {
		
		List<Book> bookList = new ArrayList<Book>();
		
		List<Burrowing> burrowingList = findBurrowingsByPersonId(personId);
		
		for (Iterator<Burrowing> iterator = burrowingList.iterator(); iterator.hasNext();) {
			
			Burrowing burrowing = iterator.next();
			String isbn = burrowing.getIsbn();
			
			Book book = bookService.findBookByISBN(isbn);
			bookList.add(book);
		}
		
		return bookList;
	}

}

package gov.nla.service;

import gov.nla.dao.BookDao;
import gov.nla.model.Book;

import java.util.List;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Service implementation class for Book table interaction via BookDao
 * Calls BookDao defined methods and return results
 * 
 * @author Nishan Fonseka
 *
 */
@Repository
public class BookServiceImpl implements BookService
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
	 * Create a new BookDao sql object which will obtain and release connections from this dbi instance, 
	 * as it needs to, and can, respectively. You should not explicitely close this sql object
	 * @return
	 */
	private BookDao getBookDao() {
		
		DBI dbi = new DBI(dataSource);
		BookDao dao = dbi.onDemand(BookDao.class);
		
		return dao;
	}
	
	public Book findBookByISBN(String isbn) {
		
		BookDao dao = getBookDao();
        Book boook = dao.findBookByISBN(isbn);
        
		return boook;
	}
	
	public List<Book> findAllBooks() {
		
		BookDao dao = getBookDao();
		List<Book> list = dao.findAllBooks();
        
		return list;
	}

}

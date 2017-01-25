package gov.nla.service;


import gov.nla.model.Book;
import gov.nla.service.BookServiceImpl;

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
 * Test the Book service methods which in turn calls into the in memory database
 * 
 * @author Nishan Fonseka
 *
 */
public class BookServiceTest {

    private EmbeddedDatabase dataSource;

    BookServiceImpl bookService = null;
    
    /**
     * Sets up the database and injects the database into BookServiceImpl
     */
    @Before
    public void setUp() {
        
    	dataSource = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.H2)
    		.addScript("db/sql/create-db.sql")
    		.addScript("db/sql/insert-data.sql")
    		.build();
    	
    	bookService = new BookServiceImpl();
    	bookService.setDataSource(dataSource);
    }
    

    @Test
    public void testfindAllBooks() {
    	
    	List<Book> bookList = bookService.findAllBooks();
  
    	Assert.assertNotNull(bookList);
    	Assert.assertEquals(8, bookList.size());
    	Assert.assertEquals("Sun Tzu", bookList.get(2).getAuthor());
    	Assert.assertEquals("The Art of War", bookList.get(2).getTitle());
    }

    
    @Test
    public void testfindBookByISBN() {
    	
    	Book book = bookService.findBookByISBN("1402213131");
  
    	Assert.assertNotNull(book);
    	Assert.assertEquals("Robert Louis Stevenson", book.getAuthor());
    	Assert.assertEquals("Treasure Island", book.getTitle());
    }    
    
    @After
    public void tearDown() {
    	bookService = null;
    	dataSource.shutdown();
    }

}

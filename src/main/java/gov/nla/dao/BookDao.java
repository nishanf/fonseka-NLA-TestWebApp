package gov.nla.dao;

import gov.nla.model.Book;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * BookDao for defining all sql queries for the Book table using JDBI
 * Uses mapper class BookMapper to transform result set into value object
 * 
 * @author Nishan Fonseka
 *
 */
@RegisterMapper(BookMapper.class)
public interface BookDao {
	  
	  @SqlQuery("select ISBN, Title, Author from Book where ISBN = :isbn")
	  Book findBookByISBN(@Bind("isbn") String isbn);
	  
	  @SqlQuery("select ISBN, Title, Author from Book")
	  List<Book> findAllBooks();
}
package gov.nla.dao;

import gov.nla.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * Mapper class to transform ResultSet into value object Book
 * 
 * Returns value object Book
 * 
 * @author Nishan Fonseka
 *
 */
public class BookMapper implements ResultSetMapper<Book> {

	public Book map(int index, ResultSet rs, StatementContext ctx)
			throws SQLException {

		return new Book(rs.getString("ISBN"),
				rs.getString("Title"), rs.getString("Author"));
	}
}

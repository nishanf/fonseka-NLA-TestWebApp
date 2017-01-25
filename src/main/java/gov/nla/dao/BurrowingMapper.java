package gov.nla.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import gov.nla.model.Burrowing;


/**
 * Mapper class to transform ResultSet into value object Burrowing
 * 
 * Returns value object Burrowing
 * 
 * @author Nishan Fonseka
 *
 */
public class BurrowingMapper implements ResultSetMapper<Burrowing> {

	public Burrowing map(int index, ResultSet rs, StatementContext ctx)
			throws SQLException {

		return new Burrowing(rs.getInt("PersonId"), rs.getString("ISBN"));
				
	}
}

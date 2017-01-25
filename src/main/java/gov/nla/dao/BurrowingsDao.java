package gov.nla.dao;

import java.util.List;

import gov.nla.model.Burrowing;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * BurrowingsDao for defining all sql queries for the Burrowings table using JDBI
 * Uses mapper class BurrowingMapper to transform result set into value object
 * 
 * @author Nishan Fonseka
 *
 */
@RegisterMapper(BurrowingMapper.class)
public interface BurrowingsDao {
  
	  @SqlQuery("select PersonId, ISBN from Burrowings where PersonId = :personId")
	  List<Burrowing> findBurrowingsByPersonId(@Bind("personId") int personId);
	  
}
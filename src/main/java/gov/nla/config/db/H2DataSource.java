package gov.nla.config.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * 
 * @author Nishan Fonseka
 *
 */
@Configuration
public class H2DataSource {

	
	/**
	 * Creates in memory database using static sql files at start up
	 * 
	 * This is where reference to a real database can be plugged in
	 * 
	 * @return datSource for in memory database
	 */
	@Bean
	public DataSource dataSource() {

		// jdbc:h2:mem:testdb
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("db/sql/create-db.sql").addScript("db/sql/insert-data.sql").build();
		return db;

	}

}
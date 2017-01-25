package gov.nla.model;


/**
 * Value object class for Burrowing table
 * 
 * @author Nishan Fonseka
 *
 */
public class Burrowing {

	private int personId;
	private String isbn;

	
	public Burrowing(int personId, String isbn) {
		super();
		this.personId = personId;
		this.isbn = isbn;
	}


	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	@Override
	public String toString() {
		return "Burrowing [personId=" + personId + ", isbn=" + isbn + "]";
	}

}

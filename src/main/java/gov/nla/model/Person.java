package gov.nla.model;


/**
 * Value object class for Person table
 * 
 * @author Nishan Fonseka
 *
 */
public class Person {

	private int personId;
	private String email;
	private String name;
	private String phone;

	public Person(int personId, String email, String name, String phone) {
		super();
		this.personId = personId;
		this.email = email;
		this.name = name;
		this.phone = phone;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", email=" + email + " phone=" + phone + "]";
	}

}

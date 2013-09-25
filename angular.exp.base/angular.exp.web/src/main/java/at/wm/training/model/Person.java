package at.wm.training.model;

public class Person {

	private String id;
	private String firstname;
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public Person setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public Person setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getId() {
		return id;
	}

	public Person setId(String id) {
		this.id = id;
		return this;
	}
}
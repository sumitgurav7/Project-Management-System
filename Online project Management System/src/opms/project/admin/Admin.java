package opms.project.admin;

public class Admin {
	String email;
	String contact;
	String name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Admin(String email, String contact, String name) {
		super();
		this.email = email;
		this.contact = contact;
		this.name = name;
	}
	
	
}

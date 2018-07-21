package opms.project.faculty;

public class Faculty {
	
	private String email_id,name,department,designation;
	private String contact_no;
	
	public Faculty() {
		// TODO Auto-generated constructor stub
	}
	
	public Faculty(String email_id, String name, String department, String designation, String phn) {
		super();
		this.email_id = email_id;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.contact_no = phn;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	
	
	
}

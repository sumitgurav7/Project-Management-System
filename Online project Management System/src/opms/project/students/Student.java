package opms.project.students;

public class Student {
	String fname;
	String prn;
	String email;
	String deptartment;
	String contact_no;
	long   projectId;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getPnr() {
		return prn;
	}
	public void setPnr(String pnr) {
		this.prn = pnr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDeptartment() {
		return deptartment;
	}
	public void setDeptartment(String deptartment) {
		this.deptartment = deptartment;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public Student(String fname, String pnr, String email, String deptartment, String contact_no, long projectId) {
		super();
		this.fname = fname;
		this.prn = pnr;
		this.email = email;
		this.deptartment = deptartment;
		this.contact_no = contact_no;
		this.projectId = projectId;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
}

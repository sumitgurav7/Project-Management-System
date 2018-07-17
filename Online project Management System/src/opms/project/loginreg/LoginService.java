package opms.project.loginreg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opms.project.admin.Admin;
import opms.project.faculty.Faculty;
import opms.project.students.*;

@Service
public class LoginService {

	private LoginDao ld;
	
	@Autowired
	public void setLd(LoginDao ld) {
		this.ld = ld;
	}

	public boolean createNewStudentLogin(String pnr, String fname, String dept, String contact_no, String email){
		Student st = new Student(fname, pnr, email, dept, contact_no, 0);
		boolean res = ld.newStudentRegister(st);
		return res;
	}

	public boolean createNewFaculty(String email, String fname, String dept, String desig, String phn) {
		
		Faculty fc =new Faculty(email,fname,dept,desig,phn);
		boolean res = ld.newFacultyRegister(fc);
		return res;
		// TODO Auto-generated method stub
		
	}

	public boolean createNewAdmin(String email, String fname, String phn) {
		Admin ad = new Admin(email, phn, fname);
		boolean res = ld.newAdminRegister(ad);
		return res;
	}
}

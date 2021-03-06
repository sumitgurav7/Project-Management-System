package opms.project.loginreg;

import java.util.Random;

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

	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(Integer.MAX_VALUE) + 1;
	}
	
	public boolean createNewRegistration(String fname, String email, String phn, String type, String dept,
                                 String desig, String pnr, String password, String url) {
	boolean result = false;
	
	int randNum = generateRandomNumber();
	
	if(type.equalsIgnoreCase("faculty") || type.equalsIgnoreCase("admin")) {
		result = ld.createNewLogin(email, password, randNum);
	} else {
		result = ld.createNewLogin(pnr, password, randNum);
	}
	if(result) {
		if(type.equalsIgnoreCase("faculty")) {
			result = createNewFaculty(email,fname,dept,desig,phn, password, randNum);
			SendEmail.send(email, randNum, url, email);
		} else if (type.equalsIgnoreCase("student")) {
			result = createNewStudentLogin(pnr, fname, dept, phn, email, password, randNum);
			SendEmail.send(email, randNum, url, pnr);
		} else if(type.equalsIgnoreCase("admin")) {
			result = createNewAdmin(email, fname, phn, password, randNum);
			SendEmail.send(email, randNum, url, email);
		}
	} else {
		if(type.equalsIgnoreCase("faculty") || type.equalsIgnoreCase("admin")) {
			ld.deleteLogin(email);
		} else {
			ld.deleteLogin(pnr);
		}
		return false;
	}
	return result;
	}
	
	

	public boolean createNewStudentLogin(String pnr, String fname, String dept, String contact_no, 
									String email, String password, int randNum){
		Student st = new Student(fname, pnr, email, dept, contact_no, 0);
		boolean res = ld.newStudentRegister(st);
		return res;
	}

	public boolean createNewFaculty(String email, String fname, String dept, String desig, String phn, 
							String password, int randNum) {
		
		Faculty fc =new Faculty(email,fname,dept,desig,phn);
		boolean res = ld.newFacultyRegister(fc);
		return res;
		// TODO Auto-generated method stub
		
	}

	public boolean createNewAdmin(String email, String fname, String phn, String password, int randNum) {
		Admin ad = new Admin(email, phn, fname);
		boolean res = ld.newAdminRegister(ad);
		return res;
	}	
	
	
	
	
	/*
	 * 
	 * Below this line its my code so altering is allowed
	 * 
	 * 
	 * */
	public boolean studServLog(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("in student service" + username);
		boolean validate = ld.studValidate(username,password);
		
		return validate;
	}

	public boolean faculServLog(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("in faculty service" + username);
		boolean validate = ld.faculValidate(username,password);
		
		return validate;
		
	}

	public boolean adminServLog(String username, String password) {
		// TODO Auto-generated method stub
		
		System.out.println("in admin service" + username);
		boolean validate = ld.adminValidate(username,password);
		
		return validate;
		
	}

	public boolean verifyEmailId(String username, int code) {
		return ld.verifyEmailId(username, code);
	}
}

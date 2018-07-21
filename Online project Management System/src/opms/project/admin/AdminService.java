package opms.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opms.project.faculty.Faculty;
import opms.project.students.Student;

@Service
public class AdminService {

	private AdminDao ad;
	
	@Autowired	
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}




	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		return ad.getAllStudentsDao();
	}




	public List<Faculty> getAllFaculty() {
		// TODO Auto-generated method stub
		return ad.getAllFacultyDao();
	}




	public List<Faculty> delFaculty(String fac) {
		// TODO Auto-generated method stub
		return ad.delFacultyDao(fac);
	}




	public List<Student> delStudent(String pnr) {
		// TODO Auto-generated method stub
		return ad.delStudentDao(pnr);
	}

}

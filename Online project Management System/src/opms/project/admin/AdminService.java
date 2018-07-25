package opms.project.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opms.project.faculty.Faculty;
import opms.project.loginreg.Login;
import opms.project.project.ProjectObject;
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

	public List<Login> getAllPendingLogins() {
		return ad.getAllPendingLogins();
	}

	public List<ProjectObject> getAllPendingProjects() {
		return ad.getAllPendingProjects();
	}

	public boolean updateLogin(String username, int value) {
		return ad.updateLogin(username, value);
	}

	public boolean updateProject(String projectId, int value) {
		return ad.updateProject(projectId, value);
	}

	public List<ProjectObject> getGuidePendingProjects() {
		return ad.getGuidePendingProjects();
	}

	public List<Faculty> getAllFacultyList() {
		return ad.getAllFacultyList();
	}

	public boolean assignFacultyToProject(String projectId, String facultyMailId) {
		return ad.assignFacultyToProject(projectId, facultyMailId);
	}

	public ProjectObject getProjectById(int project_id) {
		return ad.getProjectDetailsById(project_id);
	}

	public List<Student> getAllStudentsByProjectId(int project_id) {
		return ad.getAllStudentsByProjectId(project_id);
	}

	public boolean removeStudentsFromProject(ArrayList<String> studentList) {
		return ad.removeStudentsFromProject(studentList);
	}

	public boolean deleteStudent(String prn) {
		return ad.deleteStudent(prn);
	}

	public boolean deleteFaculty(String id) {
		return ad.deleteFaculty(id);
	}

	public boolean updateStudent(String prn, String name, String dept, String phn, int pid) {
		return ad.updateStudent(prn, name, dept, phn, pid);
	}

	public boolean updateFaculty(String email, String name, String dept, String phn, String desig) {
		return ad.updateFaculty(email, name, dept, phn, desig);
	}

	public List<Student> getStudentByCondition(String searchtype, String searchValue) {
		return ad.getStudentByCondition(searchtype, searchValue);
	}
	
	public List<Faculty> getFacultyByCondition(String searchtype, String searchValue) {
		return ad.getFacultyByCondition(searchtype, searchValue);
	}
}

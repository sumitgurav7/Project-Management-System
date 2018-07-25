package opms.project.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import opms.project.project.ProjectObject;
import opms.project.students.Student;

@Service
@Component
public class Guestservice {

	private GuestDao gd;
	@Autowired
	public void setGd(GuestDao gd) {
		this.gd = gd;
	}

	public List<ProjectObject> getAllProject() {
		// TODO Auto-generated method stub
		
		System.out.println("guest servuce");
		
		return gd.getAllProjectDao();
	}
	
	
	public ProjectObject getProjectById(int project_id) {
		return gd.getProjectDetailsById(project_id);
	}

	public List<Student> getAllStudentsByProjectId(int project_id) {
		return gd.getAllStudentsByProjectId(project_id);
	}
	
	
}

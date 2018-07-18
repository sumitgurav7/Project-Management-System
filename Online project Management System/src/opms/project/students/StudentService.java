package opms.project.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opms.project.project.ProjectObject;

@Service
public class StudentService {
	
	StudentDao sd;

	@Autowired
	public void setSd(StudentDao sd) {
		this.sd = sd;
	}
	
	public String getStudentNameByPnr(String pnr) {
		return sd.getStudentNameByPnr(pnr);
	}

	public boolean createNewProject(ProjectObject po) {
		int sum = sd.getSumOfProjectIds(po.getMembers());
		boolean result = false;
		if(sum == 0) {
			int projectid = sd.createNewProjectEntry(po);
			if(projectid > 0) {
				result = sd.updateProjectForStudent(po.getMembers(), projectid);
			}
		} 
		return result;
	}
}

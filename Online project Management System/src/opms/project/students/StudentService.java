package opms.project.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opms.project.comments.Comment;
import opms.project.files.file;
import opms.project.project.ProjectObject;
import opms.project.status.Status;

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

	public ProjectObject returnReport(String username) {
		// TODO Auto-generated method stub
		return sd.returnReportDao(username);
	}

	public List<Student> returnMembers(int projectId) {
		// TODO Auto-generated method stub
		return sd.returnMembersDao(projectId);
	}

	public boolean sqlUploads(String uPLOADED_FOLDER, String fileName, String username) {
		// TODO Auto-generated method stub
		return sd.sqlUploadsDao(uPLOADED_FOLDER, fileName, username);
	}

	public List<file> getListOfFiles(String username) {
		// TODO Auto-generated method stub
		
		
		
		return sd.getListOfFiles(username);
	}

	public file getDownloadFile(String upload_id) {
		// TODO Auto-generated method stub
		
		
		return sd.getDownloadFileDao(upload_id);
	}

	public List<Comment> getCommentByProjectId(int projectId) {
		return sd.getCommentByProjectId(projectId);
	}

	public boolean addNewComment(String projectId, String newComment, String username) {
		return sd.addNewComment(projectId, newComment, username);
	}

	public boolean addNewStatus(String projectId, String newStatus, String username) {
		return sd.addNewStatus(projectId, newStatus, username);
	}

	public List<Status> getStatusByProjectId(int projectId) {
		return sd.getStatusByProjectId(projectId);
	}
}

package opms.project.faculty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opms.project.comments.Comment;
import opms.project.files.file;
import opms.project.project.ProjectObject;
import opms.project.status.Status;
import opms.project.students.Student;

@Service
public class FacultyService {

	
	private FacultyDao fd;

	@Autowired
	public void setFd(FacultyDao fd) {
		this.fd = fd;
	}

	public List<ProjectObject> getProjectList(String username) {
		// TODO Auto-generated method stub
		return fd.gteProjectsFromDao(username);
	}

	public ProjectObject getProjectById(int project_id) {
		return fd.getProjectDetailsById(project_id);
	}

	public List<Student> getAllStudentsByProjectId(int project_id) {
		return fd.getAllStudentsByProjectId(project_id);
	}
	
	
	public boolean sqlUploads(String uPLOADED_FOLDER, String fileName, String username) {
		// TODO Auto-generated method stub
		return fd.sqlUploadsDao(uPLOADED_FOLDER, fileName, username);
	}

	public List<file> getListOfFiles(String username) {
		// TODO Auto-generated method stub
		
		
		
		return fd.getListOfFiles(username);
	}

	public file getDownloadFile(String upload_id) {
		// TODO Auto-generated method stub
		
		
		return fd.getDownloadFileDao(upload_id);
	}
	
	public List<Status> getStatusByProjectId(String projectId) {
		return fd.getStatusByProjectId(projectId);
		
	}
	
	public List<Comment> getCommentByProjectId(String projectId) {
		return fd.getCommentByProjectId(projectId);
	}
	
	public boolean addNewComment(String projectId, String newComment, String username) {
		System.out.println("project id at service comment is " + projectId);
		return fd.addNewComment(projectId, newComment, username);
	}
}

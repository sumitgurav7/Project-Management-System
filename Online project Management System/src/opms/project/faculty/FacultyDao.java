package opms.project.faculty;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import opms.project.admin.getProjectDataAdmin;
import opms.project.admin.getStudentDataAdmin;
import opms.project.files.file;
import opms.project.project.ProjectObject;
import opms.project.students.Student;
import opms.project.students.getRetriveFile;
import opms.project.students.getUploadStudDataAdmin;

@Repository
public class FacultyDao {

	
	private JdbcTemplate t;
	
	@Autowired
	public void setT(JdbcTemplate t) {
		this.t = t;
	}

	public List<ProjectObject> gteProjectsFromDao(String username) {
		// TODO Auto-generated method stub
		
		List<ProjectObject> list = null;
		String cmd = "select * from project where guide = '"+username+"'";
		RowMapper<ProjectObject> rw = new getProjectDataAdmin();
		list = t.query(cmd, rw);
		if(list.size()>0)
			{return list;}
		else
			{return list;}
		
		
	}

	
	public ProjectObject getProjectDetailsById(int project_id) {
		String cmd = "select * from project where project_id = ?";
		Object[] x = {project_id};
		RowMapper<ProjectObject> rw = new getProjectDataAdmin();
		List<ProjectObject> list = t.query(cmd, x, rw);
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	public List<Student> getAllStudentsByProjectId(int project_id) {
		List<Student> list = null;
		String cmd = "select * from student where project_id = ?";
		Object fillValue[] = {project_id};
		RowMapper<Student> rw = new getStudentDataAdmin();
		list = t.query(cmd, fillValue, rw);
		return list;
	}
	
	public file getDownloadFileDao(String upload_id) {
		// TODO Auto-generated method stub
		
		List<file> files = null;
		
		String cmand = "SELECT `upload_id`, `filename`, `filepath`, `filehash`, `timestamp`, `project_id`, `uploaded_by` FROM `files` WHERE upload_id = ? ";
		Object valuesFileFill[] = {upload_id};
		RowMapper<file> romapFile = new getRetriveFile();
		files = t.query(cmand, valuesFileFill, romapFile);
		System.out.println("file name is in dao");
		if(files.isEmpty())
		{System.out.println("files are not available");}
		else {System.out.println(files.get(0).getFilename());}
		if(files.size()>0)
		{
			return files.get(0);
		}
		
		
		
		return null;
		
	
	}
	
	
	
	public List<file> getListOfFiles(String username) {
		// TODO Auto-generated method stub
		
		List<file> files = null;
		
		/*String cmad = "select project_id from student where pnr =?";
		Object valuesFill[] = {username};
		RowMapper<Integer> romap = new getUploadStudDataAdmin();
		List<Integer> project = t.query(cmad, valuesFill, romap);
		
		int project_id;
		
		if(project.isEmpty())
		{project_id=0;
		System.out.println("project id not available");
		}
		else
		{project_id=project.get(0);
				System.out.println("guide " + project_id);
		}*/
		
		
		int project_id;
		String cmd = "SELECT * FROM `project` WHERE `guide` = ?";
		Object valuesFillFac[] = {username};
		RowMapper<ProjectObject> romapfac = new getProjectDataAdmin();
		List<ProjectObject> projFac = t.query(cmd, valuesFillFac, romapfac);
		if(projFac.isEmpty())
		{project_id=0;
		System.out.println("project id not available");
		}
		else
		{project_id=projFac.get(0).getProjectId();
				System.out.println("guide " + project_id);
		}	
				
				
		String cmand = "SELECT `upload_id`, `filename`, `filepath`, `filehash`, `timestamp`, `project_id`, `uploaded_by` FROM `files` WHERE project_id=?";
		Object valuesFileFill[] = {project_id};
		RowMapper<file> romapFile = new getRetriveFile();
		files = t.query(cmand, valuesFileFill, romapFile);
		System.out.println("file name is in dao");
		if(files.isEmpty())
		{System.out.println("files are not available");}
		else {System.out.println(files.get(0).getFilename());}
		if(files.size()>0)
		{
			return files;
		}
		
		
		
		return null;
	}

	
	
	public boolean sqlUploadsDao(String uPLOADED_FOLDER, String fileName, String username) {
		// TODO Auto-generated method stub
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String cmad = "select project_id from project where guide =?";
		Object valuesFill[] = {username};
		RowMapper<Integer> romap = new getUploadStudDataAdmin();
		List<Integer> project = t.query(cmad, valuesFill, romap);
		int project_id=project.get(0);
		
		String command = "INSERT INTO `files`(`filename`, `filepath`, `filehash`, `timestamp`, `project_id`, `uploaded_by`) VALUES (?,?,?,?,?,?)";
		Object valuesToFill[] = {fileName,uPLOADED_FOLDER,0,new Date(),project_id,username};
		int rows= t.update(command, valuesToFill);
		if(rows>0)
		{
			return true;
		}
		
		return false;
	}
	
	
}

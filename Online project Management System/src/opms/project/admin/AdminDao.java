package opms.project.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import opms.project.faculty.Faculty;
import opms.project.loginreg.Login;
import opms.project.project.ProjectObject;
import opms.project.students.Student;
import opms.project.students.getStudentInfo;

@Repository
public class AdminDao {

	private JdbcTemplate t;
	
	@Autowired
	public void setT(JdbcTemplate t) {
		this.t = t;
	}

	public List<Student> getAllStudentsDao() {
		// TODO Auto-generated method stub
		List<Student> list = null;
		String cmd = "select * from student where ?";
		Object fillValue[] = {1};
		RowMapper<Student> rw = new getStudentDataAdmin();
		list = t.query(cmd, fillValue, rw);
		if(list.size()>0)
			{return list;}
		else
			{return list;}
	}

	public List<Faculty> getAllFacultyDao() {
		// TODO Auto-generated method stub
		List<Faculty> list = null;
		String cmd = "select * from faculty where ?";
		Object fillValue[] = {1};
		RowMapper<Faculty> rw = new getFacultyDataAdmin();
		list = t.query(cmd, fillValue, rw);
		if(list.size()>0)
			{return list;}
		else
			{return list;}
	}

	public List<Faculty> delFacultyDao(String fac) {
		// TODO Auto-generated method stub
		List<Faculty> list = null;
		String cmd = "DELETE FROM `faculty` WHERE email_id = ?";
		Object fillValue[] = {fac};
		
		int i = t.update(cmd, fillValue);
		list = getAllFacultyDao();
		if(list.size()>0)
			{return list;}
		else
			{return list;}
	
	}

	public List<Student> delStudentDao(String pnr) {
		// TODO Auto-generated method stub
		List<Student> list = null;
		String cmd = "DELETE FROM `student` WHERE pnr = ?";
		Object fillValue[] = {pnr};
		
		int i = t.update(cmd, fillValue);
		list = getAllStudentsDao();
		if(list.size()>0)
			{return list;}
		else
			{return list;}
	}

	public List<Login> getAllPendingLogins() {
		List<Login> list = null;
		String cmd = "select * from login_table where enabled = 0";
		RowMapper<Login> rw = new getLoginDataAdmin();
		list = t.query(cmd, rw);
		if(list.size()>0)
			{return list;}
		else
			{return list;}
	}

	public List<ProjectObject> getAllPendingProjects() {
		List<ProjectObject> list = null;
		String cmd = "select * from project where status = 0";
		RowMapper<ProjectObject> rw = new getProjectDataAdmin();
		list = t.query(cmd, rw);
		if(list.size()>0)
			{return list;}
		else
			{return list;}
	}
	
	public boolean updateLogin(String username, int value) {
		String cmd = "";
		int row = 0;
		if(value == 1) {
			cmd = "Update login_table set enabled=? where username= ?";
			username = username.replaceAll("\\s+","");
			Object[] x = {value, username};
			row = t.update(cmd, x);
		} else if(value == 2) {
			cmd = "delete from login_table where username = ?";
			username = username.replaceAll("\\s+","");
			Object[] x = {username};
			row = t.update(cmd, x);
		}
		
		if(row <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean updateProject(String projectId, int value) {
		String cmd = "Update project set status=? where project_id= ?";
		Object[] x = {value, projectId};
		System.out.println(cmd);
		int row = t.update(cmd, x);
		if(row <= 0) {
			return false;
		}
		return true;
	}

	public List<ProjectObject> getGuidePendingProjects() {
		List<ProjectObject> list = null;
		String cmd = "select * from project where status != 2 and guide = ?";
		Object[] x = {""};
		RowMapper<ProjectObject> rw = new getProjectDataAdmin();
		list = t.query(cmd, rw, x);
		if(list.size()>0) {
			return list;
		}
		else{
			return list;
		}
	}

	public List<Faculty> getAllFacultyList() {
		List<Faculty> list = null;
		String cmd = "select * from faculty";
		RowMapper<Faculty> rw = new getFacultyDataAdmin();
		list = t.query(cmd, rw);
		return list;
	}

	public boolean assignFacultyToProject(String projectId, String facultyMailId) {
		String cmd = "Update project set guide=? where project_id= ?";
		Object[] x = {facultyMailId, projectId};
		System.out.println(cmd);
		int row = t.update(cmd, x);
		if(row <= 0) {
			return false;
		}
		return true;
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

	public boolean removeStudentsFromProject(ArrayList<String> studentList) {
		StringBuilder sb = new StringBuilder("Update student set project_id=0 where pnr in (");
		int counter = 0;
		for(String s : studentList) {
			s = s.replaceAll("\\s+","");
			sb.append('"'+ s + '"');
			counter++;
			if(counter < studentList.size())
				sb.append(',');
		}
		String cmd = sb.append(")").toString();
		System.out.println(cmd);
		int row = t.update(cmd);
		if(row <= 0) {
			return false;
		}
		return true;
	}

}

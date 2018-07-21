package opms.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import opms.project.faculty.Faculty;
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
	
}

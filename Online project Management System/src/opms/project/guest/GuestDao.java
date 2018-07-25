package opms.project.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import opms.project.admin.getProjectDataAdmin;
import opms.project.admin.getStudentDataAdmin;
import opms.project.project.ProjectObject;
import opms.project.students.Student;


@Repository
@Component
public class GuestDao {

	private JdbcTemplate t;
	
	@Autowired
	public void setT(JdbcTemplate t) {
		this.t = t;
	}

	
	
	
	public List<ProjectObject> getAllProjectDao() {
		// TODO Auto-generated method stub
		System.out.println("guest Daolayer");
		List<ProjectObject> list = null;
		String cmd = "SELECT * FROM `project` WHERE 1";
		RowMapper<ProjectObject> rw = new getProjectDataAdmin();
		list = t.query(cmd, rw);
		System.out.println("size of List");
		System.out.println(list.size());
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
}

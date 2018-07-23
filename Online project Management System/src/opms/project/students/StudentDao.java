package opms.project.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;

import opms.project.admin.getStudentDataAdmin;
import opms.project.project.ProjectObject;


@Repository
public class StudentDao {

	private JdbcTemplate t;
	
	@Autowired
	public void setT(JdbcTemplate t) {
		this.t = t;
	}

	public String getStudentNameByPnr(String pnr) {
		String cmd = "select name from student where pnr=?";
		Object x[] = {pnr};
		RowMapper<String> rw = new getStudentInfo();
		List<String> list = t.query(cmd, x, rw);
		if(list.size()>0)
		
			return list.get(0);
		else
			return "";
	}

	public int getSumOfProjectIds(ArrayList<String> members) {
		StringBuilder sb = new StringBuilder("SELECT sum(if(project.status = 2, 0, project.project_id)) as sum FROM `project` JOIN student ON student.pnr in(");
		int counter = 0;
		for(String s : members) {
			s = s.replaceAll("\\s+","");
			sb.append('"'+ s + '"');
			counter++;
			if(counter < members.size())
				sb.append(',');
		}
		String cmd = sb.append(") and student.project_id = project.project_id").toString();
		System.out.println(cmd);
		Object x[] = {};
		RowMapper<Integer> rw = new getProjectSum();
		List<Integer> list = t.query(cmd, x, rw);
		if(list.size()>0) {
			return list.get(0);
		}
		return -1;
	}

	public int createNewProjectEntry(ProjectObject po) {
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		String cmd = "insert into project values(?,?,?,?,?,?,?,?)";
		t.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(cmd, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, 0);
				ps.setString(2, po.getTitle());
				ps.setString(3, po.getAbs());
				ps.setString(4, "");
				ps.setString(5, po.getLead());
				ps.setDate(6, java.sql.Date.valueOf(LocalDate.now()));
				ps.setDate(7, java.sql.Date.valueOf(LocalDate.now().plusMonths(1)));
				ps.setInt(8, 0);
				return ps;
			}
		}, holder);
		int newProjectId = holder.getKey().intValue();
		return newProjectId;
	}

	public boolean updateProjectForStudent(ArrayList<String> members, int projectId) {
		StringBuilder sb = new StringBuilder("Update student set project_id=? where pnr in (");
		int counter = 0;
		for(String s : members) {
			s = s.replaceAll("\\s+","");
			sb.append('"'+ s + '"');
			counter++;
			if(counter < members.size())
				sb.append(',');
		}
		String cmd = sb.append(")").toString();
		System.out.println(cmd);
		Object x[] = {projectId};
		int row = t.update(cmd, x);
		if(row <= 0) {
			return false;
		}
		return true;
	}

	public ProjectObject returnReportDao(String username) {
		// TODO Auto-generated method stub
		String pnr = username;
		String cmd = "select project_id from student where pnr=?";
		Object x[] = {pnr};
		RowMapper<Integer> rw = new getStudentProjectInfo();
		List<Integer> pr_id = t.query(cmd, x, rw);
		Integer project_id;
		if(pr_id.size()>0)
		{ 	project_id = pr_id.get(0);
			String cmad = "select * from project where project_id =?";
			Object valuesFill[] = {project_id};
			RowMapper<ProjectObject> romap = new getProjectInfo();
			List<ProjectObject> project = t.query(cmad, valuesFill, romap);
			if(project.size()>0)
				{return project.get(0);}
			else
			{return null;}
		}	
		else
			return null;
		
		
	}

	public List<Student> returnMembersDao(int projectId) {
		// TODO Auto-generated method stub
		
		
		String cmad = "select * from student where project_id =?";
		Object valuesFill[] = {projectId};
		RowMapper<Student> romap = new getStudentDataAdmin();
		List<Student> project = t.query(cmad, valuesFill, romap);
		if(project.size()>0)
			{return project;}
	else
		return null;
		
		
	}

}

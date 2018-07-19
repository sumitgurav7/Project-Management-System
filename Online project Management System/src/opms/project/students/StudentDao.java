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
		StringBuilder sb = new StringBuilder("SELECT sum(project_id) as sum FROM `student` WHERE pnr in (");
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
		Object x[] = {sb.toString()};
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
			sb.append(s);
			counter++;
			if(counter < members.size())
				sb.append(',');
		}
		String cmd = "Update student set project_id=? where pnr in (?)";
		System.out.println(cmd);
		Object x[] = {projectId, sb.toString()};
		int row = t.update(cmd, x);
		if(row <= 0) {
			return false;
		}
		return true;
	}

}

package opms.project.students;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.project.ProjectObject;

public class getProjectInfo implements RowMapper<ProjectObject> {

	@Override
	public ProjectObject mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		String project_id = arg0.getString("project_id");
		String title = arg0.getString("title");
		String abst = arg0.getString("abstract");
		String guide = arg0.getString("guide");
		String group_leader = arg0.getString("group_leader");
		String start_date = arg0.getString("start_date");
		String end_date = arg0.getString("end_date");
		String status = arg0.getString("status");
		
		return new ProjectObject(project_id, title, abst, guide, group_leader, start_date, end_date, status);
	}

}

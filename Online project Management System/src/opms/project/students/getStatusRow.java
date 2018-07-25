package opms.project.students;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.status.Status;

public class getStatusRow implements RowMapper<Status> {

	@Override
	public Status mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		
		String timestamp = arg0.getString("timestamp");
		String project_id = arg0.getString("project_id");
		String description = arg0.getString("description");
		String updated_by =arg0.getString("updated_by");
		return new Status(timestamp, project_id, description, updated_by);
	}

}

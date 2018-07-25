package opms.project.students;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.comments.Comment;
import opms.project.status.Status;

public class getStatus implements RowMapper<Status> {

	@Override
	public Status mapRow(ResultSet arg0, int arg1) throws SQLException {
		String timestamp = arg0.getString("timestamp");
		String project_id = arg0.getString("project_id");
		String status = arg0.getString("description");
		String updated_by = arg0.getString("updated_by");
		
		return new Status(project_id, timestamp, status, updated_by);
	}

}

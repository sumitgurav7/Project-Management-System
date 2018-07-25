package opms.project.students;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.comments.Comment;

public class getProjectComments implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet arg0, int arg1) throws SQLException {
		String timestamp = arg0.getString("timestamp");
		String project_id = arg0.getString("project_id");
		String comment = arg0.getString("comment");
		String updated_by = arg0.getString("updated_by");
		
		return new Comment(project_id, timestamp, comment, updated_by);
	}

}

package opms.project.students;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.comments.Comment;
import opms.project.project.ProjectObject;

public class getUploadStudDataAdmin implements RowMapper<Integer> {

	@Override
	public Integer mapRow(ResultSet arg0, int arg1) throws SQLException {
		 return arg0.getInt("project_id");
	}

}

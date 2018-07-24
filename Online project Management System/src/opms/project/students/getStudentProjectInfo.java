package opms.project.students;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class getStudentProjectInfo implements RowMapper<Integer> {

	@Override
	public Integer mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		int project_id =arg0.getInt("project_id");
		return project_id;
	}

}

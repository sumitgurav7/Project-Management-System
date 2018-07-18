package opms.project.students;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class getProjectSum implements RowMapper<Integer> {

	@Override
	public Integer mapRow(ResultSet arg0, int arg1) throws SQLException {
		int sum = arg0.getInt("sum");
		return sum;
	}

}

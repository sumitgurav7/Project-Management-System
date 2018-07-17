package opms.project.loginreg;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class multi implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		String pnr = arg0.getString(1);
		
		return pnr;
	}

}

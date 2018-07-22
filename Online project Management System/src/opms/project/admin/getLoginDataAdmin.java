package opms.project.admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.loginreg.Login;
import opms.project.students.Student;

public class getLoginDataAdmin implements RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet arg0, int arg1) throws SQLException {
		String uname = arg0.getString("username");
		String pword = arg0.getString("password");
		String valid_from = arg0.getString("valid_from");
		String valid_upto = arg0.getString("valid_upto");
		String last_login = arg0.getString("last_login");
		int enabled = arg0.getInt("enabled");
		return new Login(uname, pword, valid_from, valid_upto, last_login, enabled);
	}

}

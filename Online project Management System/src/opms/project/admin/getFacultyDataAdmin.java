package opms.project.admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.faculty.Faculty;

public class getFacultyDataAdmin implements RowMapper<Faculty> {

	@Override
	public Faculty mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		String email_id,name,department,designation;
		String contact_no;
		name =arg0.getString("name");
		email_id = arg0.getString("email_id");
		department = arg0.getString("department");
		designation = arg0.getString("designation");
		contact_no = arg0.getString("contact_no");
		return new Faculty(email_id, name, department, designation, contact_no);
	}

}

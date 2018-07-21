package opms.project.admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.students.Student;

public class getStudentDataAdmin implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		String fname = arg0.getString("name");
		String pnr = arg0.getString("pnr");
		String email = arg0.getString("email_id");
		String deptartment = arg0.getString("department");
		String contact_no = arg0.getString("contact_no");
		long projectId = arg0.getLong("project_id");
		return new Student(fname, pnr, email, deptartment, contact_no, projectId);
	}

}

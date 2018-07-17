package opms.project.loginreg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import opms.project.admin.Admin;
import opms.project.admin.AdminDao;
import opms.project.faculty.Faculty;
import opms.project.faculty.FacultyDao;
import opms.project.students.*;

@Repository
public class LoginDao {
	
	private JdbcTemplate t;
	
	
	@Autowired
	public void setT(JdbcTemplate t) {
		this.t = t;
	}

	public boolean newStudentRegister(Student st) {
		String cmd = "insert into student values(?,?,?,?,?,?)";
		Object x[] = {st.getPnr(), st.getFname(), st.getEmail(), st.getDeptartment(),st.getContact_no(),
				st.getProjectId()};
		int row = t.update(cmd, x);
		if(row <= 0)
			return false;
		return true;
	}

	public boolean newFacultyRegister(Faculty fc) {
		String cmd = "insert into faculty values(?,?,?,?,?)";
		Object x[] = {fc.getEmail_id(),fc.getName(),fc.getDepartment(),fc.getDesignation(),fc.getContact_no()};
		int row = t.update(cmd, x);
		if(row<=0)
			return false;
		return true;
	}

	public boolean newAdminRegister(Admin ad) {
		String cmd = "insert into admin values(?,?,?)";
		Object x[] = {ad.getEmail(), ad.getName(), ad.getContact()};
		int row = t.update(cmd, x);
		if(row <= 0)
			return false;
		return true;
	}

}

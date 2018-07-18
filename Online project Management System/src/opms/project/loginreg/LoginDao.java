package opms.project.loginreg;

import java.time.LocalDate;
import java.util.Date;

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
	public boolean deleteLogin(String username) {
		String cmd = "delete from login_table where username= ?";
		Object x[] = {username};
		int row = t.update(cmd, x);
		if(row <=0) {
			return false;
		}
		return true;
	}

	public boolean createNewLogin(String username, String password) {
		String cmd = "insert into login_table values(?,?,?,?,?,?)";
		Object x[] = {username, password, new Date(),java.sql.Date.valueOf(LocalDate.now().plusMonths(6)),new Date(),0};
		int row = t.update(cmd, x);
		if(row <= 0) {
			return false;
		}
		return true;
	}
}

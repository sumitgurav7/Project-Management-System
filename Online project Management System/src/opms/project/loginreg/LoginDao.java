package opms.project.loginreg;

<<<<<<< HEAD
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import opms.project.admin.Admin;
import opms.project.admin.AdminDao;
import opms.project.faculty.Faculty;
import opms.project.faculty.FacultyDao;
import opms.project.students.*;


>>>>>>> branch 'master' of https://prachibhardwaj@bitbucket.org/prachibhardwaj/online-project-management-system.git
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
<<<<<<< HEAD
=======

	public boolean createNewLogin(String username, String password) {
		String cmd = "insert into login_table values(?,?,?,?,?)";
		Object x[] = {username, password, new Date(),java.sql.Date.valueOf(LocalDate.now().plusMonths(6)),new Date()};
		int row = t.update(cmd, x);
		if(row <= 0) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	/*
	 * Below This my code which we will change according to future plan
	 * 
	 * 
	 * 
	 * */
	
	
	
	public boolean studValidate(String username, String password) {
		// TODO Auto-generated method stub
		
		String cmd = "select pnr from student where pnr = ?";
		Object x[] = {username};
		RowMapper<String> row = new multi();
		List<String> lis = t.query(cmd, x, row);
		if(lis.isEmpty())
		{
			return false;
		}
		else {
			String cmdlt = "select email_id from login_table where email_id = ? and password = ?";
			Object y[] = {username,password};
			RowMapper<String> ro = new logtab();
			List<String> li = t.query(cmdlt, y, ro);
			System.out.println("list size" + li.size());
			if(li.size()>0)
			{
				return true;
			}
		}
		
		return false;
	}

	public boolean faculValidate(String username, String password) {
		// TODO Auto-generated method stub
		String cmd = "select email_id from faculty where email_id = ?";
		Object x[] = {username};
		RowMapper<String> row = new multi();
		List<String> lis = t.query(cmd, x, row);
		if(lis.isEmpty())
		{
			return false;
		}
		else {
			String cmdlt = "select email_id from login_table where email_id = ? and password = ?";
			Object y[] = {username,password};
			RowMapper<String> ro = new logtab();
			List<String> li = t.query(cmdlt, y, ro);
			System.out.println("list size" + li.size());
			if(li.size()>0)
			{
				return true;
			}
		}
		
		return false;
	}

	public boolean adminValidate(String username, String password) {
		// TODO Auto-generated method stub
		String cmd = "select email_id from admin where email_id = ?";
		Object x[] = {username};
		RowMapper<String> row = new multi();
		List<String> lis = t.query(cmd, x, row);
		if(lis.isEmpty())
		{
			return false;
		}
		else {
			String cmdlt = "select email_id from login_table where email_id = ? and password = ?";
			Object y[] = {username,password};
			RowMapper<String> ro = new logtab();
			List<String> li = t.query(cmdlt, y, ro);
			System.out.println("list size" + li.size());
			if(li.size()>0)
			{
				return true;
			}
		}
		
		return false;
	}
>>>>>>> branch 'master' of https://prachibhardwaj@bitbucket.org/prachibhardwaj/online-project-management-system.git

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

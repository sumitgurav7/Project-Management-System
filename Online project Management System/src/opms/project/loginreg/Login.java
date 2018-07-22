package opms.project.loginreg;

import java.sql.Time;

public class Login {
	String username;
	String password;
	String valid_from;
	String valid_upto;
	String last_login;
	int enabled;
	
	public Login() {
		super();
	}
	
	public Login(String username, String password, String valid_from, String valid_upto, String last_login,
			int enabled) {
		super();
		this.username = username;
		this.password = password;
		this.valid_from = valid_from;
		this.valid_upto = valid_upto;
		this.last_login = last_login;
		this.enabled = enabled;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValid_from() {
		return valid_from;
	}
	public void setValid_from(String valid_from) {
		this.valid_from = valid_from;
	}
	public String getValid_upto() {
		return valid_upto;
	}
	public void setValid_upto(String valid_upto) {
		this.valid_upto = valid_upto;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
}

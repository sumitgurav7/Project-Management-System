package opms.project.admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.loginreg.Login;
import opms.project.project.ProjectObject;

public class getProjectDataAdmin implements RowMapper<ProjectObject> {

	@Override
	public ProjectObject mapRow(ResultSet arg0, int arg1) throws SQLException {
		int  pid = arg0.getInt("project_id");
		String title = arg0.getString("title");
		String abs = arg0.getString("abstract");
		String guide = arg0.getString("guide");
		String gpl = arg0.getString("group_leader");
		String sdate = arg0.getString("start_date");
		String edate = arg0.getString("end_date");
		int status = arg0.getInt("status");
		return new ProjectObject(pid, title, abs, guide,gpl,sdate,edate,status);
	}

}

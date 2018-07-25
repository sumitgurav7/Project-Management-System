package opms.project.students;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import opms.project.files.file;

public class getRetriveFile implements RowMapper<file> {

	@Override
	public file mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		String upload_id = arg0.getString("upload_id");
		String filename = arg0.getString("filename");
		String filepath = arg0.getString("filepath");
		String filehash = arg0.getString("filehash");
		String timestamp = arg0.getString("timestamp");
		String project_id = arg0.getString("project_id");
		String uploaded_by = arg0.getString("uploaded_by");
		
			
		
		return new file(upload_id,filename, filepath, filehash, timestamp, project_id, uploaded_by);
	}

}

package opms.project.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDao {

	private JdbcTemplate t;
	
	@Autowired
	public void setT(JdbcTemplate t) {
		this.t = t;
	}

	public String getStudentNameByPnr(String pnr) {
		String cmd = "select name from student where pnr=?";
		Object x[] = {pnr};
		RowMapper<String> rw = new getStudentInfo();
		List<String> list = t.query(cmd, x, rw);
		if(list.size()>0)
		
			return list.get(0);
		else
			return "";
	}

}

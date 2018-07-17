package opms.project.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	private JdbcTemplate t;
	
	@Autowired
	public void setT(JdbcTemplate t) {
		this.t = t;
	}
	
	
}

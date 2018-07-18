package opms.project.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	StudentDao sd;

	@Autowired
	public void setSd(StudentDao sd) {
		this.sd = sd;
	}
	
	public String getStudentNameByPnr(String pnr) {
		return sd.getStudentNameByPnr(pnr);
	}
}

package opms.project.students;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentPresentation {
	
	StudentService s;

	@Autowired
	public void setS(StudentService s) {
		this.s = s;
	}

	@RequestMapping("/getStudentByPnr")
	@ResponseBody
	public String getStudentByPnr(@RequestParam String pnr, HttpServletRequest request, HttpServletResponse response, Model model) {
	    String sname = s.getStudentNameByPnr(pnr);
	    if (sname == null || sname.length() <= 0) {
	        model.addAttribute("alreadySaved", false);
	        return sname;
	    } else {
	        model.addAttribute("alreadySaved", true);
	        return sname;
	    }
	}

}

package opms.project.loginreg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import opms.project.students.*;

@Controller
public class LoginPresentation {
	private LoginService s;

	@Autowired
	public void setS(LoginService s) {
		this.s = s;
	}
	
	@RequestMapping("/newregistration")
	public ModelAndView newRegistration(@RequestParam("fname") String fname,
			              @RequestParam("email") String email, @RequestParam("phn") String phn,
			              @RequestParam("type") String type, @RequestParam("department") String dept,
			              @RequestParam("designation") String desig, @RequestParam("pnr") String pnr,
			              @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		boolean result = false;
			result = s.createNewRegistration(fname, email, phn, type, dept, desig, pnr, password);
			if(result) {
				if(type.equalsIgnoreCase("faculty")) {
					mv.setViewName("/faculty/faculty_welcome.jsp");
				} else if(type.equalsIgnoreCase("student")) {
					mv.setViewName("/student/student_welcome.jsp");
				} else if(type.equalsIgnoreCase("admin")) {
					mv.setViewName("/admin/admin_welcome.jsp");
				} else {
					mv.setViewName("/registration.jsp");
				}
			} else {
				mv.setViewName("/registration.jsp");
			}
		
		
		return mv;
	}
}

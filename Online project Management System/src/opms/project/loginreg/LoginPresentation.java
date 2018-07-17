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
			              @RequestParam("designation") String desig, @RequestParam("pnr") String pnr) {
		ModelAndView mv = new ModelAndView();
		if(type.equalsIgnoreCase("faculty")) {
			s.createNewFaculty(email,fname,dept,desig,phn);
		} else if (type.equalsIgnoreCase("student")) {
			s.createNewStudentLogin(pnr, fname, dept, phn, email);
		} else if(type.equalsIgnoreCase("admin")) {
			s.createNewAdmin(email, fname, phn);
		}
		
		return mv;
	}
}

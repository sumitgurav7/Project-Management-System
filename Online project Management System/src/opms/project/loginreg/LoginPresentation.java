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
	
	
	
	
	
	
	
	
	/*
	 *
	 * Below this line its my code this can be altered
	 * 
	 * 
	 * */
	
	@RequestMapping("student/student_login")
	public ModelAndView studLogin(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		System.out.println("in student Login");
		ModelAndView mv = new ModelAndView();
		boolean validate = false;
		
		if (username.equals("") || password.equals(""))
		{
			mv.addObject("entryVali", "please enter username and password");
			mv.setViewName("../index.jsp");
		}
		else
		{
			System.out.println(username);
			validate = s.studServLog(username,password);
			
			if(validate == true)
			{
				
				mv.setViewName("student_dashboard.jsp");
			
			}
			else
			{
				mv.addObject("entryVali", "please enter valid username and password");
				mv.setViewName("../index.jsp");
			}
		}
		
		return mv;
	}
	
	@RequestMapping("faculty/faculty_login")
	public ModelAndView faculLogin(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		System.out.println("in faculty Login");
		ModelAndView mv = new ModelAndView();
		boolean validate = false;
		
		if (username.equals("") || password.equals(""))
		{
			mv.addObject("entryVali", "please enter username and password");
			mv.setViewName("../index.jsp");
		}
		else
		{
			System.out.println(username);
			validate = s.faculServLog(username,password);
			
			if(validate == true)
			{
				
				mv.setViewName("faculty_dashboard.jsp");
			
			}
			else
			{
				mv.addObject("entryVali", "please enter valid username and password");
				mv.setViewName("../index.jsp");
			}
		}
		
		return mv;
	}
	
	@RequestMapping("admin/admin_login")
	public ModelAndView adminLogin(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		System.out.println("in admin Login");
		ModelAndView mv = new ModelAndView();
		boolean validate = false;
		
		if (username.equals("") || password.equals(""))
		{
			mv.addObject("entryVali", "please enter username and password");
			mv.setViewName("../index.jsp");
		}
		else
		{
			System.out.println(username);
			validate = s.adminServLog(username,password);
			
			if(validate == true)
			{
				
				mv.setViewName("admin_dashboard.jsp");
			
			}
			else
			{
				mv.addObject("entryVali", "please enter valid username and password");
				mv.setViewName("../index.jsp");
			}
		}
		
		return mv;
	}
}

package opms.project.loginreg;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginPresentation {
	private LoginService s;

	
	public LoginPresentation() {
		// TODO Auto-generated constructor stub
		System.out.println("Controller chal ra hai");
	
	}
	@Autowired
	public void setS(LoginService s) {
		this.s = s;
	}
	
	/*
	 * 
	 * 
	 * **********************************************************
	 * 
	 * 
	 * 
	 * */
	
	
	
	@RequestMapping(value="/newregistration_verification",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView verifyEmail(@RequestParam("username") String username, @RequestParam("code") int code) {
		ModelAndView mv = new ModelAndView();
		boolean result = s.verifyEmailId(username, code);
		if(result) {
			mv.addObject("result", "Verification Successful");
		} else {
			mv.addObject("result", "Verification was not successful");
		}
		mv.setViewName("/EmailVerification.jsp");
		return mv;
	}
	
	@RequestMapping(value="/newregistration",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView newLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String fname = request.getParameter("fname");
		String email = request.getParameter("email");
		String phn = request.getParameter("phn");
		String type = request.getParameter("type");
		String dept = request.getParameter("department");
		String desig = request.getParameter("designation");
		String pnr = request.getParameter("pnr");
		String password = request.getParameter("password");
		String url = request.getRequestURL().toString();
		
		ModelAndView mv = new ModelAndView();
		boolean result = false;
		
			result = s.createNewRegistration(fname, email, phn, type, dept, desig, pnr, password, url);
			if(result) {
				if(type.equalsIgnoreCase("faculty")) {
					mv.setViewName("/faculty/faculty_login.jsp");
				} else if(type.equalsIgnoreCase("student")) {
					mv.setViewName("/student/student_login.jsp");
				} else if(type.equalsIgnoreCase("admin")) {
					mv.setViewName("/admin/admin_login.jsp");
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
	 * 
	 * *******************************************************************************
	 * 
	 * 
	 * 
	 * */
	
	
	
	
	
	
	
	
	
	
	/*@RequestMapping("/newregistration")
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
					mv.setViewName("/faculty/faculty_login.jsp");
				} else if(type.equalsIgnoreCase("student")) {
					mv.setViewName("/student/student_login.jsp");
				} else if(type.equalsIgnoreCase("admin")) {
					mv.setViewName("/admin/admin_login.jsp");
				} else {
					mv.setViewName("/registration.jsp");
				}
			} else {
				mv.setViewName("/registration.jsp");
			}		
		
		return mv;
	}
	
	
	*/
	
	
	
	
	
	/*
	 *
	 * Below this line its my code this can be altered
	 * 
	 * 
	 * */
	
	@RequestMapping(value="/hmpg", method = RequestMethod.GET)
	public ModelAndView indexHome()
	{
		ModelAndView mv =  new ModelAndView();
		
		mv.setViewName("/index.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="/studentlg", method = RequestMethod.GET)
	public ModelAndView indexStudent()
	{
		ModelAndView mv =  new ModelAndView();
		
		mv.setViewName("/student/student_login.jsp");
		
		return mv;
	}
	
	
	@RequestMapping(value="/facultylg", method = RequestMethod.GET)
	public ModelAndView indexFaculty()
	{
		ModelAndView mv =  new ModelAndView();
		
		mv.setViewName("/faculty/faculty_login.jsp");
		
		return mv;
	}
	
	
	@RequestMapping(value="/adminlg", method = RequestMethod.GET)
	public ModelAndView indexAdmin()
	{
		ModelAndView mv =  new ModelAndView();
		
		mv.setViewName("/admin/admin_login.jsp");
		
		return mv;
	}
	
	
	@RequestMapping(value="/regi", method = RequestMethod.GET)
	public ModelAndView indexRegistration()
	{
		ModelAndView mv =  new ModelAndView();
		
		mv.setViewName("/registration.jsp");
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/student_logins", method = RequestMethod.POST)
	public ModelAndView studLogin(@RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest httpServletRequest)
	{
		System.out.println("in student Login");
		ModelAndView mv = new ModelAndView();
		boolean validate = false;
		
		if (username.equals("") || password.equals(""))
		{
			mv.addObject("entryVali", "please enter username and password");
			mv.setViewName("/student/student_login.jsp");
		}
		else
		{
			System.out.println(username);
			validate = s.studServLog(username,password);
			
			if(validate == true)
			{
				HttpSession httpSession = httpServletRequest.getSession();
				httpSession.setAttribute("username", username);
				httpSession.setAttribute("password", password);
				mv.setViewName("/student/student_welcome.jsp");
			
			}
			else
			{
				mv.addObject("entryVali", "please enter valid username and password");
				mv.setViewName("/student/student_login.jsp");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/faculty_login", method = RequestMethod.POST)
	public ModelAndView faculLogin(@RequestParam("username") String username,HttpServletRequest httpServletRequest, @RequestParam("password") String password)
	{
		System.out.println("in faculty Login");
		ModelAndView mv = new ModelAndView();
		boolean validate = false;
		
		if (username.equals("") || password.equals(""))
		{
			mv.addObject("entryVali", "please enter username and password");
			mv.setViewName("/faculty/faculty_login.jsp");
		}
		else
		{
			System.out.println(username);
			validate = s.faculServLog(username,password);
			
			if(validate == true)
			{
				
				HttpSession httpSession = httpServletRequest.getSession();
				httpSession.setAttribute("username", username);
				httpSession.setAttribute("password", password);
				
				mv.setViewName("/faculty/faculty_welcome.jsp");
			
			}
			else
			{
				mv.addObject("entryVali", "please enter valid username and password");
				mv.setViewName("/faculty/faculty_login.jsp");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/admin_login", method = RequestMethod.POST)
	public ModelAndView adminLogin(@RequestParam("username") String username,HttpServletRequest httpServletRequest, @RequestParam("password") String password)
	{
		System.out.println("in admin Login");
		ModelAndView mv = new ModelAndView();
		boolean validate = false;
		
		if (username.equals("") || password.equals(""))
		{
			mv.addObject("entryVali", "please enter username and password");
			mv.setViewName("/admin/admin_login.jsp");
		}
		else
		{
			System.out.println(username);
			validate = s.adminServLog(username,password);
			
			if(validate == true)
			{
				HttpSession httpSession = httpServletRequest.getSession();
				httpSession.setAttribute("username", username);
				httpSession.setAttribute("password", password);
				mv.setViewName("/admin/admin_welcome.jsp");
				
			
			}
			else
			{
				mv.addObject("entryVali", "please enter valid username and password");
				mv.setViewName("/admin/admin_login.jsp");
			}
		}
		
		return mv;
	}
}
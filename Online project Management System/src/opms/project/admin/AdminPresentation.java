package opms.project.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPresentation {

	private AdminService s;

	@Autowired
	public void setS(AdminService s) {
		this.s = s;
	}
	
	public AdminPresentation() {
		// TODO Auto-generated constructor stub
		System.out.println("admin controller is working");
	
	}
	
	@RequestMapping("/pendingapp")
	public ModelAndView pendingAppr()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/PendingApproval.jsp");
		return mv;
	}
	
	
	@RequestMapping("/viewmember")
	public ModelAndView viewMember()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/ViewMember.jsp");
		return mv;
	}
	
	
	
}

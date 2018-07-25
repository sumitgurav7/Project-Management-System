package opms.project.guest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import opms.project.project.ProjectObject;
import opms.project.students.Student;

@Controller
@Component
public class GuestController {

	
	private Guestservice gs;
	@Autowired
	public void setGs(Guestservice gs) {
		this.gs = gs;
	}
	
	@RequestMapping("/guestlg")
	public ModelAndView guestLog()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("guest/guest_welcome.jsp");
		return mv;
	}
	
	@RequestMapping("/guestProjects")
	public ModelAndView guestProj()
	{
		List<ProjectObject> listOfProjects;
		ModelAndView mv =new ModelAndView();
		System.out.println("in guest projects request ");
		listOfProjects = gs.getAllProject();
		System.out.println("in guest projects request ");
		mv.addObject("ProjectList", listOfProjects);
		mv.setViewName("guest/Projects.jsp");
		return mv;
	}
	
	
	@RequestMapping(value="/viewGuestProjectDetail",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView viewProjectDetails(@RequestParam("project_id") int project_id)
	{
		System.out.println(project_id);
		ModelAndView mv = new ModelAndView();
		ProjectObject p = gs.getProjectById(project_id);
		mv.addObject("projectObject", p);
		List<Student> list = gs.getAllStudentsByProjectId(project_id);
		if(list == null) {
			list = new ArrayList<Student>();
		}
		mv.addObject("studentList",list);
		mv.setViewName("guest/viewProjectDetails.jsp");
		return mv;
	}
	
	
}

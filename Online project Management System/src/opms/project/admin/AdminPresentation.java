package opms.project.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import opms.project.faculty.Faculty;
import opms.project.students.Student;

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
	
	@RequestMapping(value="/pendingapp",method=RequestMethod.GET)
	public ModelAndView pendingAppr()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/PendingApproval.jsp");
		return mv;
	}
	
	
	@RequestMapping(value="/viewmember",method=RequestMethod.GET)
	public ModelAndView viewMember()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/ViewMember.jsp");
		return mv;
	}
	
	
	
	@RequestMapping(value="viewdata",method=RequestMethod.POST)
	public ModelAndView viewData(@RequestParam("memberby") String getallby, @RequestParam("searchby") String searchtype, @RequestParam("searchvalue") String searchValue)
	{ 
		ModelAndView mv = new ModelAndView();
		System.out.println(searchValue + "1");
		if(getallby!=null)
		{
			if(getallby.equals("student"))
			{
				List<Student> listOfObject = s.getAllStudents();
				
				if(listOfObject.size()>0)
				{
					mv.addObject("viewAllKey", listOfObject);
					mv.setViewName("admin/ViewMember.jsp");
				}
			}
			if(getallby.equals("faculty"))
			{
				List<Faculty> listOfObject =s.getAllFaculty();
				mv.addObject("viewAllKeyFaculty", listOfObject);
				mv.setViewName("admin/ViewMember.jsp");
			}
		}
		
		return mv;
		
	}
	
	@RequestMapping(value="/delFac",method=RequestMethod.POST)
	public ModelAndView delFac(@RequestParam("id") String fac)
	{
		ModelAndView mv = new ModelAndView();
		List<Faculty> listOfObject =s.delFaculty(fac);
		mv.addObject("viewAllKeyFaculty", listOfObject);
		mv.setViewName("admin/ViewMember.jsp");
		return mv;
	}
	
	@RequestMapping(value="/toUpdateFacu",method=RequestMethod.POST)
	public ModelAndView updateFac(Faculty faculty)
	{
		ModelAndView mv = new ModelAndView();
		//List<Faculty> listOfObject =s.delFaculty(fac);
		mv.addObject("facultyObject", faculty);
		mv.setViewName("admin/ViewMember.jsp");
		return mv;
	}
	
	@RequestMapping(value="/delStud", method=RequestMethod.POST)
	public ModelAndView delStud(@RequestParam("pnr") String pnr)
	{
	
		ModelAndView mv = new ModelAndView();
		List<Student> listOfObject =s.delStudent(pnr);
		mv.addObject("viewAllKey", listOfObject);
		mv.setViewName("admin/ViewMember.jsp");
		return mv;
		
	}
	
	@RequestMapping(value="/toUpdateStudent",method=RequestMethod.POST)
	public ModelAndView updateStud(Student student)
	{
		ModelAndView mv = new ModelAndView();
		//List<Faculty> listOfObject =s.delFaculty(fac);
		mv.addObject("studentObject", student);
		mv.setViewName("admin/ViewMember.jsp");
		return mv;
	}
	
	
}

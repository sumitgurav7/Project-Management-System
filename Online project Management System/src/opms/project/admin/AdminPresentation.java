package opms.project.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import opms.project.faculty.Faculty;
import opms.project.students.Student;
import opms.project.loginreg.Login;
import opms.project.project.ProjectObject;

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
	
	/*@RequestMapping(value="/pendingapp",method=RequestMethod.GET)
	public ModelAndView pendingAppr()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/PendingApproval.jsp");
		return mv;
	}*/
	
	
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
	
	@RequestMapping(value="/pendingapp",method=RequestMethod.GET)
	public ModelAndView getPendingInfo() {
		ModelAndView mv = new ModelAndView();
		List<Login> loginlist = s.getAllPendingLogins();
		mv.addObject("pendingLoginList", loginlist);
		List<ProjectObject> projectlist = s.getAllPendingProjects();
		mv.addObject("pendingProjectList", projectlist);
		mv.setViewName("admin/PendingApproval.jsp");
		return mv;
	}
	
	@RequestMapping(value="/updateLogin",method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean updateLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String username="";
		int value= 0;
		StringBuilder sb = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	        }
	    } finally {
	        reader.close();
	    }
	    String str = sb.toString();
	    try {
			JSONObject json = new JSONObject(str);
			username = json.getString("username");
			value = json.getInt("valToPass");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	    return s.updateLogin(username, value);
	}
	
	@RequestMapping(value="/updateProject",method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean approveProject(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String projectId="";
		int value = 0;
		StringBuilder sb = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	        }
	    } finally {
	        reader.close();
	    }
	    String str = sb.toString();
	    try {
			JSONObject json = new JSONObject(str);
		    projectId = json.getString("projectId");
		    value = json.getInt("valToPass");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	    return s.updateProject(projectId, value);
	}

	@RequestMapping ("/assignFaculty")
	@ResponseBody
	public ModelAndView getGuidePendingInfo() {
		ModelAndView mv = new ModelAndView();
		List<ProjectObject> projectlist = s.getGuidePendingProjects();
		List<Faculty> facultylist = s.getAllFacultyList();
		mv.addObject("facultylist", facultylist);
		mv.addObject("pendingProjectList", projectlist);
		mv.setViewName("admin/assignFaculty.jsp");
		return mv;
	}
	
	@RequestMapping(value="/assignFacultyToProject",method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean assignFacultyToProject(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String projectId="";
		String facultyMailId ="";
		StringBuilder sb = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	        }
	    } finally {
	        reader.close();
	    }
	    String str = sb.toString();
	    try {
			JSONObject json = new JSONObject(str);
		    projectId = json.getString("projectid");
		    facultyMailId = json.getString("facultyemail");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	    return s.assignFacultyToProject(projectId, facultyMailId);
	}
	
}

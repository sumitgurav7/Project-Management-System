package opms.project.students;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import opms.project.project.*;

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
	
	@RequestMapping(value="/createNewProject",method=RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean createNewProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectObject po = new ProjectObject();
		String title;
		String abs;
		String lead;
		String array;
		ArrayList<String> members = new ArrayList<String>();
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
	    str = str.replace('{', ' ');
	    str = str.replace('}', ' ');
	    str = str.replace('"', ' ');
	    if(sb.length() > 0) {
	    	StringTokenizer st0 = new StringTokenizer(str, "[");
	    	str = st0.nextToken();
	    	array = st0.nextToken();
	    	StringTokenizer st = new StringTokenizer(str,",");
	    	while(st.hasMoreTokens()) {
	    		String next = st.nextToken();
	    		StringTokenizer st1 = new StringTokenizer(next,":");
	    		String label = st1.nextToken();
	    		String value;
	    		if(label.contains("title")) {
	    			value = st1.nextToken();
	    			title = value;
	    			po.setTitle(title);
	    		} else if(label.contains("abs")) {
	    			value = st1.nextToken();
	    			abs = value;
	    			po.setAbs(abs);
	    		} else if(label.contains("lead")) {
	    			value = st1.nextToken();
	    			lead = value;
	    			po.setLead(lead);
	    		} else if(label.contains("members")) {
	    			array = array.replace(']', ' ');
	    			StringTokenizer st2 = new StringTokenizer(array, ",");
	    			while(st2.hasMoreTokens()) {
	    				members.add(st2.nextToken());
	    			}
	    			po.setMembers(members);
	    		}
	    	}
	    }
	    boolean result = s.createNewProject(po);
		return result;
	}
	
	
	
	/*hello
	 * 
	 * 
	 * Below this is code that can be altered
	 * 
	 * */
	
	
	
	@RequestMapping("/newproject")
	public ModelAndView nproj()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/newproject.jsp");
		return mv;
	}
	
	
	@RequestMapping("/fileupload")
	public ModelAndView fupload()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/FileUpload.jsp");
		return mv;
	}
	
	@RequestMapping("/viewstat")
	public ModelAndView viewStat()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/viewStatus.jsp");
		return mv;
	}
	
	@RequestMapping("/stdiscuss")
	public ModelAndView stdisc()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/Discussion.jsp");
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView lout()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("logout.jsp");
		return mv;
	}
}

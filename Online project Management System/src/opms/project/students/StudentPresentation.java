package opms.project.students;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import opms.project.files.file;
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
			po.setTitle(json.getString("title"));
			po.setAbs(json.getString("abs"));
			po.setLead(json.getString("lead"));
			JSONArray ja = json.getJSONArray("members");
			po.setMembers(new ArrayList<String>());
			for(int i =0; i < ja.length(); i++) {
				po.getMembers().add(ja.getString(i));
			}
		} catch (JSONException e) {
			e.printStackTrace();
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
	
	
	@RequestMapping(value = "/studupload", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ModelAndView processUpload(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file,
			ModelAndView modelAndView,@RequestParam("textline") String username) throws IOException {

		System.out.println("Upload Called");

		byte[] fileBytes = file.getBytes();

		String UPLOADED_FOLDER = "C:\\Users\\gurav\\git\\online-project-management-system\\Online project Management System\\WebContent\\FileStorage\\";

		String fileName=file.getOriginalFilename();
		boolean sqlUploadStat = false;
		sqlUploadStat = s.sqlUploads(UPLOADED_FOLDER,fileName,username);
		
		
		if(sqlUploadStat == false)
		{
			modelAndView.addObject("projectUploadStat","project upload unsuccessfull");
		}
		else
		{
			
			System.out.println(file.getOriginalFilename());
			Path path = Paths.get(UPLOADED_FOLDER + username+ file.getOriginalFilename());
			Files.write(path, fileBytes);
			List<file> listOfFile = s.getListOfFiles(username);
			modelAndView.addObject("fileview", listOfFile);
			modelAndView.addObject("projectUploadStat","project upload successfull");
			
		}

		final String fileContent = new String(fileBytes);

		System.out.println("File Data : " + fileContent);
		modelAndView.addObject("uploadstatus","Upload Successfull");

		modelAndView.setViewName("student/FileUpload.jsp");

		return modelAndView;
	}
	
	
	@RequestMapping(value="/statusreport", method=RequestMethod.POST)
	public ModelAndView statusReport(@RequestParam("username") String username)
	{
		ModelAndView mv = new ModelAndView();
		ProjectObject listOfReport = s.returnReport(username);
		if(listOfReport != null)
		{
			if(listOfReport.getStatus() == 0)
			{mv.addObject("statusre", "Project approval Pending");}
			if(listOfReport.getStatus() == 1)
			{mv.addObject("statusre", "Project approved");}
			if(listOfReport.getStatus() == 2)
			{mv.addObject("statusre", "Project dis-approved");}
			else
			{System.out.println("nothing");}
			mv.addObject("report", listOfReport);
			List<Student> studentList = s.returnMembers(listOfReport.getProjectId());
			mv.addObject("members",studentList);
		}
		else
		{mv.addObject("statusre", "No project For this User");}
		
		
		
		mv.setViewName("student/viewStatus.jsp");
		return mv;
	}
	
}

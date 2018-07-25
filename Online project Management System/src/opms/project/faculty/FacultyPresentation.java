package opms.project.faculty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import opms.project.comments.Comment;
import opms.project.files.file;
import opms.project.project.ProjectObject;
import opms.project.status.Status;
import opms.project.students.Student;

@Controller
public class FacultyPresentation {

	
	private FacultyService fs;

	@Autowired
	public void setFs(FacultyService fs) {
		this.fs = fs;
	}
	
	@RequestMapping("/Projects")
	
	public ModelAndView projectsRed(HttpServletRequest request, HttpSession session)
	{
		
		ModelAndView mv =new ModelAndView();
		HttpSession sa = request.getSession();
		String username = (String)sa.getAttribute("username");
		List<ProjectObject> projectObject = fs.getProjectList(username);
		
		if(username.equals(""))
		{mv.addObject("sessionout","your login is not valid");
		 mv.setViewName("/logout.jsp");
		}
		else
		{
		mv.addObject("ProjectList",projectObject);
		mv.setViewName("/faculty/Projects.jsp");
		
		}
		return mv;
		
		
	}
	
	
	
	@RequestMapping("/viewStatusFac")
	
	public ModelAndView viewStatFac(HttpServletRequest request, HttpSession session,@RequestParam("project_id") String project_id)
	{
		
		ModelAndView mv =new ModelAndView();
		HttpSession sa = request.getSession();
		String username = (String)sa.getAttribute("username");
		
		
		if(username.equals(""))
		{mv.addObject("sessionout","your login is not valid");
		 mv.setViewName("/logout.jsp");
		}
		else
		{
			List<Status> statusList = fs.getStatusByProjectId(project_id);
			mv.addObject("statuslist", statusList);
			mv.addObject("pr_id",project_id);
			
			
		mv.setViewName("/faculty/viewStatus.jsp");
		}
		return mv;
		
		
	}
	
	
	@RequestMapping("/FileUploadFac")
	
	public ModelAndView fileUploadFac(HttpServletRequest request, HttpSession session)
	{
		
		ModelAndView mv =new ModelAndView();
		HttpSession sa = request.getSession();
		String username = (String)sa.getAttribute("username");
		
		
		if(username.equals(""))
		{mv.addObject("sessionout","your login is not valid");
		 mv.setViewName("/logout.jsp");
		}
		else
		{
		mv.setViewName("/faculty/FileUpload.jsp");
		}
		return mv;
		
		
	}
	
	
	@RequestMapping(value="/viewFacProjectDetail",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView viewProjectDetails(@RequestParam("project_id") int project_id)
	{
		System.out.println(project_id);
		ModelAndView mv = new ModelAndView();
		ProjectObject p = fs.getProjectById(project_id);
		mv.addObject("projectObject", p);
		List<Student> list = fs.getAllStudentsByProjectId(project_id);
		if(list == null) {
			list = new ArrayList<Student>();
		}
		mv.addObject("studentList",list);
		mv.setViewName("faculty/viewProjectDetails.jsp");
		return mv;
	}
	
	
	@RequestMapping(value = "/facupload", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ModelAndView processUpload(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file,
			ModelAndView modelAndView,@RequestParam("textline") String username) throws IOException {

		System.out.println("Upload Called");

		byte[] fileBytes = file.getBytes();

		String UPLOADED_FOLDER = "C:\\Users\\gurav\\git\\online-project-management-system\\Online project Management System\\WebContent\\FileStorage\\";
		System.out.println("if file is notnull");
		System.out.println(file!=null);
		System.out.println(file.getOriginalFilename());
		String fileName=username + "_" +file.getOriginalFilename();
		boolean sqlUploadStat = false;
		
		if(file.getOriginalFilename().equals(""))
		{System.out.println("file is emptuy");}
		else
		{
		sqlUploadStat = fs.sqlUploads(UPLOADED_FOLDER,fileName,username);
		
		
		if(sqlUploadStat == false)
		{
			modelAndView.addObject("projectUploadStat","project upload unsuccessfull");
		}
		else
		{
			
			System.out.println(file.getOriginalFilename());
			Path path = Paths.get(UPLOADED_FOLDER + username+ "_"+ file.getOriginalFilename());
			Files.write(path, fileBytes);
			List<file> listOfFile = fs.getListOfFiles(username);
			System.out.println("size of list file in presentation " + listOfFile.size());
			modelAndView.addObject("fileview", listOfFile);
			modelAndView.addObject("projectUploadStat","project upload successfull");
			
		}
		}

		final String fileContent = new String(fileBytes);

		System.out.println("File Data : " + fileContent);
		modelAndView.addObject("uploadstatus","Upload Successfull");

		modelAndView.setViewName("faculty/FileUpload.jsp");

		return modelAndView;
	}
	
	
	
	@RequestMapping("/fcdiscuss")
	public ModelAndView facDiscuss(@RequestParam("project_id") String project_id)
	{
		ModelAndView mv =new ModelAndView();
		
		List<Comment> commentList = fs.getCommentByProjectId(project_id);
		mv.addObject("comments", commentList);
		
		mv.addObject("proj_id",project_id);
		mv.setViewName("faculty/Discussion.jsp");
		return mv;
	}
	
	
	@RequestMapping(value="/addFacComment", method=RequestMethod.POST)
	public ModelAndView addNewDiscussion(@RequestParam("projectid") String projectId, @RequestParam("newcomment") String newComment,
						 @RequestParam("uname") String username)
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("value of project id insert at pres layer  " + projectId);
		boolean result = fs.addNewComment(projectId, newComment, username);
		
			
			
			List<Comment> commentList = fs.getCommentByProjectId(projectId);
			mv.addObject("comments", commentList);
		
		
		
		mv.setViewName("faculty/Discussion.jsp");
		return mv;
	}
	
}

package opms.project.students;

import java.io.BufferedReader;
import java.io.IOException;

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
	public int createNewProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	//ObjectMapper mapper = new ObjectMapper();
	            sb.append(line).append('\n');
	        }
	    } finally {
	        reader.close();
	    }
	    System.out.println(sb.toString());
		System.out.println("hello");
		return 0;
	}
}

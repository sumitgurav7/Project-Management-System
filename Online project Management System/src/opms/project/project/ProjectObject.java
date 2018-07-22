package opms.project.project;

import java.util.ArrayList;

public class ProjectObject {
	int    projectId;
	public int getProjectId() {
		return projectId;
	}



	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	String title;
	String abs;
	String guide;
	String lead;
	String start_date;
	String end_date;
	int status;
	
	ArrayList<String> members;
	
	public ProjectObject() {
		
	}
	
	
	
	public ProjectObject(int projectId, String title, String abs, String guide, String lead, String start_date,
			String end_date, int status) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.abs = abs;
		this.guide = guide;
		this.lead = lead;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
	}



	public ProjectObject(int projectId, String title, String abs, String lead, ArrayList<String> members) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.abs = abs;
		this.lead = lead;
		this.members = members;
	}
	
	public ProjectObject(String title, String abs, String lead, ArrayList<String> members) {
		super();
		this.title = title;
		this.abs = abs;
		this.lead = lead;
		this.members = members;
		this.projectId = 0;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
	}
	public ArrayList<String> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}
	
	
}

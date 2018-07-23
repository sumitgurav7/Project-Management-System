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
	
	public ProjectObject(String project_id, String title2, String abst, String guide2, String group_leader,
			String start_date2, String end_date2, String status2) {
		// TODO Auto-generated constructor stub
		this.projectId =Integer.parseInt(project_id);
		this.title =title2;
		this.abs=abst;
		this.guide =guide2;
		this.lead =group_leader;
		this.start_date =start_date2;
		this.end_date=end_date2;
		this.status =Integer.parseInt(status2);
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



	public String getGuide() {
		return guide;
	}



	public void setGuide(String guide) {
		this.guide = guide;
	}



	public String getStart_date() {
		return start_date;
	}



	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}



	public String getEnd_date() {
		return end_date;
	}



	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}

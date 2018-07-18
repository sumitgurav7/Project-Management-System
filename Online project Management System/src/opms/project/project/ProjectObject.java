package opms.project.project;

import java.util.ArrayList;

public class ProjectObject {
	String title;
	String abs;
	String lead;
	ArrayList<String> members;
	
	public ProjectObject() {
		
	}
	public ProjectObject(String title, String abs, String lead, ArrayList<String> members) {
		super();
		this.title = title;
		this.abs = abs;
		this.lead = lead;
		this.members = members;
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

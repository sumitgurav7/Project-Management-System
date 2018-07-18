package opms.project.project;

public class ProjectObject {
	String title;
	String abs;
	String lead;
	String[] members;
	
	public ProjectObject(String title, String abs, String lead, String[] members) {
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
	public String[] getMembers() {
		return members;
	}
	public void setMembers(String[] members) {
		this.members = members;
	}
	
	
}

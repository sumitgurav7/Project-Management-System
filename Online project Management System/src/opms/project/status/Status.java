package opms.project.status;

public class Status {
	String projectId;
	String timestamp;
	String status;
	String updatedBy;
	
	public Status() {
		super();
	}
	
	public Status(String projectId, String timestamp, String status, String updatedBy) {
		super();
		this.projectId = projectId;
		this.timestamp = timestamp;
		this.status = status;
		this.updatedBy = updatedBy;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}

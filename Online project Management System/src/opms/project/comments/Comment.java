package opms.project.comments;

public class Comment {
	String projectId;
	String timestamp;
	String comment;
	String updatedBy;
	
	public Comment() {
		
	}

	public Comment(String projectId, String timestamp, String comment, String updatedBy) {
		super();
		this.projectId = projectId;
		this.timestamp = timestamp;
		this.comment = comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}

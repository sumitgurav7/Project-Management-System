package opms.project.files;

public class file {
	
	private String upload_id;
	private String filename;
	private String filepath;
	private String filehash;
	private String timestamp;
	private String project_id;
	private String uploaded_by;
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilehash() {
		return filehash;
	}
	public void setFilehash(String filehash) {
		this.filehash = filehash;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getUploaded_by() {
		return uploaded_by;
	}
	public void setUploaded_by(String uploaded_by) {
		this.uploaded_by = uploaded_by;
	}
	public file(String upload_id, String filename, String filepath, String filehash, String timestamp, String project_id,
			String uploaded_by) {
		super();
		this.upload_id = upload_id;
		this.filename = filename;
		this.filepath = filepath;
		this.filehash = filehash;
		this.timestamp = timestamp;
		this.project_id = project_id;
		this.uploaded_by = uploaded_by;
	}
	
	public String getUpload_id() {
		return upload_id;
	}
	public void setUpload_id(String upload_id) {
		this.upload_id = upload_id;
	}
	public file() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "file [filename=" + filename + ", filepath=" + filepath + ", filehash=" + filehash + ", timestamp="
				+ timestamp + ", project_id=" + project_id + ", uploaded_by=" + uploaded_by + "]";
	}
	
	

}

package WholeDTO;

public class clothdto {
	int sqnumber;
	String id;
	String title;
	String content;
	String filename;
	
	
	

	public clothdto(int sqnumber, String id, String title, String content, String filename) {
		super();
		this.sqnumber = sqnumber;
		this.id = id;
		this.title = title;
		this.content = content;
        this.filename = filename;
	}
    
    public String getFilename() {
		return filename;
	}

    public void setFilename(String filename) {
		this.filename = filename;
	}

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public int getSqnumber() {
		return sqnumber;
	}
	public void setSqnumber(int sqnumber) {
		this.sqnumber = sqnumber;
	}
	

}
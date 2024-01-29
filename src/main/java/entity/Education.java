package entity;

public class Education {
	private int id;
	private String degree_name;
	private String major;
	
	public Education() {
		
	}

	public Education(int id, String degree_name, String major) {
		super();
		this.id = id;
		this.degree_name = degree_name;
		this.major = major;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegree_name() {
		return degree_name;
	}

	public void setDegree_name(String degree_name) {
		this.degree_name = degree_name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Education [id=" + id + ", degree_name=" + degree_name + ", major=" + major + "]";
	}
	
	
}

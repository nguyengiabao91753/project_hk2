package entity;

public class Department {
	private int id ;
	private String department_name;
	private String head_of_department;
	private String room;
	
	public Department() {
		
	}

	public Department(int id, String department_name, String head_of_department, String room) {
		super();
		this.id = id;
		this.department_name = department_name;
		this.head_of_department = head_of_department;
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getHead_of_department() {
		return head_of_department;
	}

	public void setHead_of_department(String head_of_department) {
		this.head_of_department = head_of_department;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", department_name=" + department_name + ", head_of_department="
				+ head_of_department + ", room=" + room + "]";
	}
	
	
}

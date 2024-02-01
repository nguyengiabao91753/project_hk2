package entity;

public class Department {
	private int department_id ;
	private String department_name;
	private String head_of_department;
	private String room;
	
	public Department() {
		
	}

	public Department(int department_id, String department_name, String head_of_department, String room) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.head_of_department = head_of_department;
		this.room = room;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
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
		return "Department [department_id=" + department_id + ", department_name=" + department_name + ", head_of_department="
				+ head_of_department + ", room=" + room + "]";
	}
	
	
}

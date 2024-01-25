package entity;

import java.sql.Date;
import java.time.LocalDate;

public class Employee {
	private int id;
	private String name;
	private String ethncity;
	private LocalDate date_of_birth;
	private boolean gender;
	private String adress;
	private int salary_level;
	private int supervisor_id;
	private int department_id;
	private int education_id;
	private int position_id;
	private String picture;
	
	public Employee() {
		
	}

	public Employee(int id, String name, String ethncity, LocalDate date_of_birth, boolean gender, String adress,
			int salary_level, int supervisor_id, int department_id, int education_id, int position_id, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.ethncity = ethncity;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.adress = adress;
		this.salary_level = salary_level;
		this.supervisor_id = supervisor_id;
		this.department_id = department_id;
		this.education_id = education_id;
		this.position_id = position_id;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEthncity() {
		return ethncity;
	}

	public void setEthncity(String ethncity) {
		this.ethncity = ethncity;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getSalary_level() {
		return salary_level;
	}

	public void setSalary_level(int salary_level) {
		this.salary_level = salary_level;
	}

	public int getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getEducation_id() {
		return education_id;
	}

	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", ethncity=" + ethncity + ", date_of_birth=" + date_of_birth
				+ ", gender=" + gender + ", adress=" + adress + ", salary_level=" + salary_level + ", supervisor_id="
				+ supervisor_id + ", department_id=" + department_id + ", education_id=" + education_id
				+ ", position_id=" + position_id + ", picture=" + picture + "]";
	}
	
	
}

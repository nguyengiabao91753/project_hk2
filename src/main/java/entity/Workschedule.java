package entity;

import java.util.Date;

public class Workschedule {
	private int id;
	private int employee_id;
	private int shift_id;
	private int room_id;
	private Date work_date;
	
	public Workschedule(int id, int employee_id, int shift_id, int room_id, Date work_date) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.shift_id = shift_id;
		this.room_id = room_id;
		this.work_date = work_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getShift_id() {
		return shift_id;
	}
	public void setShift_id(int shift_id) {
		this.shift_id = shift_id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public Date getWork_date() {
		return work_date;
	}
	public void setWork_date(Date work_date) {
		this.work_date = work_date;
	}
	@Override
	public String toString() {
		return "WorkscheduleDAO [id=" + id + ", employee_id=" + employee_id + ", shift_id=" + shift_id + ", room_id="
				+ room_id + ", work_date=" + work_date + "]";
	}
}

package entity;

import java.sql.Time;

public class Attendance {
	private int attendance_id;
	private int workschedule_id;
	private boolean present;
	private Time arrival_time;
	private Time departure_time;
	private String leave_type;
	public Attendance() {}
	public Attendance(int attendance_id, int workschedule_id, boolean present, Time arrival_time, Time departure_time,
			String leave_type) {
		super();
		this.attendance_id = attendance_id;
		this.workschedule_id = workschedule_id;
		this.present = present;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.leave_type = leave_type;
	}
	
	public int getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}

	public int getWorkschedule_id() {
		return workschedule_id;
	}

	public void setWorkschedule_id(int workschedule_id) {
		this.workschedule_id = workschedule_id;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public Time getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(Time arrival_time) {
		this.arrival_time = arrival_time;
	}

	public Time getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Time departure_time) {
		this.departure_time = departure_time;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	@Override
	public String toString() {
		return "Attendance [attendance_id=" + attendance_id + ", workschedule_id=" + workschedule_id + ", present="
				+ present + ", arrival_time=" + arrival_time + ", departure_time=" + departure_time + ", leave_type="
				+ leave_type + "]";
	}
	
	
	
}

package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Attendance;
import entity.Workschedule;

public class AttendanceDAO {
	public List<Attendance> getAllAtt() {
		List<Attendance> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllAtt}");
				ResultSet rs = cs.executeQuery();
				) {
			while(rs.next()) {
				list.add(new Attendance(rs.getInt("ATTENDANCE_ID"),
						rs.getInt("WORKSCHEDULE_ID"), 
						rs.getBoolean("PRESENT"), 
						rs.getTime("ARRIVAL_TIME"), 
						rs.getTime("DEPARTURE_TIME"), 
						rs.getString("LEAVE_TYPE")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}

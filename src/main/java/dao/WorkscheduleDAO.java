package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Workschedule;

public class WorkscheduleDAO {
	public List<Workschedule> selectAllSchedule() {
		List<Workschedule> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllSchedule}");
				ResultSet rs = cs.executeQuery();
				) {
			while(rs.next()) {
				list.add(new Workschedule(
						rs.getInt("schedule_id"),
						rs.getInt("employee_id"),
						rs.getInt("shift_id"),
						rs.getInt("room_id"),
						rs.getDate("work_date")
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
}

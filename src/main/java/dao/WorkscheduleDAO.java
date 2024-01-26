package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
						rs.getDate("work_date").toLocalDate()
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public void update(Workschedule worknew) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call updateSchedule(?,?,?,?,?)}");
				) {
			cs.setInt(1, worknew.getId());
			cs.setInt(2, worknew.getEmployee_id());
			cs.setInt(3, worknew.getShift_id());
			cs.setInt(4, worknew.getRoom_id());
			cs.setDate(5, java.sql.Date.valueOf(worknew.getWork_date()));
			
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Update Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void insert(Workschedule worknew) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call insertSchedule(?,?,?,?)}")
				) {
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}

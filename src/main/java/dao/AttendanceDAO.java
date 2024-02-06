package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	public int countAtt() {
		int count=0;
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call countAtt}");
				ResultSet rs = cs.executeQuery();
				) {
			while(rs.next()){
				count=rs.getInt("total");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Attendance> getAtt(int pagenumber, int rowOfPage) {
		List<Attendance> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAtt(?,?)}");
				) {
			cs.setInt(1, pagenumber);
			cs.setInt(2, rowOfPage);
			ResultSet rs = cs.executeQuery();
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
	
	public void update(Attendance att) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call updateAtt(?,?,?,?,?,?)}");
				) {
			cs.setInt(1, att.getAttendance_id());
			cs.setInt(2, att.getWorkschedule_id());
			cs.setBoolean(3, att.isPresent());
			cs.setTime(4, att.getArrival_time());
			cs.setTime(5, att.getDeparture_time());
			cs.setString(6, att.getLeave_type());
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Update Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void delete(int a) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call deleteAtt(?)}");
				) {
			cs.setInt(1, a);
			
			
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Delete Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void insert(Attendance att) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call insertAtt(?,?,?,?,?)}");
				) {
			cs.setInt(1, att.getWorkschedule_id());
			cs.setBoolean(2, att.isPresent());
			cs.setTime(3, att.getArrival_time());
			cs.setTime(4, att.getDeparture_time());
			cs.setString(5, att.getLeave_type());
			
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

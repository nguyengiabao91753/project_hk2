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
	public List<Workschedule> getSchedule(int pagenumber, int rowOfPage) {
		List<Workschedule> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getSchedule(?,?)}");
				
				) {
			cs.setInt(1, pagenumber);
			cs.setInt(2, rowOfPage);
			ResultSet rs = cs.executeQuery();
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
	public int countSchedule() {
		int count =0;
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call countWork}");
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
	
	public boolean insert(Workschedule worknew) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call insertSchedule(?,?,?,?)}")
				) {
			cs.setInt(1, worknew.getEmployee_id());
			cs.setInt(2, worknew.getShift_id());
			cs.setInt(3, worknew.getRoom_id());
			cs.setDate(4, java.sql.Date.valueOf(worknew.getWork_date()));
			if(cs.executeUpdate() >0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public void delete(int a) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call deleteSchedule(?)}")
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
	
	public List<Workschedule> getpersonSchedule(int a) {
		List<Workschedule> list = new ArrayList<>();
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call getpersonschedule(?)}");
				
				) {
			cs.setInt(1, a);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				list.add(new Workschedule(
						rs.getInt("schedule_id"),
						rs.getInt("employee_id"),
						rs.getInt("shift_id"),
						rs.getInt("room_id"),
						rs.getDate("work_date").toLocalDate()
						));
			}
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Delete Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
}

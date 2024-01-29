package dao;

import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import database.DBCon;
import entity.Deparment;
import entity.Workschedule;

public class Manage_DepartmentsDAO {
	public List<Deparment> selectDepartments() {
		List<Deparment> list = new ArrayList<>();
		try(Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllDep}");
				ResultSet rs = cs.executeQuery();
			) {
				while(rs.next()) {
					//lấy dữ liệu 
					list.add(new Deparment(
							rs.getInt("department_id"), 
							rs.getString("department_name"), 
							rs.getString("head_of_department"), 
							rs.getString("room")
							));
				}
		} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println("Error Message: " + e.getMessage());
		}
		return list;
	}
	
	public List<Deparment> selectAllDeparment(int pageNumber, int rowOfPage) {
		List<Deparment> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllDep(?,?}");

				) {
			cs.setInt(1,pageNumber);
			cs.setInt(2, rowOfPage);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				Deparment Dep = new Deparment();
						rs.getInt("department_id");
						rs.getString("department_name"); 
						rs.getString("head_of_department"); 
						rs.getString("room");
						list.add(Dep);
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public int countDepartments() {
		int count =0;
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call countDepartments}");
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
	
	public void update(Deparment Dep) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call updateDepartments(?,?,?)}");
				) {
			cs.setString(1, Dep.getDepartment_name());
			cs.setString(2, Dep.getHead_of_department());
			cs.setString(3, Dep.getRoom());
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Update Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean insert(Deparment Dep) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call insertDepartments(?,?,?)}")
				) {
			cs.setString(1, Dep.getDepartment_name());
			cs.setString(2, Dep.getHead_of_department());
			cs.setString(3, Dep.getRoom());
			if(cs.executeUpdate() >0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public void delete(Deparment dep) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call deleteDepartments(?)}")
				) {
			cs.setInt(1,dep.getDepartment_id());
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Delete Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

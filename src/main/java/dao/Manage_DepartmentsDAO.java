package dao;

import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import database.DBCon;
import entity.Department;
import entity.Position;
import entity.Workschedule;

public class Manage_DepartmentsDAO {
	public List<Department> getDepartments(Integer pageNumber, Integer rowOfPage) {
		List<Department> list = new ArrayList<>();
		try(Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getDepartments(?,?)}");
				) {
				cs.setInt(1, pageNumber);
				cs.setInt(2, rowOfPage);
				ResultSet rs = cs.executeQuery();
				while(rs.next()) {
					//lấy dữ liệu 
					list.add(new Department(
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
	
	public List<Department>selectAllDepartment() {
		List<Department> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllDepartment}");
				ResultSet rs = cs.executeQuery();
				) {
			
			while(rs.next()) {
				list.add(new Department(
						rs.getInt("department_id"), 
						rs.getString("department_name"), 
						rs.getString("head_of_department"), 
						rs.getString("room")
						));
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
	
	public void update(Department Dep) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call updateDepartments(?,?,?,?)}");
				) {
			cs.setInt(1, Dep.getDepartment_id());
			cs.setString(2, Dep.getDepartment_name());
			cs.setString(3, Dep.getHead_of_department());
			cs.setString(4, Dep.getRoom());
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Update Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean insert(Department Dep) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call insertDep(?,?,?)}")
				) {
			cs.setString(1, Dep.getDepartment_name());
			cs.setString(2, Dep.getHead_of_department());
			cs.setString(3, Dep.getRoom());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"insert success":"nothing to insert");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void delete(int a) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call deleteDepartments(?)}")
				) {
			cs.setInt(1,a);
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Delete Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



}

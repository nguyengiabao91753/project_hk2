package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.DBCon;
import entity.Employee;

public class EmployeeDAO {
	public List<Employee> selectAllEmployee(){
		List<Employee> list = new ArrayList<>();
		try (
				Connection con = DBCon.getConnection();
				CallableStatement cs = con.prepareCall("{call getAllEmployee}");
				ResultSet rs = cs.executeQuery();
		) {
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("employee_id"));
				emp.setFull_name(rs.getString("full_name"));
				emp.setEthnicity(rs.getString("ethnicity"));
				emp.setDate_of_birth(rs.getDate("date_of_birth").toLocalDate());
				emp.setGender(rs.getBoolean("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setSalary_level(rs.getInt("salary_level"));
				emp.setSupervisor_id(rs.getInt("supervisor_id"));
				emp.setDepartment_id(rs.getInt("department_id"));
				emp.setEducation_id(rs.getInt("education_id"));
				emp.setPosition_id(rs.getInt("position_id"));
				emp.setPicture(rs.getString("image"));
				emp.setLevel(rs.getInt("level"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Employee> selectEmployee(int pageNumber , int rowOfPage){
		List<Employee> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs = con.prepareCall("{call getEmployee(?,?)}");
		){
			cs.setInt(1, pageNumber);
			cs.setInt(2, rowOfPage);
			ResultSet rs = cs.executeQuery();
			//nghĩ cách đóng sau khi làm xong 
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("employee_id"));
				emp.setFull_name(rs.getString("full_name"));
				emp.setEthnicity(rs.getString("ethnicity"));
				emp.setDate_of_birth(rs.getDate("date_of_birth").toLocalDate());
				emp.setGender(rs.getBoolean("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setSalary_level(rs.getInt("salary_level"));
				emp.setSupervisor_id(rs.getInt("supervisor_id"));
				emp.setDepartment_id(rs.getInt("department_id"));
				emp.setEducation_id(rs.getInt("education_id"));
				emp.setPosition_id(rs.getInt("position_id"));
				emp.setPicture(rs.getString("image"));
				emp.setLevel(rs.getInt("level"));
				list.add(emp);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int countEmployee() {
		int count =0;
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call countEmployee}");
				var rs = cs.executeQuery();
		) {
			while(rs.next()) {
				count = rs.getInt("Total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
//	public void insert(Employee emp) {
//		try(
//				var con = DBCon.getConnection();
//				var cs = con.prepareCall("{call insertEmployee(?,?,?,?)}")
//			) {
//			cs.setString(1, cus.getFullname());
//			cs.setBoolean(2, cus.isGender());
//			cs.setString(3, cus.getPicture());
//			cs.setDate(4, java.sql.Date.valueOf(cus.getDob()));
//			
//			
//			JOptionPane.showMessageDialog(null, cs.executeUpdate() >0 ? "insert success" : "nothing to insert" );
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}







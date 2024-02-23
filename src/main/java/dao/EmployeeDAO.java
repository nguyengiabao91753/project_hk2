package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.DBCon;
import entity.Account;
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
				emp.setGender(rs.getString("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setSalary_level(rs.getInt("salary_level"));
				emp.setSupervisor_id(rs.getInt("supervisor_id"));
				emp.setDepartment_id(rs.getInt("department_id"));
				emp.setEducation_id(rs.getInt("education_id"));
				emp.setPosition_id(rs.getInt("position_id"));
				emp.setPicture(rs.getString("image"));
				emp.setLevel(rs.getString("level"));
				list.add(emp);
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

			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("employee_id"));
				emp.setFull_name(rs.getString("full_name"));
				emp.setEthnicity(rs.getString("ethnicity"));
				emp.setDate_of_birth(rs.getDate("date_of_birth").toLocalDate());
				emp.setGender(rs.getString("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setSalary_level(rs.getInt("salary_level"));
				emp.setSupervisor_id(rs.getInt("supervisor_id"));
				emp.setDepartment_id(rs.getInt("department_id"));
				emp.setEducation_id(rs.getInt("education_id"));
				emp.setPosition_id(rs.getInt("position_id"));
				emp.setPicture(rs.getString("image"));
				emp.setLevel(rs.getString("level"));
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
				count = rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//Update
	public void update(Employee emp) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call updateEmployee(?,?,?,?,?,?,?,?,?,?,?,?,?)}")
			) {
			cs.setString(1, emp.getFull_name());
			cs.setString(2, emp.getEthnicity());
			cs.setDate(3, java.sql.Date.valueOf(emp.getDate_of_birth()));
			cs.setString(4, emp.getGender());
			cs.setString(5, emp.getAddress());
			cs.setInt(6, emp.getSalary_level());
			cs.setInt(7, emp.getSupervisor_id());
			cs.setInt(8, emp.getDepartment_id());
			cs.setInt(9, emp.getEducation_id());
			cs.setInt(10, emp.getPosition_id());
			cs.setString(11, emp.getPicture());
			cs.setString(12, emp.getLevel());
			cs.setInt(13, emp.getId());
			
			JOptionPane.showMessageDialog(null, cs.executeUpdate() >0 ? "update success" : "nothing to update" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Insert
	public boolean insert(Employee emp) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call insertEmployee(?,?,?,?,?,?,?,?,?,?,?,?)}" )
			) {
			cs.setString(1, emp.getFull_name());
			cs.setString(2, emp.getEthnicity());
			cs.setDate(3, java.sql.Date.valueOf(emp.getDate_of_birth()));
			cs.setString(4, emp.getGender());
			cs.setString(5, emp.getAddress());
			cs.setInt(6, emp.getSalary_level());
			cs.setInt(7, emp.getSupervisor_id());
			cs.setInt(8, emp.getDepartment_id());
			cs.setInt(9, emp.getEducation_id());
			cs.setInt(10, emp.getPosition_id());
			cs.setString(11, emp.getPicture());
			cs.setString(12, emp.getLevel());
			
			if(cs.executeUpdate() >0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	//Delete
	public void delete(Employee emp) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call deleteEmployee(?)}")
				) {
			cs.setInt(1, emp.getId());
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Delete Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteEmployeeAndAccount(Employee emp, Account acc) {
	    try (
	        var con = DBCon.getConnection();
	        var cs = con.prepareCall("{call deleteEmployeeAndAccount(?, ?)}")
	    ) {
	        cs.setInt(1, emp.getId());
	        cs.setInt(2, acc.getId());
	        cs.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Delete Success");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public Employee getUserById(int userId) { 
	    Employee employee = null;
	    try (Connection con = DBCon.getConnection();
	         CallableStatement cs = con.prepareCall("{call GetUserById(?)}")) {
	        
	        cs.setInt(1, userId);
	        
	        try (ResultSet rs = cs.executeQuery()) {
	            if (rs.next()) {
	                employee = new Employee();
	                employee.setId(rs.getInt("EMPLOYEE_ID"));
	                employee.setFull_name(rs.getString("FULL_NAME"));
	                employee.setEthnicity(rs.getString("ETHNICITY"));
	                if (!rs.wasNull()) {
	                    employee.setDate_of_birth(rs.getDate("DATE_OF_BIRTH").toLocalDate());
	                }
	                employee.setGender(rs.getString("GENDER"));
	                employee.setAddress(rs.getString("ADDRESS"));
	                employee.setSalary_level(rs.getInt("SALARY_LEVEL"));
	                employee.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
	                employee.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
	                employee.setEducation_id(rs.getInt("EDUCATION_ID"));
	                employee.setPosition_id(rs.getInt("POSITION_ID"));
	                employee.setPicture(rs.getString("PICTURE"));
	                employee.setLevel(rs.getString("LEVEL"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return employee;
	}
	
	

}







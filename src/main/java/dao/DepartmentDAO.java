package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Department;
import entity.Salary;

public class DepartmentDAO {
	public List<Department> selectAllDepartment(){
		List<Department> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs = con.prepareCall("{call getAllDepartment}");
				ResultSet rs = cs.executeQuery();
		) {
			while(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("department_id"));
				dep.setDepartment_name(rs.getString("department_name"));
				dep.setHead_of_department(rs.getString("head_of_department"));
				dep.setRoom(rs.getString("room"));
				list.add(dep);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

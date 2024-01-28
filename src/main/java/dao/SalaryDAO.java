package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Salary;

public class SalaryDAO {
	public  List<Salary> selectAllSalary(){
		List<Salary> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs = con.prepareCall("{call getAllSalary}");
				ResultSet rs = cs.executeQuery();
		) {
			while(rs.next()) {
				Salary sal = new Salary();
				sal.setId(rs.getInt("salary_id"));
				sal.setBase_salary(rs.getInt("base_salary"));
				sal.setSalary_factor(rs.getInt("salary_factor"));
				sal.setAllowance_factor(rs.getInt("allowance_factor"));
				list.add(sal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

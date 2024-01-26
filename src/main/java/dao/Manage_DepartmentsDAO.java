package dao;

import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;

import database.DBCon;
import entity.DEPARTMENTS;

public class Manage_DepartmentsDAO {
	public List<DEPARTMENTS> selectDepartments() {
		List<DEPARTMENTS> list = new ArrayList<>();
		try(Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllDep}");
				ResultSet rs = cs.executeQuery();
			) {
				while(rs.next()) {
					//lấy dữ liệu 
					list.add(new DEPARTMENTS(
							rs.getInt("DEPARTMENT_ID"), 
							rs.getString("DEPARTMENT_NAME"), 
							rs.getString("HEAD_OF_DEPARTMENT"), 
							rs.getString("ROOM")
							));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}

}

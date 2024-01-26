package dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;

import database.DBCon;
import entity.Job_PositionE;

public class Job_PositionDAO {
	public List<Job_PositionE> selectDepartments() {
		List<Job_PositionE> list = new ArrayList<>();
		try(Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllCus}");
				ResultSet rs = cs.executeQuery();
			) {
				while(rs.next()) {
					//lấy dữ liệu 
					list.add(new Job_PositionE(
							rs.getInt("POSITION_ID"), 
							rs.getString("POSITION_NAME")
							));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}

}

package dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;

import database.DBCon;
import entity.Job_PositionE;
import entity.Position;

public class Job_PositionDAO {
	public List<Position> selectPosition() {
		List<Position> list = new ArrayList<>();
		try(Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllPos}");
				ResultSet rs = cs.executeQuery();
			) {
				while(rs.next()) {
					//lấy dữ liệu 
					list.add(new Position(
							rs.getInt("position_id"), 
							rs.getString("position_name")
							));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}

}

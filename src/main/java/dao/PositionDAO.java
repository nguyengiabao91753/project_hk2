package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Position;
import entity.Salary;

public class PositionDAO {
	public List<Position> selectAllPosition(){
		List<Position> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs = con.prepareCall("{call getAllPosition}");
				ResultSet rs = cs.executeQuery();
		) {
			while(rs.next()) {
				Position pos = new Position();
				pos.setId(rs.getInt("position_id"));
				pos.setPosition_name(rs.getString("position_name"));
				list.add(pos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

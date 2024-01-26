package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Shift;

public class ShiftDAO {
	
	public List<Shift> getAllShift() {
		List<Shift> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllShift}");
				ResultSet rs = cs.executeQuery();
				) {
			while(rs.next()) {
				list.add(new Shift(
						rs.getInt("shift_id"),
						rs.getString("shift_name"),
						rs.getTime("shift_start").toString(),
						rs.getTime("shift_end").toString()
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}

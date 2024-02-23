package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Room;

public class RoomDAO {
	public List<Room> selectAllRoom() {
		List<Room> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getAllRoom}");
				ResultSet rs = cs.executeQuery();
				) {
			while(rs.next()) {
				list.add(new Room(
						rs.getInt("room_id"),
						rs.getString("name")
						));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}

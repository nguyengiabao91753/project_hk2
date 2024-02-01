package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.DBCon;
import entity.Department;
import entity.Position;
import entity.Salary;

public class PositionDAO {
	public List<Position> getPosition(Integer pageNumber, Integer rowOfPage) {
		List<Position> list = new ArrayList<>();
		try(Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call getPosition(?,?)}");
				) {
				cs.setInt(1, pageNumber);
				cs.setInt(2, rowOfPage);
				ResultSet rs = cs.executeQuery();
				while(rs.next()) {
					//lấy dữ liệu 
					list.add(new Position(
							rs.getInt("position_id"), 
							rs.getString("position_name")
							));
				}
		} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println("Error Message: " + e.getMessage());
		}
		return list;
	}
	
	public List<Position> selectAllPosition(){
		List<Position> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs = con.prepareCall("{call getAllPos}");
				ResultSet rs = cs.executeQuery();
		) {
			while(rs.next()) {
				Position pos = new Position();
				pos.setPosition_id(rs.getInt("position_id"));
				pos.setPosition_name(rs.getString("position_name"));
				list.add(pos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int countPosition() {
		int count =0;
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs =  con.prepareCall("{call countPosition}");
				ResultSet rs = cs.executeQuery();
				) {
			while(rs.next()){
				count=rs.getInt("total");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
	public void insert(Position Pos) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call insertPos(?)}");
			) {
			cs.setString(1,Pos.getPosition_name());
			
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"insert success":"nothing to insert");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(Position Pos) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call updatePos(?,?)}");
				) {
			cs.setInt(1, Pos.getPosition_id());
			cs.setString(2, Pos.getPosition_name());
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Update Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void delete(int a) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call deletePos(?)}")
				) {
			cs.setInt(1,a);
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Delete Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

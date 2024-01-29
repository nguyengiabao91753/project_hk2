package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Education;

public class EducationDAO {
	public List<Education> selectAllEducation(){
		List<Education> list = new ArrayList<>();
		try (
			Connection con = DBCon.getConnection();
			CallableStatement cs = con.prepareCall("{call getAllEducation}");
			ResultSet rs = cs.executeQuery();
			){
				while(rs.next()) {
					Education edu = new Education();
					edu.setId(rs.getInt("education_id"));
					edu.setDegree_name(rs.getString("degree_name"));
					edu.setMajor(rs.getString("major"));
					list.add(edu);
				}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

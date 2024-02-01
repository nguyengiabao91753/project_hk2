
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Account;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBCon;
import entity.Account;


public class AccountDAO {
	
	public List<Account> selectAllAccount() {
		List<Account> list = new ArrayList<>();
		try (
				Connection con = DBCon.getConnection();
				CallableStatement cs = con.prepareCall("{call getAllAccount}");
				ResultSet rs = cs.executeQuery();
		) {
			while(rs.next()) {
				Account cus = new Account();
				cus.setAccount_id(rs.getInt("ACCOUNT_ID"));
				cus.setUsername(rs.getString("USERNAME"));
				cus.setPassword(rs.getString("PASSWORD"));
				list.add(cus);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Account> selectAccount(int pageNumber , int rowOfPage){
		List<Account> list = new ArrayList<>();
		try(
				Connection con = DBCon.getConnection();
				CallableStatement cs = con.prepareCall("{call getAccount(?,?}")
		) {
			cs.setInt(1, pageNumber);
			cs.setInt(2, rowOfPage);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				Account cus = new Account();
				cus.setAccount_id(rs.getInt("ACCOUNT_ID"));
				cus.setUsername(rs.getString("USERNAME"));
				cus.setPassword(rs.getString("PASSWORD"));
				list.add(cus);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}







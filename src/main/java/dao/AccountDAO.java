package dao;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.DBCon;
import entity.Account;
import entity.Employee;


public class AccountDAO {
	
	public List<Account> selectAllAccount() {
		List<Account> list = new ArrayList<>();
		try (
				Connection con = DBCon.getConnection();
				CallableStatement cs = con.prepareCall("{call getAllAccount}");
				ResultSet rs = cs.executeQuery();
		) {
			while(rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getInt("account_id"));
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				list.add(acc);
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
				CallableStatement cs = con.prepareCall("{call getAccount(?,?)}")
		) {
			cs.setInt(1, pageNumber);
			cs.setInt(2, rowOfPage);
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getInt("account_id"));
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				list.add(acc);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int counAccount() {
		int count = 0;
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call countAccount}");
				var rs = cs.executeQuery();
		) {
			while(rs.next()) {
				count = rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count ;
	}
	
	//Update
	public void update(Account acc) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call updateAccount(?,?,?)}")
			) {
			cs.setString(1, acc.getUsername());
			cs.setString(2, acc.getPassword());
			cs.setInt(3, acc.getId());
			
			JOptionPane.showMessageDialog(null, cs.executeUpdate() >0 ? "update success" : "nothing to update" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Insert
	
}








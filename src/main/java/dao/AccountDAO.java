package dao;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
				acc.setStatus(rs.getInt("status"));;
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
				acc.setStatus(rs.getInt("status"));
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
				var cs = con.prepareCall("{call updateAccount(?,?,?,?)}")
			) {
			cs.setString(1, acc.getUsername());
			cs.setString(2, acc.getPassword());
			cs.setInt(3,acc.getStatus());
			cs.setInt(4, acc.getId());
			
			JOptionPane.showMessageDialog(null, cs.executeUpdate() >0 ? "update success" : "nothing to update" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Insert
	public boolean insert(Account acc , int defaultStatus) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call insertAccount(?,?,?)}")
			) {
			cs.setString(1, acc.getUsername());
			cs.setString(2, acc.getPassword());
			cs.setInt(3, defaultStatus);
			if(cs.executeUpdate() >0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	//Block
	public void block(Account acc) {
	    try (
	        var con = DBCon.getConnection();
	        var cs = con.prepareCall("{call blockAccount(?)}")
	    ) {
	        cs.setInt(1, acc.getId());

	        if (cs.executeUpdate() > 0) {
	            JOptionPane.showMessageDialog(null, "Account blocked successfully.");
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	//Delete
	public void deleteAccountAndEmployee(Account acc ,Employee emp) {
		try(
				var con = DBCon.getConnection();
				var cs = con.prepareCall("{call deleteEmployeeAndAccount(?,?)}")
				) {
			cs.setInt(1, acc.getId());
			cs.setInt(2, emp.getId());
			if(cs.executeUpdate() >0) {
				JOptionPane.showMessageDialog(null, "Delete Success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//CHECK USERNAME
	public boolean isUsernameExists(String username) {
	    try (Connection con = DBCon.getConnection();
	    	var cs = con.prepareCall("{call CheckUsernameExists(?)}")) {
	    	cs.setString(1, username);
	        try (ResultSet rs = cs.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0; 
	            }
	        }
	    } catch (SQLException  e) {
	        e.printStackTrace();
	    }
	    return false; 
	}
	
	//Login Admin
	public String login(Account acc) {
        try (Connection con = DBCon.getConnection();
             CallableStatement cs = con.prepareCall("{call LoginAdmin(?, ?)}")) {
            
            cs.setString(1, acc.getUsername());
            cs.setString(2, acc.getPassword());
            
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("message"); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Login failed"; 
    }
	
	//Login User
	public String loginUser(Account acc) {
		try (Connection con = DBCon.getConnection();
	             CallableStatement cs = con.prepareCall("{call loginUser(?, ?)}")) {
	            
	            cs.setString(1, acc.getUsername());
	            cs.setString(2, acc.getPassword());
	            
	            try (ResultSet rs = cs.executeQuery()) {
	                if (rs.next()) {
	                    return rs.getString("message"); 
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return "Login failed";
	}
	
	//Get ID User
	public int getUserId(String username) { 
	    int userId = -1; 
	    try (Connection con = DBCon.getConnection();
	         CallableStatement cs = con.prepareCall("{call GetId(?)}")) {
	        
	        cs.setString(1, username);
	        
	        try (ResultSet rs = cs.executeQuery()) {
	            if (rs.next()) {
	                userId = rs.getInt("EMPLOYEE_ID"); 
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return userId;
	}


}








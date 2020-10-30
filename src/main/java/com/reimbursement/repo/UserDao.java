package com.reimbursement.repo;

import com.reimbursement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.reimbursement.config.EnvironmentConnectionUtil;

public class UserDao implements DaoContract<User, Integer> {

	@Override
	public ArrayList<User> findAll() {
		String sql = "select * from users";
		ArrayList<User> userList = new ArrayList<User>();
		User user = new User(0,"","","","","",User.role.EMPLOYEE);

		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				switch(rs.getInt(7)) {
				case 1:
					user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),User.role.ADMIN);
					userList.add(user);
					break;
				case 2:
					user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),User.role.MANAGER);
					userList.add(user);	
					break;
				case 3:
					user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),User.role.EMPLOYEE);
					userList.add(user);
					break;
				default:
					throw new SQLException();
				}

			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;

	}

	@Override
	public void update(User user) {
		String sql = "update users set username=?, password = ?,first_name= ?,last_name = ? email=?, user_role=? where user_id=?"; 
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(7, user.getId());
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());

			switch(user.getRole()) {
			case ADMIN:
				ps.setInt(6, 1);
				break;
			case MANAGER:
				ps.setInt(6, 2);
				break;
			case EMPLOYEE:
				ps.setInt(6, 3);
				break;	
			}


			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void create(User user) {
		String sql = "insert into users(username,password,first_name,last_name,email,user_role) values (?,?,?,?,?,?)"; // this will sanitize the input
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
		
		ps.setString(1,user.getUsername());
		ps.setString(2,user.getPassword());
		ps.setString(3,user.getFirstName());
		ps.setString(4,user.getLastName());
		ps.setString(5,user.getEmail());
		
		switch(user.getRole()) {
		case ADMIN:
			ps.setInt(6, 1);
			break;
		case MANAGER:
			ps.setInt(6, 2);
			break;
		case EMPLOYEE:
			ps.setInt(6, 3);
			break;	
		}
		
		
		ps.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from users where user_id=?"; // this will sanitize the input
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1,id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public User findById(Integer i) {
		String sql = "select * from users where user_id = ?";
		User user = new User(0,"","","","","",User.role.EMPLOYEE);

		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, i);
			
			ResultSet rs = ps.executeQuery();
			
			switch(rs.getInt(7)) {
			case 1:
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),User.role.ADMIN);
				break;
			case 2:
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),User.role.MANAGER);
				break;
			case 3:
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),User.role.EMPLOYEE);
				break;
			default:
				throw new SQLException();
			}
			
			rs.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}
	
	public User findByUsername(String username) {
		String sql = "select * from users where username = ?";
		User user = new User(0,"","","","","",User.role.EMPLOYEE);

		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			switch(rs.getInt(7)) {
			case 1:
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),User.role.ADMIN);
				break;
			case 2:
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),User.role.MANAGER);
				break;
			case 3:
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),User.role.EMPLOYEE);
				break;
			default:
				throw new SQLException();
			}
			
			rs.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}		
	
	
	
}

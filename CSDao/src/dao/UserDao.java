package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;
import util.DatabaseLink;

public class UserDao {
	// 根据用户id获取用户信息
	public User getUserById(int userId) {
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT * FROM `user` WHERE user_id=?";
		User ret = null;
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, userId);
				ResultSet rs = stat.executeQuery();
				while (rs.next()) {
					ret = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_portrait"));
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	// 更新用户头像
	public int updateUserImg(String filename, int userId) {
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "UPDATE `user` SET user_portrait=? WHERE user_id=?";

		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setString(1, filename);
				stat.setInt(2, userId);
				stat.execute();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
		}
		return 1;
	}

	// 用户登录
	public User login(String userName, String userPassword) {
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT * FROM `user` WHERE user_name = '" + userName + "' AND user_password='" + userPassword
				+ "'";
		User user = null;
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				ResultSet rs = stat.executeQuery();
				while (rs.next()) {
					user = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_portrait"));
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	//用户注册
	public User register(String userName, String password){
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT * FROM `user` WHERE user_name = '"+ userName +"'";
		User user = null;
		String portrait = "default.jpg";
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				ResultSet rs = stat.executeQuery();
				if(!rs.next()){
					rs.close();
					stat.close();
					String newStr = "INSERT INTO `user` (user_name, user_password, user_portrait) VALUES ('"+userName+"','"+password+"','"+portrait+"')";
					stat = conn.prepareStatement(newStr);
					stat.execute();
					stat.close();
					newStr = "SELECT * FROM `user` WHERE user_name = '"+userName+"'";
					stat = conn.prepareStatement(newStr);
					rs = stat.executeQuery();
					while(rs.next()){
						user = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_portrait"));
					}
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
		
	}
}

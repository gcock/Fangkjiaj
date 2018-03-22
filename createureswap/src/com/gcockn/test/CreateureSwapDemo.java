package com.gcockn.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateureSwapDemo {

	public static void main(String[] args){
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=LCYS00012017";
		String name="sa";
		String pwd = "123";
		ArrayList<User> userList =new ArrayList<>(); 
		User user  = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,name,pwd);
			String sql = "select userName,userDescription from userProfile";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			while(result.next()){
				user = new User();
				String userName = result.getString("userName");
				String userProfile = result.getString("userDescription");
				user.setName(userName);
				user.setDescription(userProfile);
				userList.add(user);	
			}
			
			for(User u:userList){
				System.out.println(u.getName()+"\t"+u.getDescription());
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
}
}

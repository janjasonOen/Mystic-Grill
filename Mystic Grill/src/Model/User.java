package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Connect;



public class User {
	
	private int UserID;
	private String UserRole;
	private String UserName;
	private String UserEmail;
	private String UserPassword;
	
	public User(int userID, String userRole, String userName, String userEmail, String userPassword) {
		UserID = userID;
		UserRole = userRole;
		UserName = userName;
		UserEmail = userEmail;
		UserPassword = userPassword;	
	}
	
	public User() {
        // Gunakan ini jika perlu inisialisasi khusus
    }

	public static ArrayList<User> loadUser(){
		ArrayList<User> user = new ArrayList<>();
		String query = "SELECT * FROM user";
		ResultSet resultSet = Connect.getConnection().executeQuery(query);
		
		try {
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String role = resultSet.getString(2);
				String name = resultSet.getString(3);
				String email = resultSet.getString(4);
				String password = resultSet.getString(5);
				
				user.add(new User(id ,role, name, email, password));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public void registerUser(String name, String email, String password) {
		 String defaultUserRole = "Customer";
	     String query = "INSERT INTO user (userRole, userName, userEmail, userPassword) VALUES (?, ?, ?, ?)";
	     try (PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(query)) {
	            preparedStatement.setString(1, defaultUserRole);
	            preparedStatement.setString(2, name);
	            preparedStatement.setString(3, email);
	            preparedStatement.setString(4, password);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();   
	        }
	}
	
	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

}

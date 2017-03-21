package net.remote.remoteServer.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static DBConnection instance = null;
	protected Connection conn = null;
	
	public DBConnection(){
		
	}
	
	public static DBConnection getInstance(){
		if(instance == null){
			instance = new DBConnection();
		}
		return instance;
	}
	
	public void connectDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/remotedb";
			String db_Id = "admin";
			String db_Password = "admin";
			String property = "?characterEncoding=EUC_KR";
			conn = DriverManager.getConnection(url+property,db_Id,db_Password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

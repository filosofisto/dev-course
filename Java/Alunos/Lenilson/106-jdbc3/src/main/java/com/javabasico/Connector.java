package com.javabasico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public Connection makeConnection() 
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost/devcourse";
//<<<<<<< HEAD
		return DriverManager.getConnection(url, "root", "Len@cpb2018");
//=======
//		return DriverManager.getConnection(url, "root", "socrates");
//>>>>>>> b46103c03314d1db0249a76854290cefa3baaaef
	}
}

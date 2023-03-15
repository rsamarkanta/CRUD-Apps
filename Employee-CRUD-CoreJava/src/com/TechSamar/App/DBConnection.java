package com.TechSamar.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static Connection con;

	public static Connection createDbConnection() {
		// load driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/employeedb";
			String username = "root";
			String password = "root";

			// get Connection
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return con;
	}
}

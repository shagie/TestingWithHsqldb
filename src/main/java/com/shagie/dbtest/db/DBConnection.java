package com.shagie.dbtest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

class DBConnection {


	public Connection getDBConnection() throws SQLException {
		Connection conn = null;

		try {
			ResourceBundle rb = ResourceBundle.getBundle("connection_config");

			String sDriverName;
			sDriverName = rb.getString("driver.name");
			String sServerName = rb.getString("server.name");
			String sPort = rb.getString("port.no");
			String sDatabaseName = rb.getString("database.name");
			String sUserName = rb.getString("user.name");
			String sPassword = rb.getString("user.password");

			Class.forName(sDriverName).newInstance();

			String sURL = "jdbc:mysql://" + sServerName + ":" + sPort + "/" + sDatabaseName;

			conn = DriverManager.getConnection(sURL, sUserName, sPassword);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

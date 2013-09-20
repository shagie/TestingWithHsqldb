package com.shagie.dbtest.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DBConnection {


	public Connection getDBConnection() throws SQLException {
		Connection conn = null;

		try {
			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream("/connection_config.properties");
			prop.load(in);
			in.close();

			String sDriverName;
			sDriverName = prop.getProperty("driver.name");
			String sDBFlavor = prop.getProperty("db.flavor");
			String sServerName = prop.getProperty("server.name");
			String sPort = prop.getProperty("port.no");
			String sDatabaseName = prop.getProperty("database.name");
			String sUserName = prop.getProperty("user.name");
			String sPassword = prop.getProperty("user.password");

			Class.forName(sDriverName).newInstance();

			String sURL = "jdbc:" + sDBFlavor + "://" + sServerName + ":" + sPort + "/" + sDatabaseName;

			conn = DriverManager.getConnection(sURL, sUserName, sPassword);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

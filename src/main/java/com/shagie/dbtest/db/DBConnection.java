package com.shagie.dbtest.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DBConnection {

	/**
	 * Get a database connection based on connection_config.properties
	 *
	 * @return connection to database specified.
	 * @throws SQLException
	 */
	public Connection getDBConnection() throws SQLException {
		Connection conn = null;

		try {
			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream("/connection_config.properties");
			prop.load(in);
			in.close();

			String driverName = prop.getProperty("driver.name");
			String userName = prop.getProperty("user.name");
			String password = prop.getProperty("user.password");

			String dbUrl = prop.getProperty("db.url");
			if (dbUrl == null) {
				String dbFlavor = prop.getProperty("db.flavor");
				String serverName = prop.getProperty("server.name");
				String port = prop.getProperty("port.no");
				String databaseName = prop.getProperty("database.name");

				dbUrl = "jdbc:" + dbFlavor + "://" + serverName + ":" + port + "/" + databaseName;
			}

			Class.forName(driverName).newInstance();

			conn = DriverManager.getConnection(dbUrl, userName, password);
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

package com.shagie.dbtest.db;

import com.shagie.dbtest.db.objects.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DataAccess {
	DBConnection db;

	public DataAccess() {
		db = new DBConnection();
	}


	public List<Data> getData() {
		Connection conn = null;
		List<Data> ret = new LinkedList<Data>();
		try {
			conn = db.getDBConnection();
			PreparedStatement ps = conn.prepareStatement("select id, txt from data where active = 1 and" +
																				" ts > now() - interval 1 HOUR ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ret.add(new Data(rs.getInt("id"), rs.getString("txt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		return ret;
	}
}

package com.shagie.dbtest.db;

import com.shagie.dbtest.db.objects.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DataAccess {
	final private DBConnection db;

	public DataAccess() {
		db = new DBConnection();
	}

	public List<Data> getData() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Data> ret = new LinkedList<Data>();
		try {
			conn = db.getDBConnection();
			ps = conn.prepareStatement("SELECT id, txt FROM data WHERE active = 1 AND" +
											   " ts > now() - INTERVAL 1 HOUR ");
			rs = ps.executeQuery();
			while (rs.next()) {
				ret.add(new Data(rs.getInt("id"), rs.getString("txt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		return ret;
	}

	public void markInactive(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getDBConnection();
			ps = conn.prepareStatement("UPDATE data SET active = 0 WHERE id = ?");
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	public void addData(String value) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getDBConnection();
			ps = conn.prepareStatement("INSERT INTO data (txt, active) VALUES (?, 1)");
			ps.setString(1, value);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}
}

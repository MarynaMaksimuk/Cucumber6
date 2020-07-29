package com.hrms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbUtils {
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;

	public static void getConnection() {
		try {
			conn = DriverManager.getConnection(ConfigsReader.getPropery("dbUrl"),
					ConfigsReader.getPropery("dbUsername"), ConfigsReader.getPropery("dbPassword"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void closeConnection() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}try {
			if (conn!=null) {
				conn.close();}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

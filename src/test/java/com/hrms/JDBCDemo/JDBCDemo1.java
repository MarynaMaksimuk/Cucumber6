package com.hrms.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCDemo1 {
	
	String url="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	String userName="syntax_hrm";
	String password="syntaxhrm123";
		
	@Test
	public void connection() throws SQLException {
		Connection conn=DriverManager.getConnection(url, userName, password);
		System.out.println("Connected successfully");
		Statement st =conn.createStatement();
		ResultSet rs= st.executeQuery("select * from hs_hr_employees");
		rs.next();
		String name = rs.getString("emp_firstname");
		System.out.println(name);
		
		while (rs.next()) {
			String Data = rs.getObject("emp_firstname").toString();
			System.out.println(Data);
		}
		rs.close();
		st.close();
		conn.close();
	}
		
		@Test
		public void listTask() throws SQLException {
		Connection conn1 = DriverManager.getConnection(url, userName, password);
		Statement st1= conn1.createStatement();
		ResultSet rs1=st1.executeQuery("select * from ohrm_job_title");
		List<String> DataList = new ArrayList<String>();
		
		while (rs1.next()) {
			String jobTitle = rs1.getObject("job_title").toString();
			DataList.add(jobTitle);
		}System.out.println(DataList);
	}
}

package com.hrms.API.steps.practice;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatbasetestAutomation {

	private Connection conn;
	private Statement stat;
	private ResultSet result;

	@Given("user creat connection with SyntaxHRMS database")
	public void user_creat_connection_with_SyntaxHRMS_database() {
		String url = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
		String user = "syntax_hrm";
		String password = "syntaxhrm123";
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Given("user creates a statement")
	public void user_creates_a_statement() {
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@When("user retrives all job titles from SyntaxHRMS database")
	public void user_retrives_all_job_titles_from_SyntaxHRMS_database() {
		try {
			result = stat.executeQuery("select distinct job_title from ohrm_job_title");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Then("user validates results for job titles")
	public void user_validates_results_for_job_titles(DataTable dataTable) throws SQLException {
	    List <Map<String, String>> expectedResult = dataTable.asMaps();
	    Iterator<Map<String, String>> it=expectedResult.iterator();
	    result.next();
	    
	    while (it.hasNext()) {
	    	Map<String, String> expRes = it.next();
	    	String extJobTitle= expRes.get("job_title");
	    	String actJobTitle = result.getString("job_title");
	    	result.next();
	    	assertEquals(actJobTitle, extJobTitle);
	    }
	}

	@Then("user closes all connections")
	public void user_closes_all_connections() {
		try {
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

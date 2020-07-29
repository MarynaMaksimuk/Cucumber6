package com.hrmsAPI.utils;

import com.hrms.API.steps.practice.HardcodedExamples1;

public class PayloadConstants {
	public static String createEmployee() {
		/**
		 * create employee body
		 */
		String createEmployeeBody = "{\r\n" + "  \"emp_firstname\": \"Michael\",\r\n"
				+ "  \"emp_lastname\": \"O'Neil\",\r\n" + "  \"emp_middle_name\": \"F\",\r\n"
				+ "  \"emp_gender\": \"M\",\r\n" + "  \"emp_birthday\": \"1980-07-11\",\r\n"
				+ "  \"emp_status\": \"Employee\",\r\n" + "  \"emp_job_title\": \"IT Analyst\"\r\n" + "}";
		return createEmployeeBody;

	}
	/**
	 * update created employee body
	 * @return
	 */
	public static String updateCreatedEmployee() {
		String updateEmplBody = "{\r\n" + 
				"  \"employee_id\": \""+ HardcodedExamples1.employeeID + \",\r\n" + 
				"  \"emp_firstname\": \"Mike\",\r\n" + 
				"  \"emp_lastname\": \"O'Neil\",\r\n" + 
				"  \"emp_middle_name\": \"F\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"1980-07-11\",\r\n" + 
				"  \"emp_status\": \"Independent contractor\",\r\n" + 
				"  \"emp_job_title\": \"IT Analyst\"\r\n" + 
				"}";
		return updateEmplBody;
	}
}


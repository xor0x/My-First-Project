package com.project.service;

import com.project.sql.EmployeeDAOJDBCTemplateImpl;
import java.io.IOException;
import java.net.Socket;
import org.apache.commons.configuration.ConfigurationException;

public class CheckOnOffSqlServer {
   private  EmployeeDAOJDBCTemplateImpl emp;
	public boolean checkserver() throws ConfigurationException {
            emp = new EmployeeDAOJDBCTemplateImpl();
            
		String server = emp.Load().getProperty("url");
            
		int port = Integer.parseInt(emp.Load().getProperty("port"));
		try (Socket s = new Socket(server, port)) {
			return true;
		} catch (IOException ex) {
			/* ignore */
		}
		return false;

	}
}

package com.project.sql;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;

public interface EmployeeDAO {

	// Add User
	public void adduser(Employee employee);

	// Login user
	public int login(Employee employee);

	// Select Student
	public String SelStudentName(int id);

	// Select Teacher
	public String SelTeacherName(int id);

	// Search User
	public boolean searchuser(String user) throws SQLException;

	// Select student for html Editor
	public String[] selshtml();

	// Select teacher for html Editor
	public String[] selthtml();

	// View Rss Channel
	public String selrss();

	// Select Template
	public String seltemplate();

	// CHange Template
	public void uptemplate(String name);

	// CHange Name of Student Frame
	public void UpdNameStudent(Employee employee);

	// CHange Name of Teacher Frame
	public void UpdNameTeacher(Employee employee);

	// Update Rss Channel
	public void updaterss(String name);

	// Set message to database Student
	public void sendshtml(String name, String text, String Datestart,
			String Dateend);

	// Set message to database Teacher
	public void sendthtml(String name, String text, String Datestart,
			String Dateend);

	// Get message from database Student
	public List<String> getshtml(String frame);

	// Get message from database Student
	public List<String> getthtml(String frame);

	// Set Status Message on
	public void onstatus();

	// Set Status Message off
	public void offstatus();

	// Set Status Message on
	public void onstatus2();

	// Set Status Message off
	public void offstatus2();

	// Load sql properties
	public Properties Load() throws ConfigurationException;
        

	// Write sql properties
	public void Write(String data, String port, String User, String Password, String serverport);
        
        // Create sql properties
	public void Create( );

        
        

}

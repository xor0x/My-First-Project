package com.project.client;

import java.sql.SQLException;
import java.util.List;

public interface GreetingService {

	// String getGreeting(String name);
	// Add user
	public void adduser(String user, String pass, int group);

	// Login user
	public int login(String user, String pass);

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
	public void UpdNameStudent(String name, int id);

	// CHange Name of Teacher Frame
	public void UpdNameTeacher(String name, int id);

	// Update Rss Channel
	public void updaterss(String name);

	// Set message to database Student
	public void sendshtml(String name, String text, String Datestart,
			String Dateend);

	// Set message to database Teacher
	public void sendthtml(String name, String text, String Datestart,
			String Dateend);

	// Set ip Client
	public void sendip(String ip);

	// Send disc. user/ip
	public void disc(String ip);

	// Get message from database Student
	public List<String> getshtml(String frame );

	// Get message from database Teacher
	public List<String> getthtml(String frame);
        
        // Check Sql Server Status
        public boolean checksqlserver();

}
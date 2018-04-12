package com.project.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.interfaces.GreetingService;
import com.project.sql.Employee;
import com.project.sql.EmployeeDAO;
import com.project.sql.EmployeeDAOJDBCTemplateImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.configuration.ConfigurationException;

public class GreetingServiceImpl implements GreetingService {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"sql-config.xml");
	EmployeeDAO employeeDAO = ctx.getBean("employeeDAOJDBCTemplate",
			EmployeeDAOJDBCTemplateImpl.class);
	Employee emp = new Employee();
        private CheckOnOffSqlServer csserver = new CheckOnOffSqlServer();

	@Override
	public void adduser(String user, String pass, int group) {
		emp.setUser(user);
		emp.setPass(pass);
		emp.setGroup(group);
		employeeDAO.adduser(emp);

	}

	@Override
	public int login(String user, String pass) {
		emp.setUser(user);
		emp.setPass(pass);
		return employeeDAO.login(emp);

	}

	@Override
	public String SelStudentName(int id) {
		return employeeDAO.SelStudentName(id);

	}

	@Override
	public String SelTeacherName(int id) {
		return employeeDAO.SelTeacherName(id);

	}

	@Override
	public boolean searchuser(String user) throws SQLException {
		return employeeDAO.searchuser(user);

	}

	@Override
	public String[] selshtml() {
		return employeeDAO.selshtml();

	}

	@Override
	public String[] selthtml() {
		return employeeDAO.selthtml();

	}

	@Override
	public String selrss() {
		return employeeDAO.selrss();

	}

	@Override
	public String seltemplate() {
		return employeeDAO.seltemplate();

	}

	@Override
	public void uptemplate(String name) {
		employeeDAO.uptemplate(name);

	}

	@Override
	public void UpdNameStudent(String name, int id) {
		emp.setName(name);
		emp.setId(id);
		employeeDAO.UpdNameStudent(emp);

	}

	@Override
	public void UpdNameTeacher(String name, int id) {
		emp.setName(name);
		emp.setId(id);
		employeeDAO.UpdNameTeacher(emp);

	}

	@Override
	public void updaterss(String name) {
		employeeDAO.updaterss(name);

	}

	@Override
	public void sendshtml(String name, String text, String Datestart,
			String Dateend) {
		employeeDAO.sendshtml(name, text, Datestart, Dateend);

	}

	@Override
	public void sendthtml(String name, String text, String Datestart,
			String Dateend) {
		employeeDAO.sendthtml(name, text, Datestart, Dateend);

	}

	@Override
	public void sendip(String ip) {
		System.out.println(ip + " is  connected. ");
	}

	@Override
	public void disc(String ip) {
		System.out.println(ip + " is  disconnected. ");

	}

	@Override
	public List<String> getshtml(String frame) {

		return employeeDAO.getshtml(frame);

	}

	@Override
	public void onstatus() {
		employeeDAO.onstatus();

	}

	@Override
	public void offstatus() {
		employeeDAO.offstatus();

	}

	@Override
	public List<String> getthtml(String frame) {
		return employeeDAO.getthtml(frame);

	}

	@Override
	public void onstatus2() {
		employeeDAO.onstatus2();

	}

	@Override
	public void offstatus2() {
		employeeDAO.offstatus2();

	}

    @Override
    public boolean checksqlserver() {
            
            try {
                return csserver.checkserver();
            } catch (ConfigurationException ex) {
                
            }
            return false;
            
    }

}

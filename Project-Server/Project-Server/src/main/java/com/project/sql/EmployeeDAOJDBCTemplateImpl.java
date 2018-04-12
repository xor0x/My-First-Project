package com.project.sql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;
import javax.swing.Timer;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDAOJDBCTemplateImpl implements EmployeeDAO {

	private DataSource dataSource;

	private Timer timer = new Timer(0, null);;
	private Timer timer2 = new Timer(0, null);

	// Date datedodc;
	// datedodc = cal.getTime();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void adduser(Employee employee) {
		String query = "INSERT  INTO  [Alex].[dbo].[tblUsers] (Username,Password,Groups) VALUES (?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object[] args = new Object[] { employee.getUser(), employee.getPass(),
				employee.getGroup() };

		jdbcTemplate.update(query, args);

	}

	@Override
	public int login(Employee employee) {
		try {
			String query = " SELECT Username,Password,Groups FROM [Alex].[dbo].[tblUsers] WHERE Username = ? And Password = ?";

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			// using RowMapper anonymous class, we can create a separate
			// RowMapper
			// for reuse
			Employee emp = jdbcTemplate.queryForObject(query, new Object[] {
					employee.getUser(), employee.getPass() },
					new RowMapper<Employee>() {

						public Employee mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Employee emp = new Employee();
							emp.setGroup(rs.getInt("Groups"));

							System.out.println(emp);
							return emp;
						}
					});

			System.out.println(emp.getGroup());
			return emp.getGroup();

		} catch (EmptyResultDataAccessException e) {
			return 5;
		}

	}

	@Override
	public String SelStudentName(int id) {
		String query = " SELECT Name FROM [Alex].[dbo].[tblStudentFrame] WHERE Id = ? ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[] { id },
				new RowMapper<Employee>() {

					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Employee emp = new Employee();
						emp.setName(rs.getString("Name"));
						return emp;
					}
				});

		return emp.getName();
	}

	@Override
	public String SelTeacherName(int id) {
		String query = " SELECT Name FROM [Alex].[dbo].[tblTeacherFrame] WHERE Id = ? ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[] { id },
				new RowMapper<Employee>() {

					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Employee emp = new Employee();
						emp.setName(rs.getString("Name"));
						return emp;
					}
				});

		return emp.getName();
	}

	@Override
	public boolean searchuser(String user) throws SQLException {
		String query = "SELECT Username FROM [Alex].[dbo].[tblUsers]";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		boolean login = true;
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String, Object>> empRows = jdbcTemplate.queryForList(query);

		for (Map<String, Object> empRow : empRows) {
			Employee emp = new Employee();
			emp.setUser(String.valueOf(empRow.get("Username")));
			empList.add(emp);
			if (user.equals(emp.getUser()))
				login = false;
		}
		System.out.println(login);
		return login;
	}

	@Override
	public String[] selshtml() {
		String query = "SELECT Name FROM [Alex].[dbo].[tblStudentFrame]";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String, Object>> empRows = jdbcTemplate.queryForList(query);
		String arr[] = new String[5];
		int i = 0;
		for (Map<String, Object> empRow : empRows) {
			Employee emp = new Employee();
			emp.setName(String.valueOf(empRow.get("Name")));
			arr[i++] = emp.getName();
			empList.add(emp);
		}

		return arr;

	}

	@Override
	public String[] selthtml() {
		String query = "SELECT Name FROM [Alex].[dbo].[tblTeacherFrame]";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String, Object>> empRows = jdbcTemplate.queryForList(query);
		String arr[] = new String[5];
		int i = 0;
		for (Map<String, Object> empRow : empRows) {
			Employee emp = new Employee();
			emp.setName(String.valueOf(empRow.get("Name")));
			arr[i++] = emp.getName();
			empList.add(emp);
		}
		return arr;
	}

	@Override
	public String selrss() {
		String query = "SELECT RssUrl FROM [Alex].[dbo].[tblSettings]";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[] {},
				new RowMapper<Employee>() {

					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Employee emp = new Employee();
						emp.setName(rs.getString("RssUrl"));
						return emp;
					}
				});

		return emp.getName();
	}

	@Override
	public String seltemplate() {
		String query = "SELECT Template FROM [Alex].[dbo].[tblSettings] WHERE Id = 1 ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[] {},
				new RowMapper<Employee>() {

					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Employee emp = new Employee();
						emp.setTemp(rs.getString("Template"));
						return emp;
					}
				});

		return emp.getTemp();
	}

	@Override
	public void uptemplate(String name) {

		String query = "UPDATE [Alex].[dbo].[tblSettings] SET Template = ? WHERE Id = 1";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] { name };

		jdbcTemplate.update(query, args);

	}

	@Override
	public void UpdNameStudent(Employee employee) {
		String query = "UPDATE [Alex].[dbo].[tblStudentFrame] SET Name = ? WHERE Id = ? ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] { employee.getName(), employee.getId() };

		jdbcTemplate.update(query, args);

	}

	@Override
	public void UpdNameTeacher(Employee employee) {
		String query = "UPDATE [Alex].[dbo].[tblTeacherFrame] SET Name = ? WHERE Id = ? ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] { employee.getName(), employee.getId() };

		jdbcTemplate.update(query, args);

	}

	@Override
	public void updaterss(String name) {
		String query = "UPDATE [Alex].[dbo].[tblSettings] SET RssUrl = ? ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] { name };

		jdbcTemplate.update(query, args);

	}

	@Override
	public void sendshtml(String name, String text, String datestart,
			String dateend) {
		String query = "INSERT  INTO  [Alex].[dbo].[tblStudentText] (Frame,Text,StartD,EndD) VALUES (?,?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object[] args = new Object[] { name, text, datestart, dateend };

		jdbcTemplate.update(query, args);

	}

	@Override
	public void sendthtml(String name, String text, String datestart,
			String dateend) {
		String query = "INSERT  INTO  [Alex].[dbo].[tblTeacherText] (Frame,Text,StartD,EndD) VALUES (?,?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object[] args = new Object[] { name, text, datestart, dateend };

		jdbcTemplate.update(query, args);

	}

	@Override
	public List<String> getshtml(String frame) {
		// create a calendar
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");

		try {

			String query = "SELECT Text FROM [Alex].[dbo].[tblStudentText] Where Frame = ?  And StartD = ?  And Status = 1 ";

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// using RowMapper anonymous class, we can create a separate
			// RowMapper
			// for reuse

			Object[] args = new Object[] { frame,
					formater.format(cal.getTime()) };
			List<Employee> empList = new ArrayList<Employee>();

			List<Map<String, Object>> empRows = jdbcTemplate.queryForList(
					query, args);
			List<String> arr = new ArrayList<>();
			int i = 0;

			for (Map<String, Object> empRow : empRows) {
				Employee emp = new Employee();

				emp.setName(String.valueOf(empRow.get("Text")));
				arr.add(i++, emp.getName());

			}

			return arr;
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
	}

	@Override
	public void onstatus() {

		ActionListener updater = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
				String query = "UPDATE [Alex].[dbo].[tblStudentText] SET Status = 1 Where StartD = ?  ";
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				Object[] args = new Object[] { formater.format(cal.getTime()) };

				jdbcTemplate.update(query, args);

			}
		};
		timer.setDelay(100000);// ///refresh miliseconds
		timer.addActionListener(updater);
		timer.start();
	}

	@Override
	public void offstatus() {
		ActionListener updater2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
				String query = "UPDATE [Alex].[dbo].[tblStudentText] SET Status = 0 Where EndD = ?  ";
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				Object[] args = new Object[] { formater.format(cal.getTime()) };

				jdbcTemplate.update(query, args);
			}
		};
		timer2.setDelay(100000);// ///refresh miliseconds
		timer2.addActionListener(updater2);
		timer2.start();
	}

	@Override
	public List<String> getthtml(String frame) {
		// create a calendar
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		try {
			String query = "SELECT Text FROM [Alex].[dbo].[tblTeacherText] Where Frame = ?  And StartD = ?  And Status = 1 ";

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			// using RowMapper anonymous class, we can create a separate
			// RowMapper
			// for reuse

			Object[] args = new Object[] { frame,
					formater.format(cal.getTime()) };
			List<Employee> empList = new ArrayList<Employee>();

			List<Map<String, Object>> empRows = jdbcTemplate.queryForList(
					query, args);
			List<String> arr = new ArrayList<>();
			int i = 0;
			for (Map<String, Object> empRow : empRows) {
				Employee emp = new Employee();
				emp.setName(String.valueOf(empRow.get("Text")));
				arr.add(i++, emp.getName());

			}

			return arr;
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
	}

	@Override
	public void onstatus2() {
		ActionListener updater = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
				String query = "UPDATE [Alex].[dbo].[tblTeacherText] SET Status = 1 Where StartD = ?  ";
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				Object[] args = new Object[] { formater.format(cal.getTime()) };

				jdbcTemplate.update(query, args);

			}
		};
		timer.setDelay(100000);// ///refresh miliseconds
		timer.addActionListener(updater);
		timer.start();

	}

	@Override
	public void offstatus2() {
		ActionListener updater2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
				String query = "UPDATE [Alex].[dbo].[tblTeacherText] SET Status = 0 Where EndD = ?  ";
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				Object[] args = new Object[] { formater.format(cal.getTime()) };

				jdbcTemplate.update(query, args);
			}
		};
		timer2.setDelay(100000);// ///refresh miliseconds
		timer2.addActionListener(updater2);
		timer2.start();

	}

	@Override
	public Properties Load() throws ConfigurationException {



            
            Properties properties = new Properties();
            try {
			File file = new File("server-config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			
			properties.load(fileInput);
			fileInput.close();

			Enumeration enuKeys = properties.keys();
                        int i = 0;
			while (enuKeys.hasMoreElements()) {
                            
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
                               
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
            
            
            
            
		return properties;
	}

	@Override
	public void Write(String data, String port, String User, String Password, String serverport) {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream(
					"server-config.properties");

			// set the properties value
			prop.setProperty("url", data);
                        prop.setProperty("port", port);
			prop.setProperty("username", User);
			prop.setProperty("password", Password);
                        prop.setProperty("serverport", serverport);

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		

	}

    @Override
    public void Create() {
        
        		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream(
					"server-config.properties");

			// set the properties value
			prop.setProperty("url", "0");
                        prop.setProperty("port", "0");
			prop.setProperty("username", "0");
			prop.setProperty("password", "0");
                        prop.setProperty("serverport","0");
                        

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
        
    }

   
      
    

}

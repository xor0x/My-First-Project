package com.project.run;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.interfaces.GreetingService;
import com.project.service.CheckInternt;
import com.project.service.CheckOnOffSqlServer;
import com.project.service.Config;
import com.project.sql.EmployeeDAOJDBCTemplateImpl;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartServer {

	private JFrame frame;

	private PrintStream standardOut;
	private Timer timer;
	private Timer timer2;

	private CheckOnOffSqlServer checkserver;
	private CheckInternt checkinterntet;
	private JLabel lblStatusSql;
	private JLabel lblTimer;
	private JLabel lblIntOffOn;

	private Config sqlcon;
        private EmployeeDAOJDBCTemplateImpl emp;
        
        

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartServer window = new StartServer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		checkserver = new CheckOnOffSqlServer();
		checkinterntet = new CheckInternt();
               
		timer = new Timer(0, null);
		timer2 = new Timer(0, null);
                
                

		frame = new JFrame();
		frame.setBounds(100, 100, 719, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 703, 368);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnStart = new JButton("Start Server");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				printLog();
			}
		});
		btnStart.setBounds(10, 11, 113, 23);
		panel.add(btnStart);

		JTextArea textArea = new JTextArea();
		textArea.setTabSize(12);
		textArea.setBounds(190, 11, 157, 119);
		textArea.setEditable(false);
		PrintStream printStream = new PrintStream(new CustomOutputStream(
				textArea));
		// panel.add(textArea);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 149, 683, 208);
		panel.add(scrollPane);

		JLabel lblStatus = new JLabel("Status of SQL Server");
		lblStatus.setFont(new Font("David", Font.BOLD, 14));
		lblStatus.setBounds(559, 4, 134, 36);
		panel.add(lblStatus);

		// keeps reference of standard output stream
		standardOut = System.out;

		// re-assigns standard output stream and error output stream
		System.setOut(printStream);
		System.setErr(printStream);

		lblStatusSql = new JLabel("");
		lblStatusSql.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusSql.setFont(new Font("David", Font.BOLD, 20));
		lblStatusSql.setBounds(569, 35, 125, 24);
		ActionListener updater = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                            try {
                                if (checkserver.checkserver())// /////Check if server online (if
                                    // open admin panel)
                                    lblStatusSql
                                            .setText("<html><font color='green'>Online</font></html>");// //true
                                else
                                    lblStatusSql
                                            .setText("<html><font color='red'>Offline</font></html>");// //false
                            } catch (ConfigurationException ex) {
                                Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		};
		timer.setDelay(7000);// ///refresh miliseconds
		timer.addActionListener(updater);
		timer.start();
		panel.add(lblStatusSql);

		JLabel lblip = new JLabel("");
		lblip.setForeground(new Color(0, 128, 0));
		lblip.setFont(new Font("David", Font.BOLD, 18));
		lblip.setBounds(432, 35, 99, 24);

		InetAddress ip = null;
		try {

			ip = InetAddress.getLocalHost();

		} catch (UnknownHostException e) {

			e.printStackTrace();

		}
		lblip.setText(ip.getHostAddress());
		panel.add(lblip);

		JLabel lblIpAddressOf = new JLabel("Ip address of server");
		lblIpAddressOf.setFont(new Font("David", Font.BOLD, 15));
		lblIpAddressOf.setBounds(404, 4, 145, 36);
		panel.add(lblIpAddressOf);

		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("David", Font.BOLD, 16));
		lblTime.setBounds(442, 71, 46, 14);
		panel.add(lblTime);

		lblTimer = new JLabel("");
		lblTimer.setForeground(new Color(128, 128, 128));
		lblTimer.setFont(new Font("David", Font.BOLD, 16));
		lblTimer.setBounds(359, 87, 208, 23);
		ActionListener updater2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Calendar cal = Calendar.getInstance();

				lblTimer.setText(cal.getTime().toString());

			}
		};
		timer2.setDelay(1000);// ///refresh miliseconds
		timer2.addActionListener(updater2);
		timer2.start();
		panel.add(lblTimer);

		JLabel lblInternet = new JLabel("Internet connection");
		lblInternet.setFont(new Font("David", Font.BOLD, 16));
		lblInternet.setBounds(558, 70, 135, 14);
		panel.add(lblInternet);

		lblIntOffOn = new JLabel("");
		lblIntOffOn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntOffOn.setFont(new Font("David", Font.BOLD, 20));
		lblIntOffOn.setBounds(569, 87, 104, 23);
		ActionListener updater3 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (checkinterntet.check())// /////Check if internet online (if
											// open admin panel)
					lblIntOffOn
							.setText("<html><font color='green'>Online</font></html>");// //true
				else
					lblIntOffOn
							.setText("<html><font color='red'>Offline</font></html>");// //false
			}
		};
		timer.setDelay(7000);// ///refresh miliseconds
		timer.addActionListener(updater3);
		timer.start();

		panel.add(lblIntOffOn);

		JButton btnSqlConfig = new JButton("Config");
		btnSqlConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					sqlcon = new Config();
				} catch (ConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sqlcon.setVisible(true);
			}
		});
		btnSqlConfig.setBounds(173, 11, 104, 23);
		panel.add(btnSqlConfig);
		
		
                emp = new EmployeeDAOJDBCTemplateImpl();
                File f = new File("server-config.properties");
 
	  if(f.exists()){
		  System.out.println("File existed");
	  }else{
              emp.Create();
		  System.out.println("File not found!");
	  }
          
          
          
            try {
                emp.Load();
            } catch (ConfigurationException ex) {
               
            }
                

	}

	/**
	 * Prints log statements for testing in a thread
	 */
	private void printLog() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
 
				ApplicationContext context = new ClassPathXmlApplicationContext(
						"spring-config-server.xml");
				GreetingService greetingService = (GreetingService) context
						.getBean("greetingService");
				greetingService.onstatus();
				greetingService.offstatus();
				greetingService.onstatus2();
				greetingService.offstatus2();
                            
				System.out.println("Waiting for Request from Client ...");

			}
		});
		thread.start();
	}
}

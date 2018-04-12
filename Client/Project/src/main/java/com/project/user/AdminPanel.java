package com.project.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hexidec.ekit.Ekit;
import com.project.admin.AddUser;
import com.project.admin.Calendar;
import com.project.admin.ChangeNames;
import com.project.admin.Template;
import com.project.client.GreetingService;
import com.project.ui.Logo;
import com.project.ui.LookAndFeel;
import com.project.ui.MyJButton;
import com.project.ui.MyJDesktopPane;
import com.project.ui.MyJFrame;
import com.project.ui.MyJInternalFrame;
import com.project.ui.MyJLabel;
import com.project.ui.MyJPanel;

public class AdminPanel {

	private Logo logo;

	private MyJFrame frame;

	private MyJPanel mainpanel;
	private MyJPanel panel1;
	private MyJPanel panel3;
	private MyJPanel panel5;
	private MyJPanel panel6;
	private JPanel panel7;

	private MyJDesktopPane desktopPane;

	private MyJInternalFrame inCalendar;
	private MyJInternalFrame inMonitor;

	private LookAndFeel lookandfeel;

	private MyJButton btnChangeNS;
	private MyJButton btnTemplate;
	private MyJButton btnRegister;
	private MyJButton btnMessage;

	private MyJPanel panel2;

	private Template template;

	private ChangeNames changename;

	private JTextField txRss;

	private AddUser adduser;

	private Timer timer;

	private Ekit htmleditor;

	private Calendar calendar;

	private MyJLabel lblChangeTemplate;
	private MyJLabel lblChangeNames;
	private MyJLabel lblAddUser;
	private MyJLabel lblMessage;
	private MyJLabel lblStatus;
	private MyJLabel lblGroups;

	private JButton btnRss;

	

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"application_context.xml");
	GreetingService greetingService = (GreetingService) ctx
			.getBean("greetingService");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminPanel() {
		initialize();
	}

	private void initialize() {
		lookandfeel = new LookAndFeel();

		calendar = new Calendar();
		calendar.setBounds(0, 0, 310, 285);

		

		frame = new MyJFrame("S&T Messages Admin Panel",
				"/com/project/pic/gear.png", 80, 20, 1100, 720, false);
		timer = new Timer(0, null);

		mainpanel = new MyJPanel(0, 0, 1094, 692, null);
		frame.getContentPane().add(mainpanel);

		panel1 = new MyJPanel(0, 0, 1094, 98, null);
		mainpanel.add(panel1);

		// ///////Logo Start////
		logo = new Logo(-99, 0, 1241, 98, SystemColor.white);
		panel1.add(logo);
		// ///////Logo End////

		// ///Desktop start////
		desktopPane = new MyJDesktopPane(0, 100, 346, 592,
				SystemColor.activeCaption);
		mainpanel.add(desktopPane);

		inCalendar = new MyJInternalFrame("",
				"/com/project/pic/gear.png", 255, 255, 255, 10, 11, 326,
				316, false, true);
		desktopPane.add(inCalendar);

		JPanel panelCalendar = new JPanel();
		panelCalendar.setBounds(0, 0, 310, 286);
		inCalendar.getContentPane().add(panelCalendar);
		panelCalendar.setLayout(null);
		panelCalendar.add(calendar);
		calendar.setLayout(null);
                
                panel5 = new MyJPanel(0, 0, 145, 56, null);
		panel5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,
				null, null), "Status of Server SQL", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		mainpanel.add(panel5);

		final JLabel lblStatusSql = new JLabel("");
		lblStatusSql.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusSql.setFont(new Font("David", Font.BOLD, 20));
		lblStatusSql.setBounds(10, 21, 125, 24);
		ActionListener updater = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (greetingService.checksqlserver())// /////Check if server online (if
												// open admin panel)
					lblStatusSql
							.setText("<html><font color='green'>Online</font></html>");// //true
				else
					lblStatusSql
							.setText("<html><font color='red'>Offline</font></html>");// //false
			}
		};
		timer.setDelay(7000);// ///refresh miliseconds
		timer.addActionListener(updater);
		timer.start();

		panel5.add(lblStatusSql);
                calendar.add(panel5);
                
                

		//
		// panel7 = new JPanel();
		// panel7.setBounds(0, 0, 310, 187);
		// inCalendar.getContentPane().add(panel7);
		// panel7.setLayout(null);
		// panel7.add(calendar);

		inMonitor = new MyJInternalFrame("",
				"/com/project/pic/monitor_16.png", 255, 255, 255, 10, 338, 326,
				243, false, true);
		desktopPane.add(inMonitor);

		panel6 = new MyJPanel(0, 0, 310, 213, null);
		inMonitor.getContentPane().add(panel6);

		
		// /////Desktop End/////

		// ////Admin Settings Start/////
		panel2 = new MyJPanel(356, 109, 728, 385, null);
		panel2.setLocation(356, 100);
		panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,
				null, null), "Settings Panel", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainpanel.add(panel2);

		btnTemplate = new MyJButton("", "/com/project/pic/monitor_64.png",
				Color.WHITE, 20, 25, 69, 72);
		btnTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				template = new Template();
				template.setVisible(true);

			}
		});

		panel2.add(btnTemplate);

		lblChangeTemplate = new MyJLabel("Change Template", 10, 106, 95, 14,
				"David", Font.BOLD, 12);
		panel2.add(lblChangeTemplate);

		btnChangeNS = new MyJButton("", "/com/project/pic/bubble_64.png",
				Color.white, 152, 25, 69, 72);
		panel2.add(btnChangeNS);
		btnChangeNS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				changename = new ChangeNames();
				changename.setVisible(true);
			}
		});

		lblChangeNames = new MyJLabel(
				"<html><center>Change names <br>of frames</center></html>",
				143, 100, 78, 41, "David", Font.BOLD, 12);
		panel2.add(lblChangeNames);

		btnRegister = new MyJButton("", "/com/project/pic/user_64.png",
				Color.WHITE, 281, 25, 69, 72);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					adduser = new AddUser();
				} catch (SQLException e) {

					e.printStackTrace();
				}

				adduser.setVisible(true);
			}
		});
		panel2.add(btnRegister);

		lblAddUser = new MyJLabel("Add User", 291, 106, 59, 14, "David",
				Font.BOLD, 12);
		panel2.add(lblAddUser);

		btnMessage = new MyJButton("", "/com/project/pic/pencil_64.png",
				Color.WHITE, 20, 153, 69, 72);
		btnMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				htmleditor = new Ekit();
				htmleditor.setVisible(true);
				htmleditor.setResizable(false);
				htmleditor.setBounds(300, 50, 500, 600);

			}
		});

		panel2.add(btnMessage);

		lblMessage = new MyJLabel("Add Message", 20, 236, 78, 14, "David",
				Font.BOLD, 12);
		panel2.add(lblMessage);

		panel3 = new MyJPanel(356, 572, 728, 109, null);
		panel3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,
				null, null), "RSS Feed", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		mainpanel.add(panel3);

		txRss = new JTextField(greetingService.selrss());

		txRss.setBounds(10, 47, 518, 26);
		panel3.add(txRss);
		txRss.setColumns(10);

		btnRss = new JButton("Send");
		btnRss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				greetingService.updaterss(txRss.getText());

			}
		});
		btnRss.setBounds(550, 42, 89, 37);
		panel3.add(btnRss);

		
		// ////Admin Settings End/////

		inMonitor.setVisible(true);
		inCalendar.setVisible(true);

		// ///Set ip start///
		InetAddress ip = null;
		try {

			ip = InetAddress.getLocalHost();

		} catch (UnknownHostException e) {

			e.printStackTrace();

		}

		greetingService.sendip(ip.getHostAddress());

		// ///Set ip end///

		// // window closed send ip start////
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				InetAddress ip = null;
				try {

					ip = InetAddress.getLocalHost();

				} catch (UnknownHostException e) {

					e.printStackTrace();

				}

				greetingService.disc(ip.getHostAddress());

			}
		});

		// // window closed send ip end////

	}

	public MyJFrame getFrame() {
		return frame;
	}

	public void setFrame(MyJFrame frame) {
		this.frame = frame;
	}
}

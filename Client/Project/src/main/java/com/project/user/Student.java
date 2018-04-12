package com.project.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.AbstractBorder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.client.GreetingService;
import com.project.rss.RssFeed;
import com.project.ui.Logo;
import com.project.ui.LookAndFeel;
import com.project.ui.MyJDesktopPane;
import com.project.ui.MyJFrame;
import com.project.ui.MyJInternalFrame;
import com.project.ui.MyJPanel;

public class Student extends AbstractBorder {

	private MyJFrame frame;

	private MyJPanel mainpanel;
	private MyJPanel logoPanel;
	private MyJPanel panel;
	private MyJPanel panelRss;

	private Logo logo;

	private MyJDesktopPane desktopPane;

	private MyJInternalFrame inGrades;
	private MyJInternalFrame inMessage;
	private MyJInternalFrame inVacation;
	private MyJInternalFrame inHolydays;
	private MyJInternalFrame inRssnews;

	private JLabel centerLabel;
	private JLabel leftLabel;
	private JLabel rightLabelFirst;
	private JLabel rightLabelSecond;

	private LookAndFeel lookandfeel;

	private RssFeed rss;

	private Timer timer;

	private String[] arr;

	// private static Logins login;
	//

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"application_context.xml");
	GreetingService greetingService = (GreetingService) ctx
			.getBean("greetingService");

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Student() {
		initialize();

	}

	static GraphicsDevice device = GraphicsEnvironment
			.getLocalGraphicsEnvironment().getScreenDevices()[0];

	private void initialize() {

		lookandfeel = new LookAndFeel();
		frame = new MyJFrame("S&T Messages", "/com/project/pic/mes.png", 0, 0,
				1370, 768, true);
		Rectangle rect = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getMaximumWindowBounds();

		frame.setPreferredSize(new Dimension(rect.width, rect.height));
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.CTRL_MASK)
						&& (e.getKeyCode() == KeyEvent.VK_X)) {
					device.setFullScreenWindow(frame);
				}

			}
		});

		frame.setExtendedState(MyJFrame.MAXIMIZED_BOTH);
		frame.repaint();
		mainpanel = new MyJPanel(0, 0, 1370, 739, null);
		frame.getContentPane().add(mainpanel);

		rss = new RssFeed();
		rss.setBackground(new Color(255, 255, 255));
		rss.setBounds(10, 11, 933, 46);

		timer = new Timer(0, null);
		// login = new Logins();

		logoPanel = new MyJPanel(0, 0, 1370, 98, null);
		mainpanel.add(logoPanel);

		// ////Logo Start//////
		logo = new Logo(0, 0, 1370, 98, SystemColor.window);
		logoPanel.add(logo);
		// ////Logo End//////

		// ///Desktop Start////
		desktopPane = new MyJDesktopPane(0, 99, 1370, 605,
				SystemColor.activeCaption);
		mainpanel.add(desktopPane);

		inGrades = new MyJInternalFrame(greetingService.SelStudentName(1),
				"/com/project/pic/mes.png", 255, 255, 255, 10, 11, 283, 466,
				true, true);
		inGrades.setResizable(false);

		desktopPane.add(inGrades);

		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255, 255, 255));
		leftPanel.setBounds(0, 0, 267, 436);
		inGrades.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);

		leftLabel = new JLabel("");
		leftLabel.setBackground(new Color(255, 255, 255));
		leftLabel.setBounds(10, 11, 247, 414);
		leftPanel.add(leftLabel);

		arr = greetingService.getshtml(greetingService.SelStudentName(1))
				.toArray(
						new String[greetingService.getshtml(
								greetingService.SelStudentName(1)).size()]);

		ActionListener updater = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!greetingService
						.getshtml(greetingService.SelStudentName(1)).isEmpty()) {

					leftLabel.setText(arr[i]);
					System.out.println(arr[i]);
					i++;
					if (i >= arr.length) { // loop

						i = 0;
					}

				} else
					leftLabel
							.setText("<html><center><h2>No Messages</h2></center></html>");
			}

			private int i = 0;// /// loop

		};
		timer.setDelay(7000);// ///refresh miliseconds
		timer.addActionListener(updater);
		timer.start();

		inMessage = new MyJInternalFrame(greetingService.SelStudentName(2),
				"/com/project/pic/mes.png", 255, 255, 255, 303, 11, 745, 466,
				true, true);
		inMessage.setResizable(false);

		// panel = new MyJPanel(0, 0, 650, 500, null);

		desktopPane.add(inMessage);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 255, 255));
		centerPanel.setBounds(0, 0, 729, 436);
		inMessage.getContentPane().add(centerPanel);
		centerPanel.setLayout(null);

		centerLabel = new JLabel("");
		centerLabel.setBackground(new Color(255, 255, 255));
		centerLabel.setBounds(10, 11, 709, 401);
		centerPanel.add(centerLabel);

		final String[] arr2 = greetingService.getshtml(
				greetingService.SelStudentName(2)).toArray(
				new String[greetingService.getshtml(
						greetingService.SelStudentName(2)).size()]);

		ActionListener updater2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!greetingService
						.getshtml(greetingService.SelStudentName(2)).isEmpty()) {
					centerLabel.setText(arr2[i]);
					i++;
					if (i >= arr2.length) { // loop

						i = 0;
					}

				} else
					centerLabel
							.setText("<html><center><h2>No Messages</h2></center></html>");
			}

			private int i = 0;// /// loop

		};
		timer.setDelay(7000);// ///refresh miliseconds
		timer.addActionListener(updater2);
		timer.start();

		inVacation = new MyJInternalFrame(greetingService.SelStudentName(3),
				"/com/project/pic/mes.png", 255, 255, 255, 1058, 11, 290, 276,
				true, true);
		inVacation.setResizable(false);

		desktopPane.add(inVacation);

		JPanel rightPanelFirst = new JPanel();
		rightPanelFirst.setBackground(new Color(255, 255, 255));
		rightPanelFirst.setBounds(0, 0, 274, 246);
		inVacation.getContentPane().add(rightPanelFirst);
		rightPanelFirst.setLayout(null);

		rightLabelFirst = new JLabel("");
		rightLabelFirst.setBackground(new Color(255, 255, 255));
		rightLabelFirst.setBounds(10, 11, 254, 224);
		rightPanelFirst.add(rightLabelFirst);

		final String[] arr3 = greetingService.getshtml(
				greetingService.SelStudentName(3)).toArray(
				new String[greetingService.getshtml(
						greetingService.SelStudentName(3)).size()]);

		ActionListener updater3 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!greetingService
						.getshtml(greetingService.SelStudentName(3)).isEmpty()) {
					rightLabelFirst.setText(arr3[i]);
					i++;
					if (i >= arr3.length) { // loop

						i = 0;
					}

				} else
					rightLabelFirst
							.setText("<html><center><h2>No Messages</h2></center></html>");
			}

			private int i = 0;// /// loop

		};
		timer.setDelay(7000);// ///refresh miliseconds
		timer.addActionListener(updater3);
		timer.start();

		inHolydays = new MyJInternalFrame(greetingService.SelStudentName(4),
				"/com/project/pic/mes.png", 255, 255, 255, 1058, 298, 290, 296,
				true, true);
		inHolydays.setResizable(false);

		desktopPane.add(inHolydays);

		JPanel rightPanelSecond = new JPanel();
		rightPanelSecond.setBackground(new Color(255, 255, 255));
		rightPanelSecond.setBounds(0, 0, 274, 266);
		inHolydays.getContentPane().add(rightPanelSecond);
		rightPanelSecond.setLayout(null);

		rightLabelSecond = new JLabel("");
		rightLabelSecond.setBackground(new Color(255, 255, 255));
		rightLabelSecond.setBounds(10, 11, 254, 244);
		rightPanelSecond.add(rightLabelSecond);

		final String[] arr4 = greetingService.getshtml(
				greetingService.SelStudentName(4)).toArray(
				new String[greetingService.getshtml(
						greetingService.SelStudentName(4)).size()]);

		ActionListener updater4 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!greetingService
						.getshtml(greetingService.SelStudentName(4)).isEmpty()) {
					rightLabelSecond.setText(arr4[i]);
					i++;
					if (i >= arr4.length) { // loop

						i = 0;
					}

				} else
					rightLabelSecond
							.setText("<html><center><h2>No Messages</h2></center></html>");
			}

			private int i = 0;// /// loop

		};
		timer.setDelay(7000);// ///refresh miliseconds
		timer.addActionListener(updater4);
		timer.start();

		inRssnews = new MyJInternalFrame(greetingService.SelStudentName(5),
				"/com/project/pic/mes.png", 255, 255, 255, 10, 488, 1038, 78,
				false, true);

		panelRss = new MyJPanel(0, 0, 943, 95, SystemColor.WHITE);
		inRssnews.getContentPane().add(panelRss);
		panelRss.add(rss);

		desktopPane.add(inRssnews);

		// ///Desktop End////

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

package com.project.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Teacher extends AbstractBorder {

	private MyJFrame frame;

	private MyJPanel mainpanel;
	private MyJPanel logoPanel;
	private MyJPanel panelRss;

	private Logo logo;

	private MyJDesktopPane desktopPane;

	private MyJInternalFrame inMesTea;
	private MyJInternalFrame inMessage;
	private MyJInternalFrame inAdv;
	private MyJInternalFrame inExam;
	private MyJInternalFrame inRssnews;

	private LookAndFeel lookandfeel;

	private RssFeed rss;

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"application_context.xml");
	GreetingService greetingService = (GreetingService) ctx
			.getBean("greetingService");
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel rightPanelFirst;
	private JPanel rightPanelSecond;
	private JLabel leftLabel;
	private JLabel centerLabel;
	private JLabel rightLabelFirst;
	private JLabel rightLebelSecond;

	private Timer timer;

	// private Logins login;
	// private FirstPanelStudent fpstudent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher window = new Teacher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Teacher() {
		initialize();
	}

	private void initialize() {
		lookandfeel = new LookAndFeel();

		frame = new MyJFrame("S&T Messages", "/com/project/pic/mes.png", 0, 0,
				1370, 768, true);
		frame.setExtendedState(MyJFrame.MAXIMIZED_BOTH);

		mainpanel = new MyJPanel(0, 0, 1370, 739, null);
		frame.getContentPane().add(mainpanel);

		rss = new RssFeed();
		rss.setBackground(new Color(255, 255, 255));
		rss.setBounds(10, 11, 933, 46);

		timer = new Timer(0, null);
		// login = new Logins();
		// fpstudent = new FirstPanelStudent();

		logoPanel = new MyJPanel(0, 0, 1370, 98, null);
		mainpanel.add(logoPanel);

		// ////Logo Start//////
		logo = new Logo(0, 0, 1370, 98, SystemColor.window);
		logo.setLocation(0, 0);
		logoPanel.add(logo);
		// ////Logo End//////

		// ///Desktop Start////
		desktopPane = new MyJDesktopPane(0, 99, 1370, 605,
				SystemColor.activeCaption);
		mainpanel.add(desktopPane);

		inMesTea = new MyJInternalFrame(greetingService.SelTeacherName(1),
				"/com/project/pic/mes.png", 255, 255, 255, 10, 11, 283, 466,
				true, true);

		desktopPane.add(inMesTea);

		leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255, 255, 255));
		leftPanel.setBounds(0, 0, 267, 436);
		inMesTea.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);

		leftLabel = new JLabel("");
		leftLabel.setBounds(10, 11, 247, 414);
		leftPanel.add(leftLabel);

		final String[] arr = greetingService.getthtml(
				greetingService.SelTeacherName(1)).toArray(
				new String[greetingService.getthtml(
						greetingService.SelTeacherName(1)).size()]);

		ActionListener updater = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!greetingService
						.getthtml(greetingService.SelTeacherName(1)).isEmpty()) {
					leftLabel.setText(arr[i]);
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

		inMessage = new MyJInternalFrame(greetingService.SelTeacherName(2),
				"/com/project/pic/mes.png", 255, 255, 255, 303, 11, 745, 466,
				true, true);

		desktopPane.add(inMessage);

		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 255, 255));
		centerPanel.setBounds(0, 0, 729, 436);
		inMessage.getContentPane().add(centerPanel);
		centerPanel.setLayout(null);

		centerLabel = new JLabel("");
		centerLabel.setBounds(10, 11, 709, 414);
		centerPanel.add(centerLabel);

		final String[] arr2 = greetingService.getthtml(
				greetingService.SelTeacherName(2)).toArray(
				new String[greetingService.getthtml(
						greetingService.SelTeacherName(2)).size()]);

		ActionListener updater2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!greetingService
						.getthtml(greetingService.SelTeacherName(2)).isEmpty()) {
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

		inAdv = new MyJInternalFrame(greetingService.SelTeacherName(3),
				"/com/project/pic/mes.png", 255, 255, 255, 1058, 11, 290, 276,
				true, true);

		desktopPane.add(inAdv);

		rightPanelFirst = new JPanel();
		rightPanelFirst.setBackground(new Color(255, 255, 255));
		rightPanelFirst.setBounds(0, 0, 274, 246);
		inAdv.getContentPane().add(rightPanelFirst);
		rightPanelFirst.setLayout(null);

		rightLabelFirst = new JLabel("");
		rightLabelFirst.setBounds(10, 11, 254, 224);
		rightPanelFirst.add(rightLabelFirst);

		final String[] arr3 = greetingService.getthtml(
				greetingService.SelTeacherName(3)).toArray(
				new String[greetingService.getthtml(
						greetingService.SelTeacherName(3)).size()]);

		ActionListener updater3 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!greetingService
						.getthtml(greetingService.SelTeacherName(3)).isEmpty()) {
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

		inExam = new MyJInternalFrame(greetingService.SelTeacherName(4),
				"/com/project/pic/mes.png", 255, 255, 255, 1058, 298, 290, 296,
				true, true);

		desktopPane.add(inExam);

		rightPanelSecond = new JPanel();
		rightPanelSecond.setBackground(new Color(255, 255, 255));
		rightPanelSecond.setBounds(0, 0, 274, 266);
		inExam.getContentPane().add(rightPanelSecond);
		rightPanelSecond.setLayout(null);

		rightLebelSecond = new JLabel("");
		rightLebelSecond.setBounds(10, 11, 254, 244);
		rightPanelSecond.add(rightLebelSecond);

		final String[] arr4 = greetingService.getthtml(
				greetingService.SelTeacherName(4)).toArray(
				new String[greetingService.getthtml(
						greetingService.SelTeacherName(4)).size()]);

		ActionListener updater4 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!greetingService
						.getthtml(greetingService.SelTeacherName(4)).isEmpty()) {
					rightLebelSecond.setText(arr4[i]);
					i++;
					if (i >= arr4.length) { // loop

						i = 0;
					}

				} else
					rightLebelSecond
							.setText("<html><center><h2>No Messages</h2></center></html>");
			}

			private int i = 0;// /// loop

		};
		timer.setDelay(7000);// ///refresh miliseconds
		timer.addActionListener(updater4);
		timer.start();

		inRssnews = new MyJInternalFrame(greetingService.SelTeacherName(5),
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

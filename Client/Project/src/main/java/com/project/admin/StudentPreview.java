package com.project.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

public class StudentPreview extends AbstractBorder {

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
	private String scenterLabel;
	private JLabel leftLabel;
	private JLabel rightLabelFirst;
	private JLabel rightLabelSecond;

	private LookAndFeel lookandfeel;

	private RssFeed rss;

	private Timer timer;

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
					StudentPreview window = new StudentPreview();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentPreview() {
		initialize();
	}

	static GraphicsDevice device = GraphicsEnvironment
			.getLocalGraphicsEnvironment().getScreenDevices()[0];

	private void initialize() {

		lookandfeel = new LookAndFeel();
		frame = new MyJFrame("S&T Messages", "/com/project/pic/mes.png", 0, 0,
				1370, 768, true);
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

		// scenterLabel = new String();
		centerLabel = new JLabel(scenterLabel);
		centerLabel.setBackground(new Color(255, 255, 255));
		centerLabel.setBounds(10, 11, 709, 401);
		centerPanel.add(centerLabel);

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

		inRssnews = new MyJInternalFrame(greetingService.SelStudentName(5),
				"/com/project/pic/mes.png", 255, 255, 255, 10, 488, 1038, 78,
				false, true);

		panelRss = new MyJPanel(0, 0, 943, 95, SystemColor.WHITE);
		inRssnews.getContentPane().add(panelRss);
		panelRss.add(rss);

		desktopPane.add(inRssnews);

		// ///Desktop End////

	}

	public String getScenterLabel() {
		return scenterLabel;
	}

	public void setScenterLabel(String scenterLabel) {
		this.scenterLabel = scenterLabel;
	}

	public JLabel getCenterLabel() {
		return centerLabel;
	}

	public void setCenterLabel(JLabel centerLabel) {
		this.centerLabel = centerLabel;
	}

	public JLabel getLeftLabel() {
		return leftLabel;
	}

	public void setLeftLabel(JLabel leftLabel) {
		this.leftLabel = leftLabel;
	}

	public JLabel getRightLabelFirst() {
		return rightLabelFirst;
	}

	public void setRightLabelFirst(JLabel rightLabelFirst) {
		this.rightLabelFirst = rightLabelFirst;
	}

	public JLabel getRightLabelSecond() {
		return rightLabelSecond;
	}

	public void setRightLabelSecond(JLabel rightLabelSecond) {
		this.rightLabelSecond = rightLabelSecond;
	}

	public MyJFrame getFrame() {
		return frame;
	}

	public void setFrame(MyJFrame frame) {
		this.frame = frame;
	}
}

package com.project.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.client.GreetingService;
import com.project.methods.Hashcode;
import com.project.ui.Logo;
import com.project.ui.LookAndFeel;
import com.project.ui.MyJDesktopPane;
import com.project.ui.MyJFrame;
import com.project.ui.MyJInternalFrame;
import com.project.ui.MyJLabel;
import com.project.ui.MyJPanel;
import com.project.ui.MyJPasswordField;
import javax.swing.JFrame;

public class Login {

	private MyJFrame frame;

	private MyJPanel mainpanel;
	private MyJPanel panel_1;

	private Logo logo;

	private Students student;
	private Teachers teacher;
	private AdminPanel admin;

	private Hashcode hashcode;

	private MyJDesktopPane desktopPane;

	private MyJInternalFrame inLogin;

	private MyJLabel lblUsename;
	private MyJLabel lblPassword;

	private JTextField textUser;

	private MyJPasswordField password;

	private JButton btnEnter;

	private LookAndFeel lookandfeel;

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"application_context.xml");
	GreetingService greetingService = (GreetingService) ctx
			.getBean("greetingService");

	// private Logins login;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new MyJFrame("S&T Messages", "/com/project/pic/mes.png", 120,
				50, 1000, 600, false);
		lookandfeel = new LookAndFeel();

		hashcode = new Hashcode();

		// login = new Logins();

		mainpanel = new MyJPanel(0, 0, 994, 572, SystemColor.activeCaption);
		frame.getContentPane().add(mainpanel);

		panel_1 = new MyJPanel(0, 0, 1279, 98, null);
		mainpanel.add(panel_1);

		// ////Logo Start/////
		logo = new Logo(-157, 0, 1153, 98, SystemColor.window);
		panel_1.add(logo);
		// ////Logo End/////

		// ////Desktop Start/////
		desktopPane = new MyJDesktopPane(986, 567, -981, -469, null);
		mainpanel.add(desktopPane);

		inLogin = new MyJInternalFrame("Log in to the Panel",
				"/com/project/pic/user.png", 240, 248, 255, 328, 154, 359, 273,
				false, false);
		inLogin.setBounds(328, 154, 359, 210);

		lblUsename = new MyJLabel("Username:", 54, 59, 87, 14, "David",
				Font.ITALIC, 18);
		inLogin.getContentPane().add(lblUsename);

		lblPassword = new MyJLabel("Password:", 54, 96, 87, 14, "David",
				Font.ITALIC, 18);
		inLogin.getContentPane().add(lblPassword);

		textUser = new JTextField();
		textUser.setBounds(151, 57, 122, 20);
		inLogin.getContentPane().add(textUser);
		textUser.setColumns(10);

		password = new MyJPasswordField(null, 151, 94, 122, 20, 10);
		inLogin.getContentPane().add(password);

		btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("David", Font.ITALIC, 16));
		btnEnter.setBounds(135, 140, 89, 23);

		btnEnter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				char ps[] = password.getPassword();
				String pa = new String(ps);

				try {

					String user = new String(textUser.getText());
					String password = new String(hashcode.hashcode(pa));
					System.out.println(user);
					System.out.println(password);

					if (greetingService.login(user, password) == 0) {
						// login.setName(textUser.getText());
						frame.setVisible(false);
						student = new Students();

						student.getFrame().setVisible(true);

					} else if (greetingService.login(user, password) == 1) {
						// login.setName(textUser.getText());
						frame.setVisible(false);
						teacher = new Teachers();

						teacher.getFrame().setVisible(true);
					} else if (greetingService.login(user, password) == 2) {
						// login.setName(textUser.getText());
						frame.setVisible(false);
						admin = new AdminPanel();
						admin.getFrame().setVisible(true);

					} else
						JOptionPane.showMessageDialog(null,
								"Wrong Username or Password", "Error",
								JOptionPane.ERROR_MESSAGE);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		inLogin.getContentPane().add(btnEnter);
		mainpanel.add(inLogin);
		// ////Desktop End/////

	}
        
        public MyJFrame getFrame() {
		return frame;
	}

	public void setFrame(MyJFrame frame) {
		this.frame = frame;
	}
}

package com.project.admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.client.GreetingService;
import com.project.methods.CheckPassUserToAdd;
import com.project.methods.Hashcode;

@SuppressWarnings("serial")
public class AddUser extends JDialog {

	private final JPanel mainPanel = new JPanel();

	private String[] users = { "Student", "Teacher" };

	private JTextField txUsername;

	private CheckPassUserToAdd checkpass;
	private Hashcode hashcode;

	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	private JLabel lblRepassword;
	private JLabel lblUsername;
	private JLabel lblPassword;

	private JPasswordField txPassword;
	private JPasswordField txRepassword;

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"application_context.xml");
	GreetingService greetingService = (GreetingService) ctx
			.getBean("greetingService");

	public static void main(String[] args) {
		try {
			AddUser dialog = new AddUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AddUser() throws SQLException {
		setTitle("Add User");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/com/project/pic/user_16.png")));
		setBounds(300, 100, 405, 274);
		getContentPane().setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);

		checkpass = new CheckPassUserToAdd();
		hashcode = new Hashcode();

		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("David", Font.BOLD | Font.ITALIC, 18));
		lblUsername.setBounds(20, 24, 98, 14);
		mainPanel.add(lblUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("David", Font.BOLD | Font.ITALIC, 18));
		lblPassword.setBounds(20, 61, 87, 14);
		mainPanel.add(lblPassword);

		txUsername = new JTextField();
		txUsername.setBounds(128, 19, 162, 26);
		mainPanel.add(txUsername);
		txUsername.setColumns(10);

		comboBox = new JComboBox(users);
		comboBox.setBounds(128, 130, 162, 20);
		comboBox.setSelectedItem(null);

		mainPanel.add(comboBox);

		lblRepassword = new JLabel("RePassword:");
		lblRepassword.setFont(new Font("David", Font.BOLD | Font.ITALIC, 18));
		lblRepassword.setBounds(20, 98, 109, 14);
		mainPanel.add(lblRepassword);

		txPassword = new JPasswordField();
		txPassword.setBounds(128, 56, 162, 26);
		mainPanel.add(txPassword);

		txRepassword = new JPasswordField();
		txRepassword.setBounds(128, 93, 162, 26);
		mainPanel.add(txRepassword);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean flag1 = false, flag2 = false, flag3 = false;
				char pass[] = txPassword.getPassword();
				char repass[] = txRepassword.getPassword();
				String pass2 = new String(pass);
				String repass2 = new String(repass);

				try {
					if (greetingService.searchuser(txUsername.getText())
							&& txUsername.getText().length() >= 5) { // ////Proverka
																		// Usera
																		// i
																		// dlinu
																		// ego
						flag1 = true;
					} else {
						JOptionPane.showMessageDialog(null,
								"User is already exists or small", " Warning",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (HeadlessException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				if (!((pass2.length() >= 6) && (checkpass.pass(pass2, repass2)))) { // //Proverka
																					// porolya
																					// i
																					// dlinu
																					// ego
					JOptionPane
							.showMessageDialog(
									null,
									"Password to small or Password and Reassword is does not correct",
									" Warning", JOptionPane.WARNING_MESSAGE);

				} else {
					flag2 = true;

				}

				if (comboBox.getSelectedItem() == null) { // ////Proverka esli
															// vibrana gruppa
					JOptionPane.showMessageDialog(null, "Choose the group",
							" Warning", JOptionPane.WARNING_MESSAGE);
				} else
					flag3 = true;

				if (flag1 && flag2 && flag3) { // // Proverka esli vse
												// prededushie proverki vse
												// verni (true)

					String user = new String(txUsername.getText());
					String password = null;
					try {
						password = new String(hashcode.hashcode(pass2));
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int id = comboBox.getSelectedIndex();
					greetingService.adduser(user, password, id);
					JOptionPane.showMessageDialog(null, "The user '" + user
							+ "' is added.", " Success",
							JOptionPane.WARNING_MESSAGE);
					dispose();

				}
			}
		});
		btnAdd.setBounds(165, 180, 89, 26);
		mainPanel.add(btnAdd);

	}
}

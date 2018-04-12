package com.project.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.client.GreetingService;

public class ChangeNames extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfFirst;
	private JTextField tfSecond;
	private JTextField tfThree;
	private JTextField tfFour;
	private JTextField tfFive;

	private JLabel lblFirst;
	private JLabel lblSecond;
	private JLabel lblThird;
	private JLabel lblFourth;
	private JLabel lblFifth;

	private JPanel panel1;
	private JPanel panel2;

	private JTextField txFirstT;
	private JTextField txSecondT;
	private JTextField txThirdT;
	private JTextField txFourthT;
	private JTextField txFifthT;

	private JLabel lblFirstT;
	private JLabel lblSecondT;
	private JLabel lblThirdT;
	private JLabel lblFourthT;
	private JLabel lblFifthT;

	private JButton btnSend1T;
	private JButton btnSend2T;
	private JButton btnSend3T;
	private JButton btnSend4T;
	private JButton btnSend5T;

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application_context.xml");
	GreetingService greetingService = (GreetingService) ctx.getBean("greetingService");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChangeNames dialog = new ChangeNames();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangeNames() {
		setTitle("Change names of frames");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChangeNames.class.getResource("/com/project/pic/pencil_16.png")));
		setBounds(100, 100, 730, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// /////Student Panel Start/////////
		panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Student Window", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(10, 11, 339, 312);
		contentPanel.add(panel1);
		panel1.setLayout(null);

		tfFirst = new JTextField(greetingService.SelStudentName(1));

		tfFirst.setBounds(104, 26, 140, 26);
		panel1.add(tfFirst);
		tfFirst.setColumns(10);

		tfSecond = new JTextField(greetingService.SelStudentName(2));

		tfSecond.setColumns(10);
		tfSecond.setBounds(104, 82, 140, 26);
		panel1.add(tfSecond);

		tfThree = new JTextField(greetingService.SelStudentName(3));

		tfThree.setColumns(10);
		tfThree.setBounds(104, 135, 140, 26);
		panel1.add(tfThree);

		tfFour = new JTextField(greetingService.SelStudentName(4));

		tfFour.setColumns(10);
		tfFour.setBounds(104, 192, 140, 26);
		panel1.add(tfFour);

		tfFive = new JTextField(greetingService.SelStudentName(5));

		tfFive.setColumns(10);
		tfFive.setBounds(104, 249, 140, 26);
		panel1.add(tfFive);

		lblFirst = new JLabel("First Window");
		lblFirst.setFont(new Font("David", Font.BOLD, 12));
		lblFirst.setBounds(10, 12, 75, 50);
		panel1.add(lblFirst);

		lblSecond = new JLabel("Second Window");
		lblSecond.setFont(new Font("David", Font.BOLD, 12));
		lblSecond.setBounds(10, 68, 93, 50);
		panel1.add(lblSecond);

		lblThird = new JLabel("Third Window");
		lblThird.setFont(new Font("David", Font.BOLD, 12));
		lblThird.setBounds(10, 122, 93, 50);
		panel1.add(lblThird);

		lblFourth = new JLabel("Fourth Window");
		lblFourth.setFont(new Font("David", Font.BOLD, 12));
		lblFourth.setBounds(10, 178, 93, 50);
		panel1.add(lblFourth);

		lblFifth = new JLabel("Fifth Window");
		lblFifth.setFont(new Font("David", Font.BOLD, 12));
		lblFifth.setBounds(10, 234, 93, 50);
		panel1.add(lblFifth);

		JButton btnSend1 = new JButton("Send");
		btnSend1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = new String(tfFirst.getText());
				int id = 1;
				greetingService.UpdNameStudent(name,id);

			}
		});
		btnSend1.setBounds(254, 20, 76, 33);
		panel1.add(btnSend1);

		JButton btnSend2 = new JButton("Send");
		btnSend2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = new String(tfSecond.getText());
				int id = 2;
				greetingService.UpdNameStudent(name,id);

			}
		});
		btnSend2.setBounds(254, 76, 76, 33);
		panel1.add(btnSend2);

		JButton btnSend3 = new JButton("Send");
		btnSend3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = new String(tfThree.getText());
				int id = 3;
				greetingService.UpdNameStudent(name,id);
			}
		});
		btnSend3.setBounds(254, 129, 76, 33);
		panel1.add(btnSend3);

		JButton btnSend4 = new JButton("Send");
		btnSend4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = new String(tfFour.getText());
				int id = 4;
				greetingService.UpdNameStudent(name,id);
			}
		});
		btnSend4.setBounds(254, 186, 76, 33);
		panel1.add(btnSend4);

		JButton btnSend5 = new JButton("Send");
		btnSend5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = new String(tfFive.getText());
				int id = 5;
				greetingService.UpdNameStudent(name,id);
			}
		});
		btnSend5.setBounds(254, 243, 76, 33);
		panel1.add(btnSend5);
		// ///////Student Panel End///////

		// ////////Teacher Panel Start//////////
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Teacher Window", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel2.setBounds(359, 11, 339, 312);
		contentPanel.add(panel2);

		txFirstT = new JTextField(greetingService.SelTeacherName(1));

		txFirstT.setColumns(10);
		txFirstT.setBounds(104, 26, 140, 26);
		panel2.add(txFirstT);

		txSecondT = new JTextField(greetingService.SelTeacherName(2));

		txSecondT.setColumns(10);
		txSecondT.setBounds(104, 82, 140, 26);
		panel2.add(txSecondT);

		txThirdT = new JTextField(greetingService.SelTeacherName(3));

		txThirdT.setColumns(10);
		txThirdT.setBounds(104, 135, 140, 26);
		panel2.add(txThirdT);

		txFourthT = new JTextField(greetingService.SelTeacherName(4));

		txFourthT.setColumns(10);
		txFourthT.setBounds(104, 192, 140, 26);
		panel2.add(txFourthT);

		txFifthT = new JTextField(greetingService.SelTeacherName(5));

		txFifthT.setColumns(10);
		txFifthT.setBounds(104, 249, 140, 26);
		panel2.add(txFifthT);

		lblFirstT = new JLabel("First Window");
		lblFirstT.setFont(new Font("David", Font.BOLD, 12));
		lblFirstT.setBounds(10, 12, 75, 50);
		panel2.add(lblFirstT);

		lblSecondT = new JLabel("Second Window");
		lblSecondT.setFont(new Font("David", Font.BOLD, 12));
		lblSecondT.setBounds(10, 68, 93, 50);
		panel2.add(lblSecondT);

		lblThirdT = new JLabel("Third Window");
		lblThirdT.setFont(new Font("David", Font.BOLD, 12));
		lblThirdT.setBounds(10, 122, 93, 50);
		panel2.add(lblThirdT);

		lblFourthT = new JLabel("Fourth Window");
		lblFourthT.setFont(new Font("David", Font.BOLD, 12));
		lblFourthT.setBounds(10, 178, 93, 50);
		panel2.add(lblFourthT);

		lblFifthT = new JLabel("Fifth Window");
		lblFifthT.setFont(new Font("David", Font.BOLD, 12));
		lblFifthT.setBounds(10, 234, 93, 50);
		panel2.add(lblFifthT);

		btnSend1T = new JButton("Send");
		btnSend1T.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = new String(txFirstT.getText());
				int id = 1;
				greetingService.UpdNameTeacher(name,id);

			}
		});
		btnSend1T.setBounds(254, 20, 76, 33);
		panel2.add(btnSend1T);

		btnSend2T = new JButton("Send");
		btnSend2T.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = new String(txSecondT.getText());
				int id = 2;
				greetingService.UpdNameTeacher(name,id);
			}
		});
		btnSend2T.setBounds(254, 76, 76, 33);
		panel2.add(btnSend2T);

		btnSend3T = new JButton("Send");
		btnSend3T.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = new String(txThirdT.getText());
				int id = 3;
				greetingService.UpdNameTeacher(name,id);
			}
		});
		btnSend3T.setBounds(254, 129, 76, 33);
		panel2.add(btnSend3T);

		btnSend4T = new JButton("Send");
		btnSend4T.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = new String(txFourthT.getText());
				int id = 4;
				greetingService.UpdNameTeacher(name,id);
			}
		});
		btnSend4T.setBounds(254, 186, 76, 33);
		panel2.add(btnSend4T);

		btnSend5T = new JButton("Send");
		btnSend5T.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = new String(txFifthT.getText());
				int id = 5;
				greetingService.UpdNameTeacher(name,id);
			}
		});
		btnSend5T.setBounds(254, 243, 76, 33);
		panel2.add(btnSend5T);
		// ////////Teacher Panel End//////////
	}
}

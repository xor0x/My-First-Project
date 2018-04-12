package com.project.service;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.configuration.ConfigurationException;

import com.project.sql.EmployeeDAOJDBCTemplateImpl;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDataBase;
	private JTextField txtUser;
	private JTextField txtPassword;
	private EmployeeDAOJDBCTemplateImpl emp;
	private JTextField txtPort;
        private JTextField txtServerPort;
       

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Config dialog = new Config();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @throws ConfigurationException
	 */
	public Config() throws ConfigurationException {
		emp = new EmployeeDAOJDBCTemplateImpl();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtDataBase = new JTextField(emp.Load().getProperty("url"));
			txtDataBase.setBounds(170, 40, 165, 20);
			contentPanel.add(txtDataBase);
			txtDataBase.setColumns(10);
		}

		txtPort = new JTextField(emp.Load().getProperty("port"));
		txtPort.setColumns(10);
		txtPort.setBounds(170, 71, 165, 20);
		contentPanel.add(txtPort);

		txtUser = new JTextField(emp.Load().getProperty("username"));
		txtUser.setBounds(170, 102, 165, 20);
		txtUser.setColumns(10);
		contentPanel.add(txtUser);

		txtPassword = new JTextField(emp.Load().getProperty("password"));
		txtPassword.setBounds(170, 133, 165, 20);
		txtPassword.setColumns(10);
		contentPanel.add(txtPassword);
                
                txtServerPort = new JTextField(emp.Load().getProperty("serverport"));
		txtServerPort.setBounds(170, 167, 165, 20);
		txtServerPort.setColumns(10);
		contentPanel.add(txtServerPort);

		JLabel lblDatabase = new JLabel("Url");
		lblDatabase.setBounds(55, 43, 90, 14);
		lblDatabase.setFont(new Font("David", Font.BOLD, 16));
		contentPanel.add(lblDatabase);

		JLabel lblPort = new JLabel("Sql Port");
		lblPort.setFont(new Font("David", Font.BOLD, 16));
		lblPort.setBounds(55, 74, 90, 14);
		contentPanel.add(lblPort);

		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("David", Font.BOLD, 16));
		lblUser.setBounds(55, 105, 90, 14);
		contentPanel.add(lblUser);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("David", Font.BOLD, 16));
		lblPassword.setBounds(55, 136, 90, 14);
		contentPanel.add(lblPassword);
                
                
                JLabel lblSerport = new JLabel("Server Port");
		lblSerport.setFont(new Font("David", Font.BOLD, 16));
		lblSerport.setBounds(55, 167, 90, 14);
		contentPanel.add(lblSerport);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

                                           
                                                emp.Write(txtDataBase.getText(), txtPort.getText(), txtUser.getText(),txtPassword.getText(),txtServerPort.getText());
                                                
                                                
                                                dispose();
                                            
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

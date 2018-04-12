package com.project.user;

import com.project.methods.PropFile;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ConfigurationException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class IpServer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIp;
	private JTextField txtPort;
        private Login login;
        private PropFile file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IpServer dialog = new IpServer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IpServer() {
           
            file = new PropFile();
             File f = new File("client-config.properties");
 
	  if(f.exists()){
		  System.out.println("File existed");
	  }else{
              file.Create();
		  System.out.println("File not found!");
	  }
		setBounds(100, 100, 323, 174);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblUrl = new JLabel("IP");
		lblUrl.setFont(new Font("David", Font.BOLD, 17));
		lblUrl.setBounds(32, 21, 46, 14);
		contentPanel.add(lblUrl);

		JLabel lblPort = new JLabel("Port");
		lblPort.setFont(new Font("David", Font.BOLD, 17));
		lblPort.setBounds(32, 55, 46, 14);
		contentPanel.add(lblPort);

            try {
                txtIp = new JTextField(file.Load().getProperty("url"));
            } catch (ConfigurationException ex) {
                
            }
		txtIp.setBounds(100, 18, 148, 20);
		contentPanel.add(txtIp);
		txtIp.setColumns(10);

            try {
                txtPort = new JTextField(file.Load().getProperty("port"));
            } catch (ConfigurationException ex) {
                
            }
		txtPort.setBounds(100, 52, 148, 20);
		contentPanel.add(txtPort);
		txtPort.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
                                             login = new Login();
                                            file.Write(txtIp.getText(), txtPort.getText());
                                            login.getFrame().setVisible(true);
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
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

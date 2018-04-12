package com.project.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.client.GreetingService;
import com.project.user.AdminPanel;

public class Template extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton previousButton;
	private static Template dialog;
	private AdminPanel admin;
	private final ButtonGroup bg;
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application_context.xml");
	GreetingService greetingService = (GreetingService) ctx.getBean("greetingService");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new Template();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Template() {
		setTitle("Change Template");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/project/pic/monitor_16.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		bg = new ButtonGroup();
		admin = new AdminPanel();

		// //////Change Template Start/////
		JRadioButton rdbtnJava = new JRadioButton("Java");
		rdbtnJava.setFont(new Font("David", Font.BOLD, 15));
		rdbtnJava.setBounds(29, 7, 65, 23);
		rdbtnJava.addActionListener(new LNFSetter("javax.swing.plaf.metal.MetalLookAndFeel", rdbtnJava));
		rdbtnJava.setActionCommand("javax.swing.plaf.metal.MetalLookAndFeel");
		bg.add(rdbtnJava);
		contentPanel.add(rdbtnJava);

		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setFont(new Font("David", Font.BOLD, 15));
		rdbtnWindows.setBounds(102, 7, 92, 23);
		rdbtnWindows.addActionListener(new LNFSetter("com.sun.java.swing.plaf.windows.WindowsLookAndFeel", rdbtnWindows));
		rdbtnWindows.setActionCommand("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		bg.add(rdbtnWindows);
		contentPanel.add(rdbtnWindows);

		JRadioButton rdbtnMotif = new JRadioButton("Motif");
		rdbtnMotif.setFont(new Font("David", Font.BOLD, 15));
		rdbtnMotif.setBounds(196, 7, 65, 23);
		rdbtnMotif.addActionListener(new LNFSetter("com.sun.java.swing.plaf.motif.MotifLookAndFeel", rdbtnMotif));
		rdbtnMotif.setActionCommand("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		bg.add(rdbtnMotif);
		contentPanel.add(rdbtnMotif);

		JRadioButton rdbtnNimbus = new JRadioButton("Nimbus");
		rdbtnNimbus.setFont(new Font("David", Font.BOLD, 15));
		rdbtnNimbus.setBounds(265, 7, 109, 23);
		rdbtnNimbus.addActionListener(new LNFSetter("javax.swing.plaf.nimbus.NimbusLookAndFeel", rdbtnNimbus));
		rdbtnNimbus.setActionCommand("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		bg.add(rdbtnNimbus);
		contentPanel.add(rdbtnNimbus);

		(previousButton = rdbtnJava).setSelected(true);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(10, 37, 294, 181);
		contentPanel.add(desktopPane);

		JInternalFrame internalFrame = new JInternalFrame("Frame Test");

		internalFrame.setMaximizable(true);
		internalFrame.setIconifiable(true);
		internalFrame.setBounds(32, 23, 185, 136);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JButton btnButton = new JButton("Button");
		btnButton.setBounds(39, 34, 89, 31);
		internalFrame.getContentPane().add(btnButton);
		internalFrame.setVisible(true);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						greetingService.uptemplate(bg.getSelection().getActionCommand());
						JOptionPane.showMessageDialog(null, "Please Restart the Application", "Restart", JOptionPane.INFORMATION_MESSAGE);
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
		// //////Change Template End/////
	}

	// ////////// Refresh window Start//////
	class LNFSetter implements ActionListener {
		String theLNFName;

		JRadioButton thisButton;

		/** Called to setup for button handling */
		LNFSetter(String lnfName, JRadioButton me) {
			theLNFName = lnfName;
			thisButton = me;

		}

		/** Called when the button actually gets pressed. */
		public void actionPerformed(ActionEvent e) {
			try {
				UIManager.setLookAndFeel(theLNFName);
				SwingUtilities.updateComponentTreeUI(contentPanel);

			} catch (Exception evt) {
				JOptionPane.showMessageDialog(null, "setLookAndFeel didn't work: " + evt, "UI Failure", JOptionPane.INFORMATION_MESSAGE);
				previousButton.setSelected(true); // reset the GUI to agree
			}
			previousButton = thisButton;
		}
	}

}
// //////////Refresh window End//////
package com.project.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.client.GreetingService;
import com.project.rss.RssFeed;
import com.project.ui.LookAndFeel;

public class Teachers {

	private JFrame frame;

	private LookAndFeel lookandfeel;

	private RssFeed rss;

	
        
        private Timer timer11;
        private Timer timer22;
        private Timer timer33;
        private Timer timer44;


	private String[] arr ;
        private String[] arr3;
        private String[] arr2;
        private String[] arr4;

	private JLabel FirstLabel;
	private JLabel ThirdLabel;
	private JLabel SecondLabel;
	private JLabel FourLabel;
	private JLabel FiveLabel;

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
					Teachers window = new Teachers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Teachers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// ///Desktop Start////
		lookandfeel = new LookAndFeel();

		
                timer11 = new Timer(0, null);
                timer22 = new Timer(0, null);
                timer33 = new Timer(0, null);
                timer44 = new Timer(0, null);

		frame = new JFrame("S&T Messages");
		frame.setBounds(250, 0, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/com/project/pic/mes.png")));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		rss = new RssFeed();
		rss.setBounds(0, 0, 972, 44);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(95, 158, 160));
		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 0;
		panel.add(desktopPane, gbc_desktopPane);

		JInternalFrame FirstlFrame = new JInternalFrame(
				greetingService.SelTeacherName(1));
		FirstlFrame.setIconifiable(true);
		FirstlFrame.setMaximizable(true);
		FirstlFrame.setResizable(true);
		FirstlFrame.setFrameIcon(new ImageIcon(getClass().getResource(
				"/com/project/pic/mes.png")));
		FirstlFrame.setBounds(10, 11, 239, 588);
		desktopPane.add(FirstlFrame);
		GridBagLayout gridBagLayout_1 = new GridBagLayout();
		gridBagLayout_1.columnWidths = new int[] { 0, 0 };
		gridBagLayout_1.rowHeights = new int[] { 0, 0 };
		gridBagLayout_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		FirstlFrame.getContentPane().setLayout(gridBagLayout_1);

		FirstLabel = new JLabel();

		GridBagConstraints gbc_FirstLabel = new GridBagConstraints();
		gbc_FirstLabel.gridx = 0;
		gbc_FirstLabel.gridy = 0;
		FirstlFrame.getContentPane().add(FirstLabel, gbc_FirstLabel);
ActionListener up = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                            //arr = new String[5];
		arr = greetingService.getthtml(greetingService.SelTeacherName(1))
				.toArray(
						new String[greetingService.getthtml(
								greetingService.SelTeacherName(1)).size()]);
                
                
				if (!greetingService
						.getthtml(greetingService.SelTeacherName(1)).isEmpty()) {

					FirstLabel.setText(arr[i]);
					System.out.println(arr[i]);
					i++;
					if (i >= arr.length) { // loop

						i = 0;
					}

				} else
					FirstLabel
							.setText("<html><center><h2>No Messages</h2></center></html>");
			}

			private int i = 0;// /// loop

		
                        
                };
		timer11.setDelay(13000);// ///refresh miliseconds
		timer11.addActionListener(up);
		timer11.start();

		

		JInternalFrame ThirdlFrame = new JInternalFrame(
				greetingService.SelTeacherName(3));
		ThirdlFrame.setResizable(true);
		ThirdlFrame.setMaximizable(true);
		ThirdlFrame.setIconifiable(true);
		ThirdlFrame.setFrameIcon(new ImageIcon(getClass().getResource(
				"/com/project/pic/mes.png")));
		ThirdlFrame.setBounds(753, 11, 245, 297);
		desktopPane.add(ThirdlFrame);
		GridBagLayout gridBagLayout_3 = new GridBagLayout();
		gridBagLayout_3.columnWidths = new int[] { 0, 0 };
		gridBagLayout_3.rowHeights = new int[] { 0, 0 };
		gridBagLayout_3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout_3.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		ThirdlFrame.getContentPane().setLayout(gridBagLayout_3);

		ThirdLabel = new JLabel();
		GridBagConstraints gbc_ThirdLabel = new GridBagConstraints();
		gbc_ThirdLabel.gridx = 0;
		gbc_ThirdLabel.gridy = 0;
		ThirdlFrame.getContentPane().add(ThirdLabel, gbc_ThirdLabel);

                
                ActionListener up2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                           // arr3 = new String[5];
		 arr3 = greetingService.getthtml(greetingService.SelTeacherName(3))
				.toArray(
						new String[greetingService.getthtml(
								greetingService.SelTeacherName(3)).size()]);

		
				if (!greetingService
						.getthtml(greetingService.SelTeacherName(3)).isEmpty()) {

					ThirdLabel.setText(arr3[i]);
					System.out.println(arr3[i]);
					i++;
					if (i >= arr3.length) { // loop

						i = 0;
					}

				} else
					ThirdLabel
							.setText("<html><center><h2>No Messages</h2></center></html>");
			}

			private int i = 0;// /// loop

		
                  
                };
		timer22.setDelay(15000);// ///refresh miliseconds
		timer22.addActionListener(up2);
		timer22.start();
                

		JInternalFrame SecondlFrame = new JInternalFrame(
				greetingService.SelTeacherName(2));
		SecondlFrame.setResizable(true);
		SecondlFrame.setIconifiable(true);
		SecondlFrame.setMaximizable(true);
		SecondlFrame.setFrameIcon(new ImageIcon(getClass().getResource(
				"/com/project/pic/mes.png")));
		SecondlFrame.setBounds(259, 11, 484, 588);
		desktopPane.add(SecondlFrame);
		GridBagLayout gridBagLayout_2 = new GridBagLayout();
		gridBagLayout_2.columnWidths = new int[] { 0, 0 };
		gridBagLayout_2.rowHeights = new int[] { 0, 0 };
		gridBagLayout_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout_2.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		SecondlFrame.getContentPane().setLayout(gridBagLayout_2);

		SecondLabel = new JLabel("");
		GridBagConstraints gbc_SecondLabel = new GridBagConstraints();
		gbc_SecondLabel.gridx = 0;
		gbc_SecondLabel.gridy = 0;
		SecondlFrame.getContentPane().add(SecondLabel, gbc_SecondLabel);

                
                ActionListener up3 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                            //arr2 = new String[5];
		 arr2 = greetingService.getthtml(greetingService.SelTeacherName(2))
				.toArray(
						new String[greetingService.getthtml(
								greetingService.SelTeacherName(2)).size()]);

		
				if (!greetingService
						.getthtml(greetingService.SelTeacherName(2)).isEmpty()) {

					SecondLabel.setText(arr2[i]);
					System.out.println(arr2[i]);
					i++;
					if (i >= arr2.length) { // loop

						i = 0;
					}

				} else
					SecondLabel
							.setText("<html><center><h2>No Messages</h2></center></html>");
			}

			private int i = 0;// /// loop

		
                  
                };
		timer33.setDelay(17000);// ///refresh miliseconds
		timer33.addActionListener(up3);
		timer33.start();

		JInternalFrame FourlFrame = new JInternalFrame(
				greetingService.SelTeacherName(4));
		FourlFrame.setResizable(true);
		FourlFrame.setMaximizable(true);
		FourlFrame.setIconifiable(true);
		FourlFrame.setFrameIcon(new ImageIcon(getClass().getResource(
				"/com/project/pic/mes.png")));
		FourlFrame.setBounds(753, 319, 245, 280);
		desktopPane.add(FourlFrame);
		GridBagLayout gridBagLayout_4 = new GridBagLayout();
		gridBagLayout_4.columnWidths = new int[] { 0, 0 };
		gridBagLayout_4.rowHeights = new int[] { 0, 0 };
		gridBagLayout_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout_4.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		FourlFrame.getContentPane().setLayout(gridBagLayout_4);

		FourLabel = new JLabel("");
		GridBagConstraints gbc_FourLabel = new GridBagConstraints();
		gbc_FourLabel.gridx = 0;
		gbc_FourLabel.gridy = 0;
		FourlFrame.getContentPane().add(FourLabel, gbc_FourLabel);

                
                ActionListener up4 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                            //arr4 = new String[5];
		 arr4 = greetingService.getthtml(greetingService.SelTeacherName(4))
				.toArray(
						new String[greetingService.getthtml(
								greetingService.SelTeacherName(4)).size()]);

		
				if (!greetingService
						.getthtml(greetingService.SelTeacherName(4)).isEmpty()) {

					FourLabel.setText(arr4[i]);
					System.out.println(arr4[i]);
					i++;
					if (i >= arr4.length) { // loop

						i = 0;
					}

				} else
					FourLabel
							.setText("<html><center><h2>No Messages</h2></center></html>");
			}

			private int i = 0;// /// loop

		
                  
                };
		timer44.setDelay(19000);// ///refresh miliseconds
		timer44.addActionListener(up4);
		timer44.start();

		JInternalFrame FivelFrame = new JInternalFrame(
				greetingService.SelTeacherName(5));
		FivelFrame.setIconifiable(true);
		FivelFrame.setBounds(10, 610, 988, 74);
		FivelFrame.setFrameIcon(new ImageIcon(getClass().getResource(
				"/com/project/pic/mes.png")));
		desktopPane.add(FivelFrame);
		GridBagLayout gridBagLayout_5 = new GridBagLayout();
		gridBagLayout_5.columnWidths = new int[] { 0, 0 };
		gridBagLayout_5.rowHeights = new int[] { 0, 0 };
		gridBagLayout_5.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout_5.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		FivelFrame.getContentPane().setLayout(gridBagLayout_5);

		JPanel panelRss = new JPanel();
		GridBagConstraints gbc_panelRss = new GridBagConstraints();
		gbc_panelRss.fill = GridBagConstraints.BOTH;
		gbc_panelRss.gridx = 0;
		gbc_panelRss.gridy = 0;
		panelRss.setLayout(null);
		panelRss.add(rss);
		FivelFrame.getContentPane().add(panelRss, gbc_panelRss);

		FivelFrame.setVisible(true);
		FourlFrame.setVisible(true);
		SecondlFrame.setVisible(true);
		ThirdlFrame.setVisible(true);
		FirstlFrame.setVisible(true);
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

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}

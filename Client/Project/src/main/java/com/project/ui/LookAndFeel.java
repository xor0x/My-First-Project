package com.project.ui;

///////////Template for all//////
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.client.GreetingService;

public class LookAndFeel extends JPanel {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application_context.xml");
	GreetingService greetingService = (GreetingService) ctx.getBean("greetingService");

	public LookAndFeel() {

		try {
			UIManager.setLookAndFeel(greetingService.seltemplate());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createTheGUIComponents();
			}

			private void createTheGUIComponents() {
			}
		});

	}

}

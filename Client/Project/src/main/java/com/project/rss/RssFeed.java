package com.project.rss;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.project.client.GreetingService;

public class RssFeed extends JPanel {

	private static String[] news = null;
	private static String[] news2 = null;

	private Timer timer;

	private JLabel lblRss;

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application_context.xml");
	GreetingService greetingService = (GreetingService) ctx.getBean("greetingService");


	public RssFeed() {
		setLayout(null);
		news = new String[5];
		news2 = new String[5];
		timer = new Timer(0, null);

		lblRss = new JLabel();
		lblRss.setBackground(new Color(255, 255, 255));
		lblRss.setVerticalAlignment(SwingConstants.TOP);
		lblRss.setForeground(new Color(0, 0, 0));
		lblRss.setFont(new Font("David", Font.BOLD | Font.ITALIC, 20));
		lblRss.setHorizontalAlignment(SwingConstants.LEFT);
		lblRss.setBounds(0, 0, 870, 85);
		add(lblRss);

		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();// /dlya
																								// vvoda
																								// xml
			URL u = new URL(greetingService.selrss()); // feed url
			Document doc = builder.parse(u.openStream());// / documnt xml
			NodeList nodes = doc.getElementsByTagName("item");
			for (int i = 0; i < nodes.getLength(); i++) {// // zikl dlya vivoda
															// novostey
				Element element = (Element) nodes.item(i);// / kakoy elemnt iz
															// novostey
				news[i] = getElementValue(element, "title"); // // Vivod
																// zagolovok
																// novostey

			}// for
			news2 = news;

			ActionListener updater = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					lblRss.setText(news2[i]);
					// System.out.println(news2[i]);
					i++;
					if (i >= news2.length) { // // loop
						i = 0;
					}
				}

				private int i = 0;// /// loop
			};
			timer.setDelay(7000);// ///refresh miliseconds
			timer.addActionListener(updater);
			timer.start();

		}// try
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static String getCharacterDataFromElement(Element e) {
		try {
			Node child = e.getFirstChild();// //////////////
			if (child instanceof CharacterData) {// ///////
				CharacterData cd = (CharacterData) child;// //
				return cd.getData();// /////////////////////
			}
		} catch (Exception ex) {// /////////////////

		}
		return "";// ////////////////////////////////
	}

	protected float getFloat(String value) {// //////////////////
		if (value != null && !value.equals(""))// ////////////////
			return Float.parseFloat(value);// /////////////
		else
			return 0;
	}

	protected static String getElementValue(Element parent, String label) {// ///////
		return getCharacterDataFromElement((Element) parent.getElementsByTagName(label).item(0));// ////////
	}
	// public static void main(String[] args) {
	// RssFeed reader = new RssFeed();
	//
	// }

}

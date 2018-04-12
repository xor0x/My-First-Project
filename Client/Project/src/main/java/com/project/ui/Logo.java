package com.project.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Logo extends JPanel {
	private JLabel lbllogo;
	private int x;
	private int y;
	private int width;
	private int height;
	private Color bg;

	public Logo() {
	}

	public Logo(int x, int y, int width, int height, Color bg) {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setBackground(bg);
		this.lbllogo = new JLabel("S&T Message");
		this.lbllogo.setForeground(new Color(30, 144, 255));
		this.lbllogo.setFont(new Font("Snap ITC", Font.ITALIC, 40));
		this.lbllogo.setIcon(new ImageIcon(getClass().getResource(
				"/com/project/pic/logo.jpg")));
		this.lbllogo.setBounds(139, 0, 1096, 98);
		this.add(lbllogo);

	}
}
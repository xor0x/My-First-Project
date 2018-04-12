package com.project.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyJButton extends JButton {

	private String text;
	private String font;
	private int style;
	private int size;
	private int x;
	private int y;
	private int width;
	private int height;
	private String pic;
	private Color color;

	public MyJButton() {
	}

	public MyJButton(String text, String font, int style, int size, int x, int y, int width, int height) {
		super();
		this.text = text;
		this.font = font;
		this.style = style;
		this.size = size;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		this.setText(text);
		this.setFont(new Font(font, style, size));
		this.setBounds(x, y, width, height);
	}

	public MyJButton(String text, String pic, Color color, int x, int y, int width, int height) {
		super();
		this.text = text;
		this.pic = pic;
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		this.setText(text);
		this.setIcon(new ImageIcon(getClass().getResource(pic)));
		this.setForeground(color);
		this.setFocusPainted(false);
		this.setBounds(x, y, width, height);
		// btnTemplate.setContentAreaFilled(false);
	}

}

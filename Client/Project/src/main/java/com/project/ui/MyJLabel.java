package com.project.ui;

import java.awt.Font;

import javax.swing.JLabel;

public class MyJLabel extends JLabel {

	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	private String font;
	private int style;
	private int size;

	public MyJLabel() {
	}

	public MyJLabel(String text, int x, int y, int width, int height, String font, int style, int size) {
		super();
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.font = font;
		this.style = style;
		this.size = size;

		this.setText(text);
		this.setBounds(x, y, width, height);
		this.setFont(new Font(font, style, size));
	}

}

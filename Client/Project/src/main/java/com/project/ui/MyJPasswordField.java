package com.project.ui;

import javax.swing.JPasswordField;

public class MyJPasswordField extends JPasswordField {

	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	private int columns;

	public MyJPasswordField() {
	}

	public MyJPasswordField(String text, int x, int y, int width, int height, int columns) {
		super();
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.columns = columns;

		this.setText(text);
		this.setBounds(x, y, width, height);
		this.setColumns(columns);
	}

}

package com.project.ui;

import javax.swing.JTextField;

public class MyJTextField extends JTextField {
	private String text;
	private int x;
	private int y;
	private int width;
	private int height;
	private int columns;

	public MyJTextField() {
	}

	public MyJTextField(String text, int x, int y, int width, int height, int columns) {
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

}

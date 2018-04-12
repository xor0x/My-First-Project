package com.project.ui;

import java.awt.Color;

import javax.swing.JPanel;

public class MyJPanel extends JPanel {

	private int x;
	private int y;
	private int width;
	private int height;
	private Color bg;

	public MyJPanel() {

	}

	public MyJPanel(int x, int y, int width, int height, Color bg) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.bg = bg;

		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(bg);
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

	public Color getBg() {
		return bg;
	}

	public void setBg(Color bg) {
		this.bg = bg;
	}

}

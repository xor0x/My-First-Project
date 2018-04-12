package com.project.ui;

import java.awt.Color;

import javax.swing.JDesktopPane;

public class MyJDesktopPane extends JDesktopPane {

	private int x;
	private int y;
	private int width;
	private int height;
	private Color bg;

	public MyJDesktopPane() {
	}

	public MyJDesktopPane(int x, int y, int width, int height, Color bg) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.bg = bg;

		this.setBounds(x, y, width, height);
		this.setBackground(bg);
	}

}

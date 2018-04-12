package com.project.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class MyJInternalFrame extends JInternalFrame {

	private String title;
	private String pic;
	private int color1;
	private int color2;
	private int color3;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean resizable;
	private boolean iconifiable;

	public MyJInternalFrame() {
	}

	public MyJInternalFrame(String title, String pic, int color1, int color2, int color3, int x, int y, int width, int height, boolean resizable, boolean iconifiable) {
		super();
		this.title = title;
		this.pic = pic;
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.resizable = resizable;
		this.iconifiable = iconifiable;

		this.setTitle(title);
		this.setVisible(true);
		this.setResizable(resizable);
		this.setIconifiable(iconifiable);
		this.setFrameIcon(new ImageIcon(getClass().getResource(pic)));
		this.setBounds(x, y, width, height);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(color1, color2, color3));
	}

}

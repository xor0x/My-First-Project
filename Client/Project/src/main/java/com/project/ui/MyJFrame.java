package com.project.ui;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class MyJFrame extends JFrame {
	private String title;
	private String pic;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean resizable;

	public MyJFrame() {

	}

	public MyJFrame(String title, String pic, int x, int y, int width, int height, boolean resizable) {
		super();
		this.title = title;
		this.pic = pic;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.resizable = resizable;
		this.setTitle(title);
		this.setResizable(resizable);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(pic)));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setBounds(x, y, width, height);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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

	public boolean isResizable() {
		return resizable;
	}

	public void setResizable(boolean resizable) {
		this.resizable = resizable;
	}

}

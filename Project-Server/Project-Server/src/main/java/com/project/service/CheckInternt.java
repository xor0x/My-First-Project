package com.project.service;

import java.net.URL;
import java.net.URLConnection;

public class CheckInternt {

	public boolean check() {
		boolean connectivity;
		try {
			URL url = new URL("http://www.ynet.co.il/");
			URLConnection conn = url.openConnection();
			conn.connect();
			connectivity = true;
		} catch (Exception e) {
			connectivity = false;
		}
		return connectivity;
	}
}

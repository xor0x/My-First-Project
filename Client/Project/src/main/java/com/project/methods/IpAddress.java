package com.project.methods;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddress {
	
	public String ip(){
	 InetAddress ip = null;
	  try {

		ip = InetAddress.getLocalHost();
		

	  } catch (UnknownHostException e) {

		e.printStackTrace();

	  }
	  return ip.getHostAddress();
	}

}

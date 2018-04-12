package com.project.test;

public class Logins {
	private static String name;
	
	
	public Logins(){
		name = new String();
	}


	public static String getName() {
		return name;
	}


	public static void setName(String name) {
		Logins.name = name;
	}


	
}

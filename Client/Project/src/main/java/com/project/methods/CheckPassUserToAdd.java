package com.project.methods;

public class CheckPassUserToAdd {
	// ////CheckPass on AddUser Start////
	public boolean pass(String num1, String num2) {
		boolean pas = false;
		if (num1.equals(num2))
			pas = true;
		return pas;
	};

}

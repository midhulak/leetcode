package com.snc.okta;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {
	
	private static final Pattern DEMO_FOLDERS = Pattern.compile("/unload.demo|/unload", Pattern.CASE_INSENSITIVE);
	private static final Pattern DEMOFILES_TOCHECK = Pattern.compile("/sys_user.xml", Pattern.CASE_INSENSITIVE);
	private static final Pattern EMPTYPASSWORD_CHECK = Pattern.compile("<user_password></user_password>",
			Pattern.CASE_INSENSITIVE);
	
	public void findMatch() {
		
		Matcher demoFolders = DEMO_FOLDERS.matcher("midhula");

		if (demoFolders.find()) {
			//write your logic...
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

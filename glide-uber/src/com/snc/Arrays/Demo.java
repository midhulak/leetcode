package com.snc.Arrays;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	
	Pattern p = Pattern.compile("\"([^\"]*)\"");
	Matcher m = p.matcher("data.allNotifications = 'all-notifications'");
	while (m.find()) {
	  System.out.println(m.group(1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

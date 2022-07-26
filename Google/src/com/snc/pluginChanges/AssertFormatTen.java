package com.snc.pluginChanges;

import java.util.ArrayList;
import java.util.List;

public class AssertFormatTen {
	
	public static String format(int num) {
		List<String> parts = new ArrayList<>();
		
		while(num != 0) {
			
			int mod = num % 1000;
			num = num/1000;
			parts.add(0,String.format("%03d", mod));
		}
		return parts.isEmpty() ? "0" : String.join("," , parts);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
assert format(1000).equals("1,000");
		System.out.println(format(100));
		System.out.println(format(100000));
		System.out.println(format(0));
		System.out.println(format(1000));
		
	}

}

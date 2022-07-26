package com.snc.affirm;

public class DemoSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "timer";
		String s1 = "mer";
		

		int index1=s.lastIndexOf(s1);
		
		
		System.out.println("index1 is="+index1);
		System.out.println(s.substring(index1));
		System.out.println(s.substring(index1).equals(s1));
			
		}
				

	}



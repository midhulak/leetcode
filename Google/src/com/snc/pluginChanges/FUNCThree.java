package com.snc.pluginChanges;

import java.util.ArrayList;
import java.util.List;

public class FUNCThree {

	
	public static void func(int a , List<Integer> b) {
		a+=1;
		b.add(1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a =0;
		List<Integer> b = new ArrayList<>();
		func(a , b);
		System.out.println(a + b.toString());
		

	}

}

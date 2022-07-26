package com.snc.pluginChanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HasPOSNEGTWO {
	
	public static Boolean[] hasPosNeg() {
		
		//List<Integer> list= Arrays.asList(0,-1,-2);
		List<Integer> list= Arrays.asList(-1,0,1);
		//List<Integer> list= Arrays.asList(0,1,2);
		
		
		boolean hasPos = false;
		boolean hasNeg = false;
		
		for(int i=0; i< list.size(); i++) {
			hasPos = list.get(i) > 0;
			hasNeg = list.get(i) < 0;
		}
		
		return new Boolean[] {hasPos , hasNeg};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Boolean[] b = hasPosNeg();
		System.out.println(b[0]+" "+b[1]);
	
	

	}

}

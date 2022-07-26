package com.snc.pluginChanges;

import java.util.Arrays;

public class SortThirteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] y = {"1" , "2" , "15" , "-7" , "300" };
		Arrays.sort(y);
		for(int i=0 ; i<y.length; i++) {
			System.out.print(y[i]+",");
		}
	}

}

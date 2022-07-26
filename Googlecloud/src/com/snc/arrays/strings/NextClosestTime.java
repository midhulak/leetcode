package com.snc.arrays.strings;

import java.util.HashSet;

public class NextClosestTime {
	
	public String nextClosestTime(String time) {
		//converting hours into minutes
		int minutes = Integer.parseInt(time.substring(0,2)) * 60;
		
		minutes+= Integer.parseInt(time.substring(3));
		System.out.println(minutes);
		//adding everything into set.
		
		HashSet<Integer> set = new HashSet<>();
		
		char[] c = time.toCharArray();
		
		for(char ch : c) {
			System.out.println(ch);
		}
		
		for(char c1 : time.toCharArray()) {
			set.add(c1 - '0');
		}
		
		for(Integer i : set) {
			System.out.println(i);
		}
		
		System.out.println(':' - '0');
		
		while(true) {
			//add just 1 minute to the current minutes 
			minutes = (minutes + 1) % (24 * 60);
			System.out.println(minutes);
			//convert that 1 minute to hh:MM format 
			//for total minutes convert to hour we have to use minutes%60 to get left most we have to use divide by 10 and to get 
			//right most digit have to use % 10
			//similarly after converting minute steh left over minutes we have to use minutes%60 (because /60 has given the hours the remaining one is teh minues
			//and to get 1st digit after colon have to use /10 and last digit have to use % 10.
			int[] nextTime = {minutes/60/10 , minutes/60 % 10 , minutes % 60 / 10 , minutes % 60 % 10};
			
			System.out.println(nextTime[0]+" "+nextTime[1] + " "+nextTime[2] + " "+nextTime[3]);
			
			boolean isValid = true;
			//check each digit in that newly added 1 minute is in the set or not if set do not 
			//have taht again add 1 more minute and check
			for(int digit : nextTime) {
				if(!set.contains(digit)) {
					isValid = false;
				}
			}
			
			if(isValid) {
				return String.format("%02d:%02d", minutes/60 , minutes%60);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NextClosestTime n = new NextClosestTime();
		n.nextClosestTime("19:34");

	}
}
	
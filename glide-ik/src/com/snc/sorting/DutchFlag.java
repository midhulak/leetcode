package com.snc.sorting;

public class DutchFlag {
	
	
	public void dutchFlag(char[] balls) {
		
		
		//give first half to red and last to blue
		//so set 0 to red and blue to length-1 and also need current pointer
		//if it is red just move redpointer and also current pointer and swap and red is already in place
		//if it is green need to move just only current pointer
		//if it is blue need to swap with current pointer an dblue pointer
		//we can run this until current pointer <= blue pointer
		int n = balls.length;
		int red=0;
		int blue=n-1;
		
		int current_idx=0;
		
		
		while(current_idx <= blue) {
			
			if(balls[current_idx] == 'R') {
				
				swap(balls , current_idx , red);
				current_idx++;
				red++;
			}
			
			else if(balls[current_idx] == 'G') {
				current_idx++;
			}
			else {
				swap(balls , current_idx , blue );
				
				blue--;
			}
		}
	}
	
	
	public static void swap(char[] balls , int left , int right ) {
		char temp = balls[left];
		balls[right] = balls[left];
		balls[left] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

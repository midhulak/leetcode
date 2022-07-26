package com.arrays;

public class BulbSwitcherII {
	
	 public int flipLights(int n, int m) {
	        if(m==0)return 1;
	        if(m==1){
	            if(n==1)return 2;
	            if(n==2)return 3;
	            return 4;
	        }
	        if(m==2){
	            if(n==1)return 2;
	            if(n==2)return 4;
	            return 7;
	        }
	        if(m>=3){
	            if(n==1)return 2;
	            if(n==2)return 4;
	            return 8;
	        }
	        return 0;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

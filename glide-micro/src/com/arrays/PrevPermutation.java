package com.arrays;

public class PrevPermutation {
	
	  public int[] prevPermOpt1(int[] arr) {
	       int last=arr.length-1;
	        int prev=arr[last];
	        int i;
	        for( i=last-1;i>=0;i--) 
	            if(arr[i]>arr[i+1]) break; 
	        
	        if(i<=-1) return arr;
	        while(last>=0 && arr[last]>arr[i]) last--;
	       
	        if(arr[i]==arr[last]) swap(i,arr,i+1);
	        else swap(i,arr,last);
	        return arr;
	        
	        }
	    public void swap(int i,int[] arr,int last){
	        int temp=arr[i];
	        arr[i]=arr[last];
	        arr[last]=temp;
	    }
	        
	        

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrevPermutation  pre = new PrevPermutation();
		pre.prevPermOpt1(new int[] {3,2,1});
		
		
				

	}

}

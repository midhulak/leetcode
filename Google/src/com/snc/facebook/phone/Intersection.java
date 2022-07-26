package com.snc.facebook.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
	
	 public int[] intersect(int[] nums1, int[] nums2) {
	        
	        //applying binary search
	        Arrays.sort(nums1);
	       List<Integer> list = new ArrayList<>();
	        
	        for(int i=0 ; i< nums2.length; i++){
	            
	            int j=0;
	            int low =0; int high = nums1.length-1;
	            
	            
	            while(low <= high){
	                
	                int mid=high-(high-low)/2;
	                
	                if(mid == nums2[i]){
	                    list.add(nums2[i]);
	                    break;
	                }
	                
	                if(nums2[i] > mid){
	                    low++;
	                }
	                else{
	                    high--;
	                }
	            }
	            
	        }
	        
	        int[] result = new int[list.size()];
	        for(int i=0 ; i<list.size(); i++){
	            result[i] = list.get(i);
	        }
	        
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Intersection i = new Intersection();
		int nums1[] = {4,9,5};
			int nums2[]=	{9,4,9,8,4};
		
			i.intersect(nums1 , nums2);
			
	}

}

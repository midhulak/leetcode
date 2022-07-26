package com.snc.onsite.set1;

import java.util.HashMap;

public class FindInMountainArray {
	
	/**
	 * // This is MountainArray's API interface.
	 * // You should not implement it, or speculate about its implementation
	 * interface MountainArray {
	 *     public int get(int index) {}
	 *     public int length() {}
	 * }
	 */
	 
	    
	   
	        HashMap<Integer , Integer> map = new HashMap<>();
	        MountainArray mountainArr;
	        public int getMountainVal(int index){
	            if(map.containsKey(index))
	                return map.get(index);
	              map.put(index , mountainArr.get(index));
	        return map.get(index);
	        }
	        
	      
	        
	    
	    public int findInMountainArray(int target, MountainArray mountainArr) {
	        this.mountainArr = mountainArr;
	        int peak = getPeak(1, mountainArr.length()-1);
	        //once we get peak we are applying BS left side till to peak to get target index
	        int findTargetIndex  = findBSASC(0 , peak , target);
	        
	        if(findTargetIndex != -1)
	            return findTargetIndex;
	        
	        findTargetIndex = findBSDesc(peak , mountainArr.length()-1 , target);
	        
	        return findTargetIndex;
	    }
	    
	    
	    
	    public int getPeak(int lo , int hi){
	        
	        int mid = lo+(hi-lo)/2;
	        
	        //checking the exact peak  left side is less than mid and right side also  less than mid
	        
	        if(getMountainVal(mid) > getMountainVal(mid-1) && getMountainVal(mid) > getMountainVal(mid+1))
	            return mid;
	        //going staright line so going right to find the exact peak
	        if(getMountainVal(mid) > getMountainVal(mid-1) && getMountainVal(mid) < getMountainVal(mid+1))
	            return getPeak(mid+1 , hi);
	        //going all teh way down and to check exact peak moving left 
	             if(getMountainVal(mid) < getMountainVal(mid-1) && getMountainVal(mid) > getMountainVal(mid+1))
	               return getPeak(lo , mid-1);
	    
	        return -1;
	        
	    }
	    
	    public int findBSASC(int lo , int hi , int target){
	        
	      
	        
	        while(lo < hi){
	            
	            int mid = lo+(hi-lo)/2;
	            
	            if(getMountainVal(mid) == target){
	               return mid;
	            }
	            
	            if(getMountainVal(mid) > target){
	               hi = mid-1;
	                
	            }
	            else
	                lo = mid+1;
	        }
	        
	        return -1;
	    }
	    
	        
	    public int findBSDesc(int lo , int hi , int target){
	        
	      //9 8 7 6 5 4 3
	        
	        while(lo < hi){
	            
	            int mid = lo+(hi-lo)/2;
	            
	            if(mountainArr.get(mid) == target){
	               return mid;
	            }
	            
	            if(mountainArr.get(mid) > target){
	                lo = mid+1;
	            }
	            else
	                hi = mid-1;
	        }
	        
	        return -1;
	    }
	    
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

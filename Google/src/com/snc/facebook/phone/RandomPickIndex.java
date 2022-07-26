package com.snc.facebook.phone;

import java.util.Random;

public class RandomPickIndex {
	
	 Random rand = new Random();
	    Map<Integer , List<Integer> > map = new HashMap<>();

	    public Solution(int[] nums) {
	        for(int i=0; i<nums.length; i++){
	            
	            if(map.containsKey(nums[i])){
	                List<Integer> list = map.get(nums[i]);
	                list.add(i);
	                map.put(nums[i] , list);
	            }
	             else{
	                 List<Integer> list = new ArrayList<Integer>();
	                 list.add(i);
	                 map.put(nums[i] , list);
	             }
	        }
	        
	       
	        
	    }
	    
	    public int pick(int target) {
	        
	        if(map.containsKey(target)){
	            
	            List<Integer> list = map.get(target);
	            
	            int random =  rand.nextInt(list.size());
	            return list.get(random);
	        }
	        
	       return 0;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

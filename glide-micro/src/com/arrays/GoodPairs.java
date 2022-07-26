package com.arrays;

import java.util.List;
import java.util.Map;

public class GoodPairs {
	
  public int numIdenticalPairs1(int[] nums) {
  int count=0;
  for(int i=0; i<nums.length; i++){
     
     for(int j=0; j<nums.length; j++){
         if(nums[i] == nums[j] && i < j)
             count++;
     }
  }
  return count;
}


	public int numIdenticalPairs2s(int[] nums) {
        int result=0;
        
        Map<Integer ,List<Integer>> map = new HashMap<>();
        
        
        for(int i=0; i<nums.length; i++){
            
            if(map.containsKey(nums[i])){
                List<Integer> list = map.get(nums[i]);
                result+= list.size();
                list.add(i);
                map.put(nums[i] , list);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i] , list);
            }
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

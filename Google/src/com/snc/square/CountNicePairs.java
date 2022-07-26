package com.snc.square;

import java.util.HashMap;

public class CountNicePairs {
	

    //nums[i]+rev(nums[j] == nums[j]+rev(nums[i]))
    
  //  nums[i]-rev(nums[i]) = nums[j] - rev(nums[j])
    
    //take reverse of each number substarct it and put the difference of number and rev number in a map ...if same key appers again we can return taht as pair.and incrfement count
    public int countNicePairs(int[] nums) {
        int count=0;
        //int M=1e9+7;
        Map<Integer , Integer> map = new HashMap<Integer , Integer>();
        
        for(int i=0; i<nums.length; i++){
            
            int res = nums[i] - reverse(nums[i]);
            if(map.containsKey(res)){
                count+=(map.get(res))%100000007;
                map.put(res , map.get(res)+1);
            }
            else{
                map.put(res , 1);
            }
        
        }
        return count;
    }
    
    public int reverse(int num){
        int res = 0;
        while(num > 0){
             res = res*10+num%10;
            num=num/10;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
